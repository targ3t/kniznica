package sk.pavuk.kniznicazadanie.books;

import jakarta.persistence.*;

@Entity
@Table(name = "books_table")
public class Books {
    @Id
    @SequenceGenerator(
            name = "books_sequence",
            sequenceName = "books_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "books_sequence"
    )
    private Integer bookId;
    private String title;
    private String author;
    private String genre;
    private Integer userId;

    public Books() {

    }

    public Books(Integer bookId, String title, String author, String genre, Integer userId) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.userId = userId;
    }

    public Books(String title, String author, String genre, Integer userId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", userId=" + userId +
                '}';
    }
}

