import java.util.Arrays;
 
public class day9_ArrayBasics {
    public static void main(String[] args) {
        // ----- Declaring and initializing arrays -----
        int[] numbers = {12, 45, 7, 23, 56, 89, 3, 34};
        System.out.println("Array: " + Arrays.toString(numbers));
 
        // ----- Iterating with a classic for loop -----
        System.out.println("\n--- Iteration (classic for) ---");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }
 
        // ----- Iterating with enhanced for-each loop -----
        System.out.println("\n--- Iteration (for-each) ---");
        for (int value : numbers) {
            System.out.print(value + " ");
        }
        System.out.println();
 
        // ----- Find max and min -----
        int max = numbers[0];
        int min = numbers[0];
        for (int value : numbers) {
            if (value > max) max = value;
            if (value < min) min = value;
        }
        System.out.println("\nMax: " + max + ", Min: " + min);
 
        // ----- Sum and average -----
        int sum = 0;
        for (int value : numbers) {
            sum += value;
        }
        double average = (double) sum / numbers.length;
        System.out.println("Sum: " + sum + ", Average: " + average);
 
        // ----- Reverse an array (in place) -----
        int[] reversed = Arrays.copyOf(numbers, numbers.length);
        for (int left = 0, right = reversed.length - 1; left < right; left++, right--) {
            int temp = reversed[left];
            reversed[left] = reversed[right];
            reversed[right] = temp;
        }
        System.out.println("Reversed: " + Arrays.toString(reversed));
 
        // ----- Sorting (built-in) -----
        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sorted);
        System.out.println("Sorted: " + Arrays.toString(sorted));
 
        // ----- Searching -----
        int target = 23;
        int foundIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                foundIndex = i;
                break;
            }
        }
        System.out.println("Index of " + target + ": " + foundIndex);
 
        // ----- Binary search (requires sorted array) -----
        int binarySearchResult = Arrays.binarySearch(sorted, target);
        System.out.println("Binary search for " + target + " in sorted array: index " + binarySearchResult);
    }
}