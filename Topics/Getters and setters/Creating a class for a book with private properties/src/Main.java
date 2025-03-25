import java.util.Scanner;

public class Main {
    // Creating class
    public static class Book {
        // private properties
        private String title;
        private String author;
        private int numberOfPages;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            if (title != null && !title.isEmpty()) this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            if (author != null && ! author.isEmpty()) this.author = author;
        }

        public int getNumberOfPages() {
            return numberOfPages;
        }

        public void setNumberOfPages(int numberOfPages) {
            if (numberOfPages > 0) this.numberOfPages = numberOfPages;
        }

        // getters and setters go here
        // Remember: 
        // 1. They must not allow empty string for 'title' and 'author'.
        // 2. They must not allow negative or zero value for 'numberOfPages'.
        // 3. If such values are attempted to be set, the property should remain unchanged.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an object of the Book class
        Book book = new Book();

        // Take Title, Author and numberOfPages as next inputs and set them using the mutator methods
        // Your code here
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int numberOfPage = scanner.nextInt();

        book.setTitle(title);
        book.setAuthor(author);
        book.setNumberOfPages(numberOfPage);

        // Then use the accessor methods to get and print these values.
        // Your code here
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getNumberOfPages());

        scanner.close();
    }
}