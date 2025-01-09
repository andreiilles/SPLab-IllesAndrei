package ro.uvt.info.sabloaneproiectarelab2024;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("<< " + paragraph.getText() + " >>");
    }
}