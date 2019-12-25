package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Yellow Pages", 980);
        Book book2 = new Book("Clean Code", 542);
        Book book3 = new Book("War & Peace", 1514);
        Book book4 = new Book("Atlantic Ocean", 320);

        Book[] bookshelf = {book1, book2, book3, book4};

        for (int i = 0; i < bookshelf.length; i++) {
            System.out.println("Book with title \"" + bookshelf[i].getTitle() + "\" contains " + bookshelf[i].getPages() + " pages.");
        }

        Book temp = bookshelf[0];
        bookshelf[0] = bookshelf[3];
        bookshelf[3] = temp;

        System.out.println("\n Let's rearrange the books alphabetically:\n");
        for (Book book : bookshelf) {
            System.out.println("Book with title \"" + book.getTitle() + "\" contains " + book.getPages() + " pages.");
        }

        for (Book book : bookshelf) {
            if (book.getTitle().equals("Clean Code")) {
                System.out.println("\nBook for programmers \"" + book.getTitle() + "\" contains " + book.getPages() + " pages.");
            }
        }
    }
}
