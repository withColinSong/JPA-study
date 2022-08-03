package domain.Inheritance;

import javax.persistence.Entity;

@Entity
public class Book extends MainItem {
    private String author;
    private String ISBN;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
