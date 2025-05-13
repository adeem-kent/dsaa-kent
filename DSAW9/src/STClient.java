public class STClient {
    public static void main(String[] args) {
        // Create an instance of ST with String keys and Integer values
        ST<String, Integer> st = new ST<>();

        // Add some key-value pairs to the symbol table
        st.put("apple", 10);
        st.put("banana", 20);
        st.put("orange", 30);
        st.put("grape", 40);

        // Retrieve a value based on a key
        System.out.println("Value associated with 'apple': " + st.get("apple"));

        // Check if a key exists in the table
        System.out.println("Does 'banana' exist? " + st.contains("banana"));

        // Delete a key-value pair
        st.delete("banana");
        System.out.println("Deleted 'banana'. Does 'banana' exist? " + st.contains("banana"));

        // Print the size of the symbol table
        System.out.println("Size of symbol table: " + st.size());

        // Print all the keys in the table
        System.out.println("All keys in the table:");
        for (String key : st.keys()) {
            System.out.println(key + " => " + st.get(key));
        }
    }
}
