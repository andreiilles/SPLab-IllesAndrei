package ro.uvt.info.sabloaneproiectarelab2024;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedNotification;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(force = true)

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @OneToMany(targetEntity = ConcreteElement.class)
    private final List<Element> children = new ArrayList<>();
    @ManyToMany
    private final List<Author> authors = new ArrayList<>();
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
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}