package ro.uvt.info.sabloaneproiectarelab2024;

class Author {
    private String name;

    public Author(String name) {
        this.name = name;

    }

    public void print() {
        System.out.println("Author: " + name);
    }
}