package KitapListesi;

public class Book {
    private String bookName;
    private int pageCount;
    private String authorName;
    private String publicationDate;

    public Book(String bookName, int pageCount, String authorName, String publicationDate) {
        this.bookName = bookName;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.publicationDate = publicationDate;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getPublicationDate() {
        return publicationDate;
    }
}