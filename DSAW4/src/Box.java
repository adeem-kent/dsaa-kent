public class Box<T> {
    private T height;
    private T width;
    private T depth;
    
    // Constructor
    public Box() {
        // Default constructor
    }

    // Constructor
    public Box(T height, T width, T depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    // Getters
    public T getHeight() {
        return height;
    }

    public T getWidth() {
        return width;
    }

    public T getDepth() {
        return depth;
    }

    // Setters
    public void setHeight(T height) {
        this.height = height;
    }

    public void setWidth(T width) {
        this.width = width;
    }

    public void setDepth(T depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Box [height=" + height + ", width=" + width + ", depth=" + depth + "]";
    }
}
