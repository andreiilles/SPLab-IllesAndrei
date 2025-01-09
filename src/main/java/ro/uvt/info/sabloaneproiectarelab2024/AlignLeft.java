package ro.uvt.info.sabloaneproiectarelab2024;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("<< " + paragraph.getText());
    }
}