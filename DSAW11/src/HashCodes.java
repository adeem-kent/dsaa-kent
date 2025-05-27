
// Hashcodes are the values generated from Hash functions
// All these are hash function, but most common one is modular/division hashing
// Hash functions are used to create HashTables
// Hash functions can cause collision and to solve we have seperate chaining and open addressing (linear, quadratic probing etc.)

public class HashCodes {
    public static void main(String[] args) {
        // Testing Integer
        MyInteger intValue = new MyInteger(42);
        System.out.println("Integer Value: " + intValue);
        System.out.println("Integer Hash Code: " + intValue.hashCode());

        // Testing Boolean
        MyBoolean boolValueTrue = new MyBoolean(true);
        MyBoolean boolValueFalse = new MyBoolean(false);
        System.out.println("Boolean Value (true): " + boolValueTrue);
        System.out.println("Boolean Hash Code (true): " + boolValueTrue.hashCode());
        System.out.println("Boolean Value (false): " + boolValueFalse);
        System.out.println("Boolean Hash Code (false): " + boolValueFalse.hashCode());

        // Testing Double
        MyDouble doubleValue = new MyDouble(3.14159);
        System.out.println("Double Value: " + doubleValue);
        System.out.println("Double Hash Code: " + doubleValue.hashCode());

        // Testing String
        MyString stringValue = new MyString("HelloWorld");
        System.out.println("String Value: " + stringValue);
        System.out.println("String Hash Code: " + stringValue.hashCode());
    }
}

// Non-public classes can go below the public class

final class MyInteger {
    private final int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int hashCode() {
        return value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

final class MyBoolean {
    private final boolean value;

    public MyBoolean(boolean value) {
        this.value = value;
    }

    public int hashCode() {
        if (value) return 1231;
        else return 1237;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

final class MyDouble {
    private final double value;

    public MyDouble(double value) {
        this.value = value;
    }

    public int hashCode() {
        long bits = java.lang.Double.doubleToLongBits(value);
        return (int) (bits ^ (bits >>> 32));
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

final class MyString {
    private int hash = 0;
    private final char[] s;

    public MyString(java.lang.String value) {
        this.s = value.toCharArray();
    }

    public int length() {
        return s.length;
    }

    public int hashCode() {
        int h = hash;
        if (h != 0) return h;
        for (int i = 0; i < length(); i++)
            h = s[i] + (31 * h);
        hash = h;
        return h;
    }

    @Override
    public java.lang.String toString() {
        return new java.lang.String(s);
    }
}

