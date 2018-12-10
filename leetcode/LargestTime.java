package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// Problem - 949. Largest Time for Given Digits
/*
Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.



Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""

Note:

A.length == 4
0 <= A[i] <= 9
 */
public class LargestTime {

    public String getLargestTime(List<Integer> numbers) {
        String largestTime = "";
        Collections.sort(numbers);

        // 1st digit of the hour -- look for 0, 1, 2
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) == 2 || numbers.get(i) == 1 || numbers.get(i) == 0) {
                largestTime += numbers.get(i);
                numbers.remove(numbers.get(i));
                break;
            }
        }
        // sanity check to ensure that some hour is atleast set
        if (numbers.size() > 3) {
            System.out.println("No hour set until now. Invalid state. Returning empty");
            return "";
        }

        // 2nd  digit of the hour - 4 if the other 2 are 0 else the max of the other 2
        List<Integer> filteredList = numbers.stream().filter(entry -> entry.equals(0)).collect(Collectors.toList());
        if (filteredList.size() == 2) {
            System.out.println("Found all 0s. Setting the 2nd hour to max");
            largestTime += numbers.get(2) + ":00";
            return largestTime;
        }
        largestTime += numbers.get(numbers.size() - 1) + ":";
        numbers.remove(numbers.get(numbers.size() - 1));

        // sanity check for hours
        if (numbers.size() > 2) {
            System.out.println("No hour set until now. Invalid state. Returning empty");
            return "";
        }

        // setting the minutes - check whichever is closest to 60 otherwise return empty
        int minuteCombinationOne = Integer.parseInt(numbers.get(0) + "" + numbers.get(1));
        int minuteCombinationTwo = Integer.parseInt(numbers.get(1) + "" + numbers.get(0));

        if (minuteCombinationOne > 60) {
            if (minuteCombinationTwo < 60) {
                largestTime += minuteCombinationTwo;
            } else {
                System.out.println("Invalid state as both minute combinations are greater than or equal to 60. Returning empty");
                return "";
            }
        }
        else if (minuteCombinationTwo > 60) {
            if (minuteCombinationOne < 60) {
                largestTime += minuteCombinationOne;
            } else {
                System.out.println("Invalid state as both minute combinations are greater than or equal to 60. Returning empty");
                return "";
            }
        }
        else {
            largestTime += (minuteCombinationOne > minuteCombinationTwo) ? minuteCombinationOne : minuteCombinationTwo;
        }

        return largestTime;
    }

    public static void main(String args[]) {
        LargestTime largestTime = new LargestTime();
        List<Integer> input = new LinkedList<>(Arrays.asList(2, 4, 3, 1));
        System.out.println("Expected: 24:31 -- Actual: " + largestTime.getLargestTime(input));
        input = new LinkedList<>(Arrays.asList(0, 4, 0, 2));
        System.out.println("Expected: 24:00 -- Actual: " + largestTime.getLargestTime(input));
        input = new LinkedList<>(Arrays.asList(1, 4, 3, 9));
        System.out.println("Expected: 19:43 -- Actual: " + largestTime.getLargestTime(input));
        input = new LinkedList<>(Arrays.asList(2, 0, 6, 9));
        System.out.println("Expected: 06:29 -- Actual: " + largestTime.getLargestTime(input));
    }
}
