package Strings.LeetCode_14;

public class LongestCommonPrefix {

    // Logic:

    // 1. pick a character position i from the first word ( strs[0] )
    // 2. check every other word in strs at that same position i.
    // 3. If a word runs out of characters ( i >= word.length() ) or has a different character, stop and return the prefix we've matched so far.

    // Input: strs = ["flower","flow","flight"]

    public String longestCommonPrefix(String[] strs) {

        String firstWord = strs[0];

        for (int i = 0; i < firstWord.length(); i++){
            char currentChar = firstWord.charAt(i);

            for (int j = 1; j < strs.length; j++){
                String currentWord = strs[j];
                if ( i >= currentWord.length() || currentWord.charAt(i) != currentChar){
                    return firstWord.substring(0, i);
                }
            }
        }
        return firstWord;
    }

    public static void main(String[] args) {

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // Expected: "fl"
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));    // Expected: ""
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flow", "flower"}));           // Expected: "flow"
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog"}));                      // Expected: "dog"
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{""}));
    }
}
