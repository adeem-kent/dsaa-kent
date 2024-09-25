import java.util.Arrays;

public class ModularHashing {
    private int[] hashTable;
    private int tableSize;

    // Constructor to initialize the hash table and set its size
    public ModularHashing(int size) {
        tableSize = size;
        hashTable = new int[tableSize];
        // Initialize hash table with -1 (indicating empty slots)
        Arrays.fill(hashTable, -1);
    }

    // Hash function using modular hashing
    private int hashFunction(int key) {
        return key % tableSize;
    }

    // Insert an element into the hash table using modular hashing
    public void insert(int key) {
        int index = hashFunction(key);
        // Linear probing in case of collision
        while (hashTable[index] != -1) {
            index = (index + 1) % tableSize;
        }
        hashTable[index] = key;
    }

    // Print the hash table
    public void displayHashTable() {
        System.out.println("Hash Table:");
        for (int i = 0; i < tableSize; i++) {
            System.out.println(i + " --> " + hashTable[i]);
        }
    }

    public static void main(String[] args) {
        // Create a hash table with 7 slots
        ModularHashing hashTable = new ModularHashing(7);

        // Define the keys to insert
        int[] keys = {10, 20, 5, 15, 25, 35};

        // Insert keys into the hash table using a for loop
        for (int i = 0; i < keys.length; i++) {
            hashTable.insert(keys[i]);
        }

        // Display the hash table
        hashTable.displayHashTable();
    }
}
