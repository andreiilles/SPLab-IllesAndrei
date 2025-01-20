package ro.uvt.info.sabloaneproiectarelab2024;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ConcreteElement implements Element {
    @Id
    private Long id;
    private String name;

    public ConcreteElement(String name) {
        this.name = name;
    }

    public ConcreteElement() {
        this.name = "Default";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Element: " + name);
    }
}
