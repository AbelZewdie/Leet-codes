package Strings.LeetCode_58;

public class LengthOfLastWord {


    public int lengthOfLastWord(String s){

        int lastIndex = s.length() - 1;         // output: 10
        int count = 0;

        for (int i = lastIndex; i >= 0; i--){
            char currentChar = s.charAt(i);         // grab the characters
            if (currentChar == ' ' && count > 0){             // decide what to do with currentChar
                break;
            }
            if (currentChar != ' '){
                count ++;
            }

        }

        return count;
    }
    public static void main(String[] args) {

        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

        System.out.println(lengthOfLastWord.lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord.lengthOfLastWord("luffy is still joyboy"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("a"));
    }
}
