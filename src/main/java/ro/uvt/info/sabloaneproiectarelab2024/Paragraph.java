package ro.uvt.info.sabloaneproiectarelab2024;

public class Paragraph implements Element {
    private String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy strategy) {
        this.alignStrategy = strategy;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render(this); // Assuming context is not used here
        } else {
            System.out.println("Paragraph: " + text);
        }
    }
}