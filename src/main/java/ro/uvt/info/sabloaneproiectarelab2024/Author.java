package ro.uvt.info.sabloaneproiectarelab2024;

import jakarta.persistence.*;

@Entity
public class Author {
    @Id
    private Integer id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    public Author(String name) {
        this.name = name;
    }
    public Author() {
        this.name = "Default";
    }
    public void print() {
        System.out.println("Author: " + name);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
}