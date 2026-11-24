package Arrays.Learning_Arrays;

import java.util.Scanner;

public class UserInputIntoArrays {

    public static void main(String[] args) {

        // to create an array with values
        // String [] foods = {"pizza", "taco", "hamburger"};

        /*
        // to create an array without values, just empty spaces and then put the values manually.
        String [] foods = new String[3];

        foods[0] = "Pizza";
        foods[1] = "taco";
        foods[2] = "hamburger";

        for (String food: foods){
            System.out.println(food);
        }
        */


        // to create an array without values, just empty spaces and then use the Scanner to put the values.
        Scanner scanner = new Scanner(System.in);

        String [] foods;
        int size;

        System.out.print("What # of food do you want?: ");
        size = scanner.nextInt();

        foods = new String[size];
        scanner.nextLine();

        for (int i = 0; i < foods.length; i++){
            System.out.print("Enter a food: ");
            foods[i] = scanner.nextLine();
        }

        for (String food : foods){
            System.out.println(food);
        }

        scanner.close();
    }
}
