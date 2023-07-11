package KitapSiralayici;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        Set<Book> bookSet = new TreeSet<>();
        bookSet.add(new Book("Kitap 3",145,"J.K.Rowling",2001));
        bookSet.add(new Book("Kitap 1",136,"J.K.Rowling",2003));
        bookSet.add(new Book("Kitap 4",235,"J.K.Rowling",2008));
        bookSet.add(new Book("Kitap 2",435,"J.K.Rowling",1992));
        bookSet.add(new Book("Kitap 5",86,"J.K.Rowling",2000));

        System.out.println("İsme göre sıralama:");
        for(Book book:bookSet){
            System.out.println(book.getName());
        }

        Set<Book> bookSetPage = new TreeSet<>(Comparator.comparingInt(Book::getPage));
        bookSetPage.addAll(bookSet);

        System.out.println("Sayfa sayısına göre sıralama:");
        for(Book book: bookSetPage){
            System.out.println(book.getName()+" "+book.getPage());
        }




    }


}
