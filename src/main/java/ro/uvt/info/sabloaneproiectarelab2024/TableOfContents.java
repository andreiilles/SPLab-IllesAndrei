package ro.uvt.info.sabloaneproiectarelab2024;

class TableOfContents extends Element {
    private String content;

    public TableOfContents(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("Table of Contents: " + content);
    }
}