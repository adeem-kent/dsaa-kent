// Client class to test the QuickSort implementation

import java.util.Arrays;

class QuickSortClient {
    public static void main(String[] args) {
        // Example array of integers to be sorted
//        Integer[] array = {5, 3, 8, 4, 2, 7, 1, 10, 6, 9};
        Integer[] array = {2,6,5,0,8,7,1,3};
        
        // Print the array before sorting
        System.out.println("Array before sorting: " + Arrays.toString(array));
        
        // Sort the array using QuickSort
        Quick.sort(array);
        
        // Print the array after sorting
        System.out.println("Array after sorting: " + Arrays.toString(array));
    }
}