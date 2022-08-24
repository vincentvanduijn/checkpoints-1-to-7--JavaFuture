package com.devoteam.VehicleApplication.repository;

import com.devoteam.VehicleApplication.conn.ConnectionFactory;
import com.devoteam.VehicleApplication.domain.Vehicle;
import com.devoteam.VehicleApplication.domain.VehicleTypeEnum;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j2
public class VehicleRepository {
    static Logger logger = Logger.getLogger(VehicleRepository.class.getName());

    public static List<Vehicle> findByNameAutomaker(String name) {
        log.info("Searching for all vehicles from automaker '{}'", name);
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementFindByNameAutomaker(conn, name);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                vehicleBuilder(vehicles, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "Error finding automaker by name");
        }
        return vehicles;
    }

    private static PreparedStatement createPreparedStatementFindByNameAutomaker(Connection conn, String name) throws SQLException {
        String sql = "SELECT v.name, v.color, v.id, v.year, v.type, v.created_on " +
                "FROM vehicle AS v INNER JOIN automaker AS a ON v.automaker_id = a.id WHERE a.name = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%s", name));
        return ps;
    }

    public static List<Vehicle> findByNameModel(String name) {
        log.info("Searching for all vehicle models named '{}'", name);
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementFindByNameModel(conn, name);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                vehicleBuilder(vehicles, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "Error finding vehicles by model name");
        }
        return vehicles;
    }

    private static PreparedStatement createPreparedStatementFindByNameModel(Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM auto_dealer.vehicle WHERE vehicle.name = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%s", name));
        return ps;
    }

    public static List<Vehicle> findAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementFindAll(conn);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                vehicleBuilder(vehicles, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "Error finding all vehicles in database");
        }
        return vehicles;
    }

    private static PreparedStatement createPreparedStatementFindAll(Connection conn) throws SQLException {
        String sql = "SELECT * FROM auto_dealer.vehicle;";
        return conn.prepareStatement(sql);
    }

    public static void removeVehicleByModel(Vehicle vehicle) {
        log.info("Removing vehicle named '{}' from database", vehicle.getModel());
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementRemoveVehicleByModel(conn, vehicle)) {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "Error removing vehicle(s) from database");
        }
    }

    private static PreparedStatement createPreparedStatementRemoveVehicleByModel(Connection conn, Vehicle vehicle) throws SQLException {
        String sql = "DELETE FROM auto_dealer.vehicle WHERE vehicle.id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, vehicle.getId());
        return ps;
    }

    public static void replaceVehicle(Vehicle vehicle) {
        log.info("Updating all vehicles named '{}' from database", vehicle.getModel());
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementUpdate(connection, vehicle)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static PreparedStatement createPreparedStatementUpdate(Connection conn, Vehicle vehicle) throws SQLException {
        String sql = "UPDATE vehicle AS v INNER JOIN automaker AS a ON v.automaker_id = a.id " +
                "SET v.name = ?, v.color = ?, v.year = ?, v.type = ?, v.created_on = ?, v.automaker_id = ?, v.id = v.id " +
                "WHERE v.id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vehicle.getModel());
        ps.setString(2, vehicle.getColor());
        ps.setInt(3, vehicle.getYear());
        ps.setString(4, String.valueOf(vehicle.getVehicleType()));
        ps.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
        ps.setInt(6, vehicle.getAutomaker().getId());
        ps.setInt(7, vehicle.getId());
        return ps;
    }

    public static int saveVehicle(Vehicle vehicle) {
        log.info("Saving vehicle model named '{}' in the database", vehicle.getModel());
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementSaveVehicle(conn, vehicle)) {
            ps.execute();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "Error saving vehicle in the database");
        }
        return -1;
    }

    private static PreparedStatement createPreparedStatementSaveVehicle(Connection conn, Vehicle vehicle) throws SQLException {
        String sql = "INSERT INTO auto_dealer.vehicle (vehicle.name, vehicle.color, vehicle.year, vehicle.type, vehicle.created_on, vehicle.automaker_id)" +
                " VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, vehicle.getModel());
        ps.setString(2, vehicle.getColor());
        ps.setInt(3, vehicle.getYear());
        ps.setString(4, String.valueOf(vehicle.getVehicleType()));
        ps.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
        ps.setInt(6, vehicle.getAutomaker().getId());
        return ps;
    }

    private static void vehicleBuilder(List<Vehicle> vehicles, ResultSet rs) throws SQLException {
        Vehicle vehicle = Vehicle
                .builder()
                .id(rs.getInt("id"))
                .model(rs.getString("name"))
                .color(rs.getString("color"))
                .year(rs.getInt("year"))
                .createdOn(rs.getDate("created_on"))
                .vehicleType(VehicleTypeEnum.valueOf(rs.getString("type")))
                .build();
        vehicles.add(vehicle);
    }
}
