/**
    On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

    Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

    Examples:
    Input: N = 1, K = 1
    Output: 0

    Input: N = 2, K = 1
    Output: 0

    Input: N = 2, K = 2
    Output: 1

    Input: N = 4, K = 5
    Output: 1

    Explanation:
    row 1: 0
    row 2: 01
    row 3: 0110
    row 4: 01101001
    Note:

    N will be an integer in the range [1, 30].
    K will be an integer in the range [1, 2^(N-1)].
**/
import java.util.*;

class Solution {
    public int kthGrammar(int N, int K) {
        if (N < 1 || N > 30) {
            return -1;
        }
        int kUpperBound = (int) Math.pow(2, N - 1);
        if (K < 1 || K > kUpperBound) {
            return -1;
        }
        // to make it index compatible, decrement the count of N and K by 1 since its 1-indexed
        K--;
        N--;
        List<String> formedList = new ArrayList<String>();
        // populate the first element in the list
        if (N >= 0) {
            formedList.add("0");
        }
        List<String> finalList = makeList(N, 1, formedList);
        // we have the completely formed list
        String rowString = finalList.get(N);
        String outputString = rowString.charAt(K) + "";
        return Integer.parseInt(outputString);
        
    }
    
    /*
    Please note that the time complexity of this solution is N ^ (2 ^ (n-1)) 
    where   N is the number of rows 
            n is the length of the string at each row
            
    I purposely came up with a horrendous time complexity based sol to prove how memoization 
    can help us in such problems
    */
    private List<String> makeList(int n, int currentRow, List<String> formedList) {
        if (currentRow - 1 == n)
            return formedList;
        String prevRow = formedList.get(currentRow - 1);
        // loop over the previous row and substitute the numbers
        char[] prevRowArray = prevRow.toCharArray();
        String currentRowString = "";
        for (char c : prevRowArray) {
            if (c == '0') {
                currentRowString += "01";
            }
            else if (c == '1') {
                currentRowString += "10";
            }
            else {
                System.out.println("ERROR: DID NOT EXPECT ANY OTHER CHAR THAN 0 and 1. RETURNING");
                return formedList;
            }
        }
        formedList.add(currentRowString);
        currentRow++;
        System.out.println("Calculating for row: " + currentRow);
        return makeList(n, currentRow, formedList);
    }
}

class RecursionProblems {
    public static void main(String arg[]) {
        Solution sol = new Solution();
        int solInt = sol.kthGrammar(1,1);
        System.out.println("Final Int output for (1,1): " + solInt);
    }
}