public class OperatorsDemo {
    public static void main(String[] args) {
        int a = 15;
        int b = 4;
 
        // ----- Arithmetic operators -----
        System.out.println("--- Arithmetic ---");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));   // integer division: result is 3, not 3.75
        System.out.println("a % b = " + (a % b));   // remainder: 15 % 4 = 3
 
        // ----- Increment / decrement -----
        int counter = 5;
        System.out.println("\n--- Increment/Decrement ---");
        System.out.println("counter++ (post) = " + (counter++)); // prints 5, then becomes 6
        System.out.println("counter after post-increment = " + counter);
        System.out.println("++counter (pre) = " + (++counter));  // becomes 7, then prints 7
 
        // ----- Relational operators -----
        System.out.println("\n--- Relational ---");
        System.out.println("a > b:  " + (a > b));
        System.out.println("a < b:  " + (a < b));
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
 
        // ----- Logical operators -----
        boolean isAdult = true;
        boolean hasTicket = false;
        System.out.println("\n--- Logical ---");
        System.out.println("isAdult && hasTicket: " + (isAdult && hasTicket));
        System.out.println("isAdult || hasTicket: " + (isAdult || hasTicket));
        System.out.println("!isAdult:             " + (!isAdult));
 
        // ----- Assignment operators -----
        int score = 10;
        score += 5;  // same as score = score + 5
        score -= 2;
        score *= 3;
        score /= 2;
        System.out.println("\n--- Assignment (compound) ---");
        System.out.println("final score after += -= *= /=: " + score);
 
        // ----- Bitwise operators -----
        int x = 6;   // 0110
        int y = 3;   // 0011
        System.out.println("\n--- Bitwise ---");
        System.out.println("x & y = " + (x & y));   // AND  -> 0010 = 2
        System.out.println("x | y = " + (x | y));   // OR   -> 0111 = 7
        System.out.println("x ^ y = " + (x ^ y));   // XOR  -> 0101 = 5
        System.out.println("~x    = " + (~x));      // NOT  -> -7
        System.out.println("x << 1 = " + (x << 1)); // left shift  -> 12
        System.out.println("x >> 1 = " + (x >> 1)); // right shift -> 3
 
        // ----- Operator precedence -----
        System.out.println("\n--- Precedence ---");
        int result = 2 + 3 * 4;       // multiplication before addition -> 14
        int result2 = (2 + 3) * 4;    // parentheses override precedence -> 20
        System.out.println("2 + 3 * 4 = " + result);
        System.out.println("(2 + 3) * 4 = " + result2);
    }
}
 