public class Searching1 {
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

        // Example with another Integer array
        Integer[] anotherIntArray = {10, 20, 30, 40, 50};
        int anotherIntMin = 0;
        int anotherIntMax = 4;
        Integer anotherIntTarget = 25;

        boolean anotherIntFound = linearSearch(anotherIntArray, anotherIntMin, anotherIntMax, anotherIntTarget);
        System.out.println("Another Integer array: Target " + anotherIntTarget + " found? " + anotherIntFound);
    }

    // The generic method definition
    public static <T extends Comparable<T>> boolean linearSearch(T[] data, int min, int max, T target) {
        for (int i = min; i <= max; i++) {
            if (data[i].compareTo(target) == 0) {
                return true;
            }
        }
        return false;
    }
}
