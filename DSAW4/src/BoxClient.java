public class BoxClient {
    public static void main(String[] args) {
        // Creating a Box of Integers
        Box<Integer> integerBox = new Box<Integer>(10, 20, 30);
        System.out.println("Integer Box: " + integerBox);
        
        // Accessing and modifying dimensions
        System.out.println("Height: " + integerBox.getHeight());
        integerBox.setHeight(15);
        System.out.println("Updated Height: " + integerBox.getHeight());

        // Creating a Box of Doubles
        Box<Double> doubleBox = new Box<Double>(10.5, 20.5, 30.5);
        System.out.println("Double Box: " + doubleBox);

        // Creating a Box of Strings (just for demonstration, though not typical for dimensions)
        Box<String> stringBox = new Box<>("10", "20", "30");
        System.out.println("String Box: " + stringBox);
        
        // Creating a Box of Gadgets
        Box<Gadget> gadgetBox = new Box<Gadget>();
        Gadget gadget1 = new Gadget("Smartphone", 999.99);
        Gadget gadget2 = new Gadget("Tablet", 499.99);
        Gadget gadget3 = new Gadget("Smartwatch", 199.99);
        
        gadgetBox.setHeight(gadget1);
        gadgetBox.setWidth(gadget2);
        gadgetBox.setDepth(gadget3);
        
        System.out.println("Gadget Box: " + gadgetBox);
        System.out.println("Height (Gadget): " + gadgetBox.getHeight());
        System.out.println("Width (Gadget): " + gadgetBox.getWidth());
        System.out.println("Depth (Gadget): " + gadgetBox.getDepth());
    }
}
