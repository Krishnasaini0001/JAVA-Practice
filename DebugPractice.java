public class DebugPractice {
    public static void main(String[] args) {
        System.out.println("=== Debugging Practice ===");
        System.out.println("This file intentionally contains bugs.");
        System.out.println("Set breakpoints on the marked lines and step through in your IDE.\n");

        // BUG 1: Off-by-one error — try stepping through with a debugger to see it print 0..4 instead of 0..5
        System.out.println("--- Bug 1: loop boundary ---");
        int[] data = {10, 20, 30, 40, 50};
        for (int i = 0; i < data.length - 1; i++) { // <- set a breakpoint here; watch 'i' and 'data.length'
            System.out.println("data[" + i + "] = " + data[i]);
        }
        System.out.println("(Notice the last element, 50, never printed — that's the bug)\n");

        // BUG 2: Wrong operator — watch the variable 'average' in the debugger
        System.out.println("--- Bug 2: integer division ---");
        int sum = 17;
        int count = 5;
        double average = sum / count; // <- breakpoint here: inspect 'average', should be 3.4 not 3.0
        System.out.println("Average (buggy): " + average);
        double fixedAverage = (double) sum / count; // the fix: cast BEFORE dividing
        System.out.println("Average (fixed): " + fixedAverage + "\n");

        // BUG 3: Null reference — step in to see exactly where it would throw
        System.out.println("--- Bug 3: potential NullPointerException ---");
        String userInput = getUserInputSafely(false); // change to true to see the safe path
        if (userInput != null) {
            System.out.println("Input length: " + userInput.length());
        } else {
            System.out.println("Input was null — guarded with a null check instead of crashing");
        }

        // BUG 4: Logic error in a condition — trace 'age' through the debugger step-by-step
        System.out.println("\n--- Bug 4: logic error ---");
        int age = 15;
        checkVotingEligibility(age); // <- step INTO this method to see the condition evaluate
    }

    static String getUserInputSafely(boolean simulateValidInput) {
        if (simulateValidInput) {
            return "hello debugger";
        }
        return null; // simulates missing/invalid input
    }

    static void checkVotingEligibility(int age) {
        // Originally written as (age = 18) by mistake in some codebases — always use == for comparison!
        if (age >= 18) {
            System.out.println("Age " + age + ": eligible to vote.");
        } else {
            System.out.println("Age " + age + ": NOT eligible to vote yet.");
        }
    }
}