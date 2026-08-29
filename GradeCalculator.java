import java.util.Arrays;

public class GradeCalculator {
    public static void main(String[] args) {
        // ----- 2D array: rows = students, columns = subject scores -----
        String[] studentNames = {"Aarav", "Priya", "Rohan"};
        int[][] scores = {
            {85, 92, 78},  // Aarav: Math, Science, English
            {60, 55, 70},  // Priya
            {95, 88, 91}   // Rohan
        };

        System.out.println("=== Grade Calculator ===\n");

        for (int i = 0; i < scores.length; i++) {
            int total = 0;
            for (int j = 0; j < scores[i].length; j++) {
                total += scores[i][j];
            }
            double average = (double) total / scores[i].length;
            String grade = calculateGrade(average);

            System.out.println(studentNames[i] + ":");
            System.out.println("  Scores: " + Arrays.toString(scores[i]));
            System.out.println("  Total: " + total + ", Average: " + String.format("%.2f", average));
            System.out.println("  Grade: " + grade + "\n");
        }

        // ----- Subject-wise average (iterate columns) -----
        String[] subjects = {"Math", "Science", "English"};
        System.out.println("--- Subject-wise Class Average ---");
        for (int subject = 0; subject < subjects.length; subject++) {
            int subjectTotal = 0;
            for (int[] studentScores : scores) {
                subjectTotal += studentScores[subject];
            }
            double subjectAverage = (double) subjectTotal / scores.length;
            System.out.println(subjects[subject] + ": " + String.format("%.2f", subjectAverage));
        }
    }

    static String calculateGrade(double average) {
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }
}