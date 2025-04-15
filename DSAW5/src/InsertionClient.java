public class InsertionClient {
    public static void main(String[] args) {
        // Example array of Comparable objects (Strings in this case)
        String[] array = {"apple", "orange", "banana", "grape", "pear"};

        System.out.println("Before sorting:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Sort the array using Insertion sort
        Insertion.sort(array);

        System.out.println("After sorting:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
