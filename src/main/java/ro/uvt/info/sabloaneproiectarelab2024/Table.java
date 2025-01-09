package ro.uvt.info.sabloaneproiectarelab2024;

class Table extends Element {
    private String content;

    public Table(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}