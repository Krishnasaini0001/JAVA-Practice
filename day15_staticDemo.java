public class RecursionProblems {
    public static void main(String[] args) {
        // ----- Sum of digits -----
        int number = 4938;
        System.out.println("Sum of digits of " + number + " = " + sumOfDigits(number));

        // ----- Power (base^exponent) -----
        System.out.println("2^10 = " + power(2, 10));
        System.out.println("5^0  = " + power(5, 0));

        // ----- Greatest Common Divisor (Euclidean algorithm) -----
        System.out.println("GCD(48, 18) = " + gcd(48, 18));
        System.out.println("GCD(101, 10) = " + gcd(101, 10));

        // ----- Reverse a string recursively -----
        System.out.println("Reverse of 'recursion' = " + reverseString("recursion"));

        // ----- Check if a string is a palindrome recursively -----
        System.out.println("Is 'madam' a palindrome? " + isPalindrome("madam"));
        System.out.println("Is 'hello' a palindrome? " + isPalindrome("hello"));

        // ----- Sum of an array recursively -----
        int[] values = {4, 8, 15, 16, 23, 42};
        System.out.println("Sum of array = " + sumArray(values, 0));
    }

    // Base case: single digit returns itself
    static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }

    static long power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }

    // Euclidean algorithm: gcd(a, b) = gcd(b, a % b), base case gcd(a, 0) = a
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static String reverseString(String text) {
        if (text.isEmpty()) {
            return text;
        }
        return reverseString(text.substring(1)) + text.charAt(0);
    }

    static boolean isPalindrome(String text) {
        if (text.length() <= 1) {
            return true; // base case: empty or single character is always a palindrome
        }
        char first = text.charAt(0);
        char last = text.charAt(text.length() - 1);
        if (first != last) {
            return false;
        }
        return isPalindrome(text.substring(1, text.length() - 1));
    }

    static int sumArray(int[] array, int index) {
        if (index == array.length) {
            return 0; // base case: no elements left
        }
        return array[index] + sumArray(array, index + 1);
    }
}