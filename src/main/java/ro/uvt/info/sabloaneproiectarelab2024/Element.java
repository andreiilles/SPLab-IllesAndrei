package ro.uvt.info.sabloaneproiectarelab2024;

public interface Element {
    void print();

    default void add(Element element) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    default void remove(Element element) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    default Element get(int index) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }
}
