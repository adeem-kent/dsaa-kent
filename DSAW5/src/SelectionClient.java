public class SelectionClient {
    public static void main(String[] args) {
        // Example array of Comparable objects (Strings in this case)
        String[] array = {"apple", "orange", "banana", "grape", "pear"};
        int arr1 [] = {1,5,7,3,2};

        System.out.println("Before sorting:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Sort the array using Selection sort
        Selection.sort(array);

        System.out.println("After sorting:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
        
        /////////////////////////// for person //////////////////////////
        
     // Example array of Person objects
        Person[] people = {
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 20),
            new Person("Dave", 35),
            new Person("Eve", 28)
        };

        System.out.println("Before sorting:");
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
        System.out.println();

        // Sort the array using Selection sort
        Selection.sort(people);

        System.out.println("After sorting:");
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }

    }
}
