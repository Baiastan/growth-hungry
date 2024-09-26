package java_intensive;

import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {

    private static HashMap<Integer, Integer> fibCache = new HashMap<>();

    public static void main(String[] args) {

        Scanner scan =  new Scanner(System.in);
        int n;
       do {
           System.out.print("Enter a number less than 40 to calculate its Fibonacci: ");
           n = scan.nextInt();
       }while(n >= 40);

        int res = fib(n);

        System.out.println("Fibonacci of " + n + " is:" + res);
        scan.close();
    }

    

    public static int fib(int n) {
        if(fibCache.containsKey(n)) {
            return fibCache.get(n);
        }

        if(n <= 1) {
            return n;
        }

        int result = fib(n - 1) + fib(n - 2);

        fibCache.put(n, result);

        return result;
    }
}
