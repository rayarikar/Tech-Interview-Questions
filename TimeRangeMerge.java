/**
Write a function condenseMeetingTimes() that takes an array of meeting time ranges and returns an array of condensed ranges.

i/p: [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
o/p: [(0, 1), (3, 8), (9, 12)]
**/

import java.util.*;
import java.lang.*;

class TimeRangeMerge {
    public static void main(String args[]) {
        List<int[]> inputList = new ArrayList();
        int[] interval = new int[]{0,1};
        inputList.add(interval);
        interval = new int[]{3,5};
        inputList.add(interval);
        interval = new int[]{4,8};
        inputList.add(interval);
        interval = new int[]{10,12};
        inputList.add(interval);
        interval = new int[]{9,10};
        inputList.add(interval);
        condenseMeetingTimes(inputList);
    }
    
    public static void condenseMeetingTimes(List<int[]> input) {
        System.out.println("Size of the list: " + input.size());
    }
}