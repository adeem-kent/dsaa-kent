import java.util.Arrays;

public class Searching3 {
    public static void main(String[] args) {
        // Example with Integer array
        Integer[] intArray = {1, 3, 5, 7, 9}; // Must be sorted for binary search
        int intMin = 0;
        int intMax = intArray.length - 1;
        Integer intTarget = 5;
        
        boolean intFound = binarySearch(intArray, intMin, intMax, intTarget);
        System.out.println("Integer array: Target " + intTarget + " found? " + intFound);

        // Example with String array
        String[] stringArray = {"apple", "banana", "cherry", "date"}; // Must be sorted
        int strMin = 0;
        int strMax = stringArray.length - 1;
        String strTarget = "cherry";
        
        boolean strFound = binarySearch(stringArray, strMin, strMax, strTarget);
        System.out.println("String array: Target \"" + strTarget + "\" found? " + strFound);

        // Example with Double array
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4}; // Must be sorted
        int doubleMin = 0;
        int doubleMax = doubleArray.length - 1;
        Double doubleTarget = 3.3;

        boolean doubleFound = binarySearch(doubleArray, doubleMin, doubleMax, doubleTarget);
        System.out.println("Double array: Target " + doubleTarget + " found? " + doubleFound);
    }

    // The generic method definition
    public static <T extends Comparable<T>> boolean binarySearch(T[] data, int min, int max, T target) {
        if (min > max) {
            return false; // Base case: range is invalid
        }
        
        int midpoint = (min + max) / 2;  // Determine the midpoint
        int comparison = data[midpoint].compareTo(target);
        
        if (comparison == 0) {
            return true; // Target found
        } else if (comparison > 0) { //means  data[midpoint] is greater than target
            return binarySearch(data, min, midpoint - 1, target); // Search in left half
        } else {
            return binarySearch(data, midpoint + 1, max, target); // Search in right half
        }
    }
}
