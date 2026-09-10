import java.util.Scanner;

public class day20_LibraryCatalog {
    // Array-based storage — deliberately simple since Collections haven't been taught yet (Phase 5)
    static final int MAX_BOOKS = 100;
    static String[] titles = new String[MAX_BOOKS];
    static String[] authors = new String[MAX_BOOKS];
    static boolean[] isBorrowed = new boolean[MAX_BOOKS];
    static int bookCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pre-load a few books so the catalog isn't empty
        addBook("The Hobbit", "J.R.R. Tolkien");
        addBook("Clean Code", "Robert C. Martin");
        addBook("Effective Java", "Joshua Bloch");

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    addBook(title, author);
                }
                case 2 -> {
                    System.out.print("Enter title to search: ");
                    searchBook(scanner.nextLine());
                }
                case 3 -> {
                    System.out.print("Enter title to remove: ");
                    removeBook(scanner.nextLine());
                }
                case 4 -> {
                    System.out.print("Enter title to borrow: ");
                    borrowBook(scanner.nextLine());
                }
                case 5 -> listAllBooks();
                case 6 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option, try again.");
            }
            System.out.println();
        }

        scanner.close();
    }

    static void printMenu() {
        System.out.println("=== Library Catalog ===");
        System.out.println("1. Add book");
        System.out.println("2. Search book");
        System.out.println("3. Remove book");
        System.out.println("4. Borrow book");
        System.out.println("5. List all books");
        System.out.println("6. Exit");
    }

    static void addBook(String title, String author) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Catalog is full!");
            return;
        }
        titles[bookCount] = title;
        authors[bookCount] = author;
        isBorrowed[bookCount] = false;
        bookCount++;
        System.out.println("Added: \"" + title + "\" by " + author);
    }

    static int findIndexByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    static void searchBook(String title) {
        int index = findIndexByTitle(title);
        if (index == -1) {
            System.out.println("Book not found: " + title);
        } else {
            System.out.println("Found: \"" + titles[index] + "\" by " + authors[index]
                    + (isBorrowed[index] ? " [Borrowed]" : " [Available]"));
        }
    }

    static void removeBook(String title) {
        int index = findIndexByTitle(title);
        if (index == -1) {
            System.out.println("Book not found: " + title);
            return;
        }
        // Shift all later elements left by one to fill the gap
        for (int i = index; i < bookCount - 1; i++) {
            titles[i] = titles[i + 1];
            authors[i] = authors[i + 1];
            isBorrowed[i] = isBorrowed[i + 1];
        }
        bookCount--;
        System.out.println("Removed: " + title);
    }

    static void borrowBook(String title) {
        int index = findIndexByTitle(title);
        if (index == -1) {
            System.out.println("Book not found: " + title);
        } else if (isBorrowed[index]) {
            System.out.println("\"" + title + "\" is already borrowed.");
        } else {
            isBorrowed[index] = true;
            System.out.println("You borrowed: " + title);
        }
    }

    static void listAllBooks() {
        if (bookCount == 0) {
            System.out.println("Catalog is empty.");
            return;
        }
        System.out.println("--- All Books (" + bookCount + ") ---");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". \"" + titles[i] + "\" by " + authors[i]
                    + (isBorrowed[i] ? " [Borrowed]" : " [Available]"));
        }
    }
}