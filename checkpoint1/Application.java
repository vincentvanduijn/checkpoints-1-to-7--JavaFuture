package Devoteam.Checkpoints.checkpoint1;

import java.util.Scanner;

public class Application {

  public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
  
      String[][] array1 = new String[6][4];
      array1[0][0] = "GM"; // main brand
      array1[0][1] = "Suburban";
      array1[0][2] = "Malibu";
      array1[0][3] = "Silverado";
  
      array1[1][0] = "Hyundai"; // main brand
      array1[1][1] = "Azera";
      array1[1][2] = "Sonata";
      array1[1][3] = "Veloster";
  
      array1[2][0] = "Volkswagen"; // main brand
      array1[2][1] = "Golf";
      array1[2][2] = "Jetta";
      array1[2][3] = "Polo";
  
      array1[3][0] = "Audi"; // main brand
      array1[3][1] = "A4";
      array1[3][2] = "Q7";
      array1[3][3] = "R8";
  
      array1[4][0] = "Mercedes"; // main brand
      array1[4][1] = "C 180";
      array1[4][2] = "C 200";
      array1[4][3] = "GLA 200";
  
      array1[5][0] = "Peugot";// main brand
      array1[5][1] = "206";
      array1[5][2] = "208";
      array1[5][3] = "2008";
  
      boolean looping = true;
  
      while (looping) {
        System.out.println("");
        System.out.println("Choose your automaker brand: \n");
        for (int i = 0; i < array1.length; i++) {
          System.out.println(i + 1 + ". " + array1[i][0]);
        }
        System.out.println("7. Exit Program");
        int automaker1 = input.nextInt();
  
        if (automaker1 >= 1 && automaker1 <= 6) {
          System.out.println(array1[automaker1-1][0] + ",");
          System.out.println("Available vehicles: ");
          for (int i = 1; i < array1[automaker1-1].length; i++) {
            System.out.println(i + ". " + array1[automaker1 - 1][i]);
          }
        } else if (automaker1 == 7) {
          System.exit(automaker1); // change to looping = false
        } else {
          System.out.println("Please, select on of the above automaker brands");
        }
  
        while (true) {
          Scanner input2 = new Scanner(System.in);
  
          System.out.println("");
          System.out.println("Do you wish to continue? \n");
          System.out.println("1. Yes");
          System.out.println("2. No");
  
          int continue1 = input2.nextInt();
  
          if (continue1 == 2) {
            looping = false;
            break;
          } else if (continue1 == 1) {
            break;
          } else {
            System.out.println("Please pick a valid option");
          }
  
        }
  
      }
  
    }
  
  }