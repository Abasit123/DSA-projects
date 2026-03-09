import java.util.LinkedList;

public class HashTable {
    private int tableSize = 10;  // Size of the hash table
    private LinkedList<Entry>[] table;
    
    // Constructor
    public HashTable() {
        table = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Define a Entry class to store key-value pairs
    private class Entry {
        String key;
        String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Simple hash function that returns an index based on the key
    private int hashFunction(String key) {
        return key.hashCode() % tableSize;
    }

    // Insert key-value pair into the hash table
    public void insert(String key, String value) {
        int index = hashFunction(key);
        LinkedList<Entry> bucket = table[index];

        // Check if the key already exists in the bucket
        for (Entry Entry : bucket) {
            if (Entry.key.equals(key)) {
                Entry.value = value;  // Update value if key exists
                return;
            }
        }

        // If key doesn't exist, add a new Entry with the key-value pair
        bucket.add(new Entry(key, value));
    }

    // Search for a key in the hash table
    public String search(String key) {
        int index = hashFunction(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry Entry : bucket) {
            if (Entry.key.equals(key)) {
                return Entry.value;  // Return the value associated with the key
            }
        }

        return null;  // Key not found
    }

    // Delete a key-value pair from the hash table
    public void delete(String key) {
        int index = hashFunction(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry Entry : bucket) {
            if (Entry.key.equals(key)) {
                bucket.remove(Entry);  // Remove the key-value pair from the bucket
                return;
            }
        }
    }

    // Display the entire hash table
    public void displayTable() {
        for (int i = 0; i < tableSize; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry Entry : table[i]) {
                System.out.print("[" + Entry.key + ": " + Entry.value + "] ");
            }
            System.out.println();
        }
    }

    // Main method to test the hash table
    public static void main(String[] args) {
        HashTable ht = new HashTable();

        // Inserting key-value pairs into the hash table
        ht.insert("John", "25");
        ht.insert("Alice", "30");
        ht.insert("Bob", "22");

        // Displaying the hash table
        ht.displayTable();

        // Searching for a key
        System.out.println("John's age: " + ht.search("John"));
        System.out.println("Alice's age: " + ht.search("Alice"));

        // Deleting a key-value pair
        ht.delete("Bob");
        System.out.println("Bob's age after deletion: " + ht.search("Bob"));

        // Display the table after deletion
        ht.displayTable();
    }
}
