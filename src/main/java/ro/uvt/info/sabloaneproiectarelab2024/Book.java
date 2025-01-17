package ro.uvt.info.sabloaneproiectarelab2024;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private Long id;
    private String title;
    private String isbn;
    private int publicationYear;
    private String publisher;
    private List<Element> children = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    // Constructor for minimum fields
    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    // Constructor for all fields
    public Book(Long id, String title, String isbn, int publicationYear, String publisher) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Element> getChildren() {
        return children;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    // Add content to the book
    public void addContent(Element element) {
        children.add(element);
    }

    // Add an author to the book
    public void addAuthor(Author author) {
        authors.add(author);
    }

    // Update the book's details
    public void updateBook(String title, String isbn, int publicationYear, String publisher) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
        if (isbn != null && !isbn.isEmpty()) {
            this.isbn = isbn;
        }
        if (publicationYear > 0) {
            this.publicationYear = publicationYear;
        }
        if (publisher != null && !publisher.isEmpty()) {
            this.publisher = publisher;
        }
    }

    // Print or Log Book Details
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Book: ").append(title)
                .append("\nID: ").append(id)
                .append("\nISBN: ").append(isbn)
                .append("\nPublication Year: ").append(publicationYear)
                .append("\nPublisher: ").append(publisher)
                .append("\nAuthors: ");
        for (Author author : authors) {
            builder.append("\n  ").append(author);
        }
        builder.append("\nContent: ");
        for (Element element : children) {
            builder.append("\n  ").append(element);
        }
        return builder.toString();
    }
}
