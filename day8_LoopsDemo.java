public class day8_LoopsDemo {
    public static void main(String[] args) {
        // ----- Classic for loop -----
        System.out.println("--- for loop: 1 to 5 ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        // ----- while loop -----
        System.out.println("\n--- while loop: countdown ---");
        int count = 5;
        while (count > 0) {
            System.out.println("Countdown: " + count);
            count--;
        }
        System.out.println("Liftoff!");

        // ----- do-while loop: runs at least once -----
        System.out.println("\n--- do-while loop ---");
        int n = 10;
        do {
            System.out.println("n is currently: " + n);
            n++;
        } while (n < 10); // condition false immediately, but body still ran once

        // ----- break: exit a loop early -----
        System.out.println("\n--- break example: find first multiple of 7 ---");
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println("Found it: " + i);
                break;
            }
        }

        // ----- continue: skip an iteration -----
        System.out.println("\n--- continue example: print only odd numbers 1-10 ---");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // skip even numbers
            }
            System.out.println("Odd: " + i);
        }

        // ----- Nested loops: multiplication table -----
        System.out.println("\n--- Nested loops: multiplication table (1-5) ---");
        for (int row = 1; row <= 5; row++) {
            StringBuilder line = new StringBuilder();
            for (int col = 1; col <= 5; col++) {
                line.append(row * col).append("\t");
            }
            System.out.println(line);
        }

        // ----- Labeled break: exit outer loop from inner loop -----
        System.out.println("\n--- Labeled break: stop both loops when sum exceeds 15 ---");
        int runningSum = 0;
        outer:
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                runningSum += j;
                if (runningSum > 15) {
                    System.out.println("Stopping at i=" + i + ", j=" + j + ", sum=" + runningSum);
                    break outer;
                }
            }
        }
    }
}