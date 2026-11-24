package Arrays.Learning_Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LearningArrays {

    public static void main(String[] args) {

        // array = a collection of values of the same data type
        //         * think of it as a variable that can store more than 1 value *

        String[] fruits = {"apple", "orange", "banana", "coconut"};

        // fruits[0] = "pineapple";    // to modify an array.


        // int numOfFruits = fruits.length;   // to see the length of the array.


        // for loop
//        for (int i = 0; i < fruits.length; i++) {
//            System.out.print(fruits[i] + ", ");
//        }

        // Arrays.sort(fruits);         // to sort the arrays
        // Arrays.fill(fruits, "Pineapples");    // to fill the arrays

        // enhanced for loop
        for (String fruit: fruits){
            System.out.println(fruit);
        }
    }
}