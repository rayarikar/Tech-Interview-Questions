import java.util.*;
import java.lang.*;

class LongestUniqueString
{  
    public static void main(String args[])
    {
        // System.out.println(longestUniqueStringOptimized("roohjurqutyp"));
        System.out.println(longestUniqueStringOptimized("abcabcbb"));
    }
    
    /*
    Longest subarray with distinct entries 
    ip = {f, s, f, e, t, w, e, n, w, e}
    op = {s, f, e, t, w}
    O(n^2)
    */
    
    public static String longestUniqueSubString(String input) {
        Map inputMap = new HashMap<Character, Character>();
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            inputMap.clear();
            String temp = input.charAt(i) + "";
            inputMap.put(input.charAt(i), input.charAt(i));
            for (int j = i + 1; j < input.length(); j++) {
                if (inputMap.containsKey(input.charAt(j))) {
                    break;
                }
                else {
                    temp += input.charAt(j);
                    inputMap.put(input.charAt(j), input.charAt(j));
                }
            }
            if (temp.length() > result.length()) {
                result = temp;
            }
        }
        return result;
    }
    
    /*
    Logic- 
    The loop denotes the end pointer of the string. We do not care
    about the start or end pointer values. What we care about is the length
    
    Keep incrementing the end pointer
        if a new char is encountered add it to the map of char, index
            insert the char in map
            if the length of curr - start is greater than max, set this as the new max
        else
            increment the start value to last seen value in map + 1
            check if the curr - start is greater than max and if yes, set it as the max
    */
    public static String longestUniqueStringOptimized(String input) {
        Map inputMap = new HashMap<Character, Integer>();
        String result = "";
        int start = 0, max = 0, oldStart = 0;
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (inputMap.get(c) == null) {
                inputMap.put(c, i);
                if (i - start + 1 > max) {
                    max = i - start + 1;
                }
            } else {
                start = (int) inputMap.get(c) + 1;
                inputMap.put(c, i);
                if (i - start + 1 > max) {
                    max = i - start + 1;
                }
            }
        }
        System.out.println("Longest unique substring length: " + max + "\nStart: " + start);
        return result;
    }
    
}