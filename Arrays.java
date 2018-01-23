import java.util.*;
import java.lang.*;

class Arrays{
    public static void main(String args[]) {
        int[] input = new int[]{1,2,3,4,5};
        subArraySum(input, 5);
    }
    
    /*
    input ==> [1,2,3,4,5], sum = 5
    output ==> [1, 4]
    */
    public static void subArraySum(int[] input, int sum) {
        System.out.println("Evaluating: ");
        for(int i : input) {
            System.out.print(i + " ");
        }
        System.out.println("\nTarget Sum: " + sum + "\n");
        
        Map<Integer, Integer> subArrayMap = new HashMap<Integer, Integer>();
        for (int i : input) {
            int diff = sum - i;
            if (subArrayMap.containsKey(diff)) {
                System.out.println("Pair of subArray adding upto the sum: [" + i + ", " + diff + "]");
                return;
            }
            if (diff > 0) {
                subArrayMap.put(i, diff);
            }
        }
        
    }
}