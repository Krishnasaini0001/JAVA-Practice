import java.util.Scanner;
 
public class day6_ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
 
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
 
        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();
 
        // Consume the leftover newline after nextInt()/nextDouble() before reading another line
        scanner.nextLine();
 
        System.out.print("Do you enjoy programming? (true/false): ");
        boolean enjoysProgramming = scanner.nextBoolean();
 
        System.out.println("\n--- Summary ---");
        System.out.println("Name:   " + name);
        System.out.println("Age:    " + age);
        System.out.println("Height: " + height + "m");
        System.out.println("Enjoys programming: " + enjoysProgramming);
 
        int birthYear = 2026 - age;
        System.out.println("You were likely born around: " + birthYear);
 
        scanner.close();
    }
}
 