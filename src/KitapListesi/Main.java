package KitapListesi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Kitap 1", 123, "Yazar 1", "2000-05-17"));
        books.add(new Book("Kitap 2", 65, "Yazar 2", "2002-06-20"));
        books.add(new Book("Kitap 3", 321, "Yazar 3", "1905-10-01"));

        Map<String, String> bookAuthorMap = books.stream()
                .collect(Collectors.toMap(Book::getBookName, Book::getAuthorName));

        System.out.println("Kitap - Yazar Eşleştirmesi:");
        bookAuthorMap.forEach((book, author) -> System.out.println(book + " - " + author));

        List<Book> filteredBooks = books.stream()
                .filter(book -> book.getPageCount() > 100)
                .collect(Collectors.toList());

        System.out.println("\n100 Sayfanın Üzerinde Olan Kitaplar:");
        filteredBooks.forEach(book -> System.out.println(book.getBookName() + " - " + book.getAuthorName()));
    }
}
