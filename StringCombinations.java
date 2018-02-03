import java.lang.*;
import java.util.*;

/**
Given a string abc print all the 6 different combinations of the string
abc acb bac bca cab cba
**/

class StringCombinations {
    public static void main(String[] args) {
        combinations("","abcd");
    }
    
    public static void combinations(String combination, String input) {
        if (input.length() == 0) {
            System.out.println(combination);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            String newCombination = combination + input.charAt(i);
            String newInput = input.substring(0, i) + input.substring(i + 1, input.length());
            combinations(newCombination, newInput);
        }
    }
}