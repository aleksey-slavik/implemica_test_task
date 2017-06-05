package com.demo.task.factorial;

import java.math.BigInteger;

/**
 * Task 3. Get sum of digits of factorial of a number(for example, 100)
 * @author Slavik Aleksey V.
 * @version 1.0
 */

public class Main {

    private static final int COUNT = 100;

    /**
     * Entry point in app
     * @param args
     */
    public static void main(String[] args) {
        System.out.print(getSum(getFactorial(COUNT)));
    }

    /**
     * Method for calculate factorial of a number.
     * @param count
     * @return factorial
     */
    private static BigInteger getFactorial (int count) {
        BigInteger fact = BigInteger.ONE; // first number in a sequence
        for (int i = 2; i <= count; i++)
            fact = fact.multiply(BigInteger.valueOf(i)); // get next number by multiply previous number
        return fact;
    }

    /**
     * Method for calculate sum of digits of a number.
     * @param number
     * @return sum of digits
     */
    private static int getSum(BigInteger number) {
        int sum = 0;
        while (!number.equals(BigInteger.ZERO)) {
            sum += number.mod(BigInteger.TEN).intValue(); // add to a sum current digit
            number = number.divide(BigInteger.TEN); // next digit
        }
        return sum;
    }
}
