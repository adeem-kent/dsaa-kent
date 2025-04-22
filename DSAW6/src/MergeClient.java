public class MergeClient {

    public static void main(String[] args) {
        // Create an array of Comparable elements
        //Integer[] array = {12, 7, 14, 9, 10, 11, 6, 3, 5, 8, 13, 4, 1, 2};
        Integer[] array = {8,3,7,1};

        // Print the original array
        System.out.println("Original array:");
        printArray(array);

        // Sort the array using the Merge sort algorithm
        Merge.sort(array);

        // Print the sorted array
        System.out.println("\nSorted array:");
        printArray(array);
        
        /////////////////////////////////////////////////
        
//        // Creating an array of Date objects
//        Date[] dates = {
//            new Date(8, 18, 2024),
//            new Date(1, 2, 2020),
//            new Date(12, 31, 2022),
//            new Date(5, 10, 2023),
//            new Date(2, 28, 2021),
//            new Date(7, 14, 2020)
//        };
//
//        // Print the original array of dates
//        System.out.println("Original dates:");
//        printArray(dates);
//
//        // Sort the array of Date objects using the Merge sort algorithm
//        Merge.sort(dates);
//
//        // Print the sorted array of dates
//        System.out.println("\nSorted dates:");
//        printArray(dates);
    }

    // Utility method to print the array
    private static void printArray(Comparable[] array) {
        for (Comparable element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
