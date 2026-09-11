public class ConstructorDemo {
    public static void main(String[] args) {
        // ----- Using the no-arg constructor -----
        Book book1 = new Book();
        book1.describe();

        // ----- Using a parameterized constructor -----
        Book book2 = new Book("Effective Java", "Joshua Bloch", 2018);
        book2.describe();

        // ----- Constructor overloading: different constructor for partial info -----
        Book book3 = new Book("Untitled Draft");
        book3.describe();

        // ----- Constructor chaining with this(...) -----
        Book book4 = new Book("Clean Architecture", "Robert C. Martin");
        book4.describe();
    }
}

class Book {
    String title;
    String author;
    int year;

    // No-argument constructor — provides sensible defaults
    Book() {
        this("Unknown Title", "Unknown Author", 0);
    }

    // Constructor with only a title — chains to the full constructor via this(...)
    Book(String title) {
        this(title, "Unknown Author", 0);
    }

    // Constructor with title and author, defaulting the year
    Book(String title, String author) {
        this(title, author, 0);
    }

    // The "master" constructor all others chain into
    Book(String title, String author, int year) {
        this.title = title;   // 'this' distinguishes the field from the parameter
        this.author = author;
        this.year = year;
        System.out.println("[Constructor] Created book: " + title);
    }

    void describe() {
        String yearText = (year == 0) ? "unknown year" : String.valueOf(year);
        System.out.println("\"" + title + "\" by " + author + " (" + yearText + ")\n");
    }
}