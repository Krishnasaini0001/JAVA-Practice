import java.util.HashMap;
import java.util.Map;

public class day19_StringArrayProblems {
    public static void main(String[] args) {
        // ----- Palindrome check -----
        System.out.println("--- Palindrome Check ---");
        System.out.println("'racecar' is palindrome: " + isPalindrome("racecar"));
        System.out.println("'hello' is palindrome: " + isPalindrome("hello"));

        // ----- Anagram check -----
        System.out.println("\n--- Anagram Check ---");
        System.out.println("'listen' & 'silent' are anagrams: " + areAnagrams("listen", "silent"));
        System.out.println("'hello' & 'world' are anagrams: " + areAnagrams("hello", "world"));

        // ----- Manual sorting: bubble sort -----
        System.out.println("\n--- Bubble Sort ---");
        int[] unsorted = {64, 25, 12, 22, 11};
        bubbleSort(unsorted);
        System.out.print("Sorted: ");
        for (int n : unsorted) System.out.print(n + " ");
        System.out.println();

        // ----- Find duplicate characters in a string -----
        System.out.println("\n--- Duplicate Characters ---");
        findDuplicates("programming");

        // ----- Count word frequency -----
        System.out.println("\n--- Word Frequency ---");
        countWordFrequency("the quick brown fox jumps over the lazy dog the fox runs");

        // ----- Find the second-largest number in an array -----
        System.out.println("\n--- Second Largest ---");
        int[] values = {12, 45, 2, 89, 34, 89, 22};
        System.out.println("Second largest in " + java.util.Arrays.toString(values) + " = " + secondLargest(values));
    }

    static boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        java.util.Arrays.sort(aChars);
        java.util.Arrays.sort(bChars);
        return java.util.Arrays.equals(aChars, bChars);
    }

    static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    static void findDuplicates(String text) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("'" + entry.getKey() + "' appears " + entry.getValue() + " times");
            }
        }
    }

    static void countWordFrequency(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : sentence.split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static int secondLargest(int[] array) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > largest) {
                secondLargest = largest;
                largest = value;
            } else if (value > secondLargest && value != largest) {
                secondLargest = value;
            }
        }
        return secondLargest;
    }
}