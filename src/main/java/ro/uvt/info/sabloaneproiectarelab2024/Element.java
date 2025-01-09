package ro.uvt.info.sabloaneproiectarelab2024;

abstract class Element {
    public abstract void print();

    public void add(Element element) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    public void remove(Element element) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    public Element get(int index) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }
}