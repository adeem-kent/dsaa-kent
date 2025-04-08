
public class Searching2 {
    public static void main(String[] args) {
        // Example with Integer array
        Integer[] intArray = {1, 3, 5, 7, 9};
        int intMin = 0;
        int intMax = 4;
        Integer intTarget = 5;
        
        boolean intFound = linearSearch(intArray, intMin, intMax, intTarget);
        System.out.println("Integer array: Target " + intTarget + " found? " + intFound);

        // Example with String array
        String[] stringArray = {"apple", "banana", "cherry", "date"};
        int strMin = 0;
        int strMax = 3;
        String strTarget = "cherry";
        
        boolean strFound = linearSearch(stringArray, strMin, strMax, strTarget);
        System.out.println("String array: Target \"" + strTarget + "\" found? " + strFound);

        // Example with Double array
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        int doubleMin = 0;
        int doubleMax = 3;
        Double doubleTarget = 3.3;

        boolean doubleFound = linearSearch(doubleArray, doubleMin, doubleMax, doubleTarget);
        System.out.println("Double array: Target " + doubleTarget + " found? " + doubleFound);
    }

    // The generic method definition
    public static <T> boolean linearSearch(T[] data, int min, int max, T target) {
        int index = min;
        boolean found = false;
        while (!found && index <= max) {
            found = data[index].equals(target);
            index++;
        }
        return found;
    }
}
