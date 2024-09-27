package java_intensive;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int n = scan.nextInt();

        boolean isNumberPrime = isPrime(n);
        boolean isNumberPrime1 = isPrimeOptimized(n);


        System.out.println("IsPrime: " + isNumberPrime);
        System.out.println("IsPrime: "  + isNumberPrime1);

    }



    public static boolean isPrime(int n) {
        //T O(n)
        if(n <= 1) return false;

        for(int i = 2; i < n / 2; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeOptimized(int n) {
        //T O(sqrt(n))

        if(n <= 1) return false;

        if(n <= 3) return true;

        if(n % 2 == 0) return false; // except 2, any even number is not a prime number;

        if(n % 3 == 0) return false; // except 3, any number divisible by 3 is not a prime number

        // if square root of n is not a prime number, then n is not a prime number
        //example: if n == 81, sqrt is 9 which is not a prime number. therefore we are doing i*i
        for(int i = 5; i*i <= n; i = i + 6) {
            //6k ± 1 = prime numbers
            if(n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
