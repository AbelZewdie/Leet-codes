package Arrays.Learning_Arrays;

import java.util.Scanner;

public class SearchingAnArray {

    public static void main(String[] args) {

        // to find an integer.
        /*

        int[] numbers = {1, 9, 2, 8, 3, 5, 4};
        int target = 2;
        boolean isFound = false;

        for (int i = 0; i < numbers.length; i++){
            if (target == numbers[i]){
                System.out.println("Element found at index: " + i);
                isFound = true;
                break;
            }
        }

        if (!isFound){
            System.out.println("Element not found in the array.");
        }
         */

        Scanner scanner = new Scanner(System.in);

        String[] fruits = {"apple", "orange", "banana"};
        boolean isFound = false;
        String target;

        System.out.print("What are you trying to look for?: ");
        target = scanner.nextLine();

        for (int i = 0; i < fruits.length; i++){
            if (fruits[i].equals(target)){
                System.out.println("Element is found at index: " + i);
                isFound = true;
                break;
            }
        }

        if (!isFound){
            System.out.println("Element not found in the array.");
        }

        scanner.close();
    }
}
