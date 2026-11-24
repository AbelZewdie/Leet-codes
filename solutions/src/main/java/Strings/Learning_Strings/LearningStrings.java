package Strings.Learning_Strings;

public class LearningStrings {

    public static void main(String[] args) {

        // String = a reference data type that can store one or more characters.
        //          reference data types have access to useful methods.

        String name = "Abel";

        // boolean result = name.equalsIgnoreCase("abel");      // output: true
        // int result = name.length();                          // output: 4
        // char result = name.charAt(1);                        // output: b
        // int result = name.indexOf("b");                      // output: 1
        // boolean result = name.isEmpty();                     // output: false
        // String result = name.toUpperCase();                  // output: ABEL
        // String result = name.toLowerCase();                  // output: abel
        String result = name.trim();                         // output: Abel
        // String result = name.replace("A", "D");              // output: Dbel

        System.out.println(result);
    }
}
