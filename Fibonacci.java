import java.lang.*;
import java.util.*;

public class Fibonacci {
    public static void main(String args[]) {
        System.out.println("Ficonacci of 10: " + getFibonacci(10));
    }
    
    public static int getFibonacci(int number) {
        if (number < 3) {
            return number;
        }
        return calculateNthFibonacci(number, 0);
    }
    
    public static int calculateNthFibonacci(int num, int total) {
        if (num < 1)
            return total;
        return calculateNthFibonacci(num - 1, num + total);
    }
}