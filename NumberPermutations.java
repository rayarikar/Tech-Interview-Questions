/*
Given an array of numbers, find all the permutations of the array.
input - [1,2,3]
output - [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
*/
import java.util.*;
import java.lang.*;

class NumberPermutations {
    
    public static void main(String args[]) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for (int i = 1; i < 4; i++){
            input.add(i);
        }
        permute(input, results, 0);
    }
    
    /*
    Logic - Compute all the permutations that begins with A[0]. That means 
    permute([1,2,3], [], 0)
    */
    public static void permute(List<Integer> input, List<List<Integer>> results, int i) {
        if (i == input.size() - 1) {
            results.add(new ArrayList<>(input));
            return;
        }
        
        for(int j = i; j < input.size(); j++) {
            Collections.swap(input, i, j);
            System.out.println("Swapped " + input.get(i) + " with " + input.get(j));
            // permute on sublist
            permute(input, results, i+1);
            // rever the list back to original state
            Collections.swap(input, i, j);
            System.out.println("Swapped back " + input.get(i) + " with " + input.get(j));
        }
        
        System.out.println("\nAll Permutations are: \n");
        for (List result: results) {
            System.out.println();
            for (int k = 0; k < result.size(); k++) {
                System.out.print(" " + result.get(k));
            }
        }
        System.out.println();
    }
}