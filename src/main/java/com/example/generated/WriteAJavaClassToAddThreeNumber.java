package com.example.generated;

public class WriteAJavaClassToAddThreeNumber {

    /**
     * This method adds three numbers.
     * 
     * TIME COMPLEXITY: O(1)
     * SPACE COMPLEXITY: O(1)
     * 
     * @param a The first number to add.
     * @param b The second number to add.
     * @param c The third number to add.
     * @return The sum of a, b, and c.
     */
    public static long solve(long a, long b, long c) {
        if (a == Long.MIN_VALUE && b < 0 && c < 0) {
            throw new ArithmeticException("Integer overflow");
        }
        if (a == Long.MAX_VALUE && b > 0 && c > 0) {
            throw new ArithmeticException("Integer overflow");
        }
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println(solve(1, 2, 3));  // Expected output: 6
        System.out.println(solve(-1, -2, -3));  // Expected output: -6
        try {
            System.out.println(solve(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE));  // Expected output: ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());  // Expected output: Integer overflow
        }
    }
}