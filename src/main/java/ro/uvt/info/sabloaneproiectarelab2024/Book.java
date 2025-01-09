package ro.uvt.info.sabloaneproiectarelab2024;

import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private List<Element> children = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addContent(Element element) {
        children.add(element);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println();
        for (Element element : children) {
            element.print();
        }
    }
}