public class ConditionalsDemo {
    public static void main(String[] args) {
        // ----- if / else if / else -----
        int score = 78;
        String grade;
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Score " + score + " => Grade " + grade);
 
        // ----- Nested conditionals -----
        int age = 20;
        boolean hasLicense = true;
        if (age >= 18) {
            if (hasLicense) {
                System.out.println("Eligible to drive.");
            } else {
                System.out.println("Old enough, but needs a license.");
            }
        } else {
            System.out.println("Too young to drive.");
        }
 
        // ----- Classic switch statement -----
        int day = 3;
        String dayName;
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
            case 7:
                dayName = "Weekend";
                break;
            default:
                dayName = "Invalid day";
        }
        System.out.println("Day " + day + " => " + dayName);
 
        // ----- Modern arrow-style switch expression (Java 14+) -----
        String season = switch (day) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            default -> "Autumn";
        };
        System.out.println("Rough season guess for month " + day + ": " + season);
 
        // ----- Ternary operator: a compact if/else -----
        int number = 17;
        String parity = (number % 2 == 0) ? "even" : "odd";
        System.out.println(number + " is " + parity);
    }
}
 