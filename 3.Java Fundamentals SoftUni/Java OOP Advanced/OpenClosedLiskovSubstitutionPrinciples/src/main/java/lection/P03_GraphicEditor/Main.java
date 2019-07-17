package lection.P03_GraphicEditor;

public class Main {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();

        graphicEditor.drawDrawable(new Picture());
        graphicEditor.drawDrawable(new Circle());
        graphicEditor.drawDrawable(new Rectangle());
        graphicEditor.drawDrawable(new Square());
    }
}
