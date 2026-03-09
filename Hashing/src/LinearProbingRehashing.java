import java.util.Arrays;

class HashTableLinearProbing {
    private static int SIZE = 10; // Initial count of the hash table
    private String[] keys; // Array to store keys
    private String[] values; // Array to store values
    private int count; // Current number of elements in the table

    // Constructor to initialize the hash table
    public HashTableLinearProbing() {
        keys = new String[SIZE];
        values = new String[SIZE];
        count = 0;
    }

    // Hash function
    private int hash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }
    
    private double getLoadFactor()
    {
        return (double)(count/SIZE); 
    }
    // Insert key-value pair into the hash table
    public void insert(String key, String value) {
        if (getLoadFactor()>= 0.7) { // Rehash when load factor exceeds 0.7
            rehash();
        }

        int index = hash(key);

        // Find the next available slot
        while (keys[index] != null) {
            // If the key already exists, update the value
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }
            index = (index + 1) % SIZE; // Linear probing
        }

        // Insert the key-value pair
        keys[index] = key;
        values[index] = value;
        count++;
    }

    // Search for a key in the hash table
    public String search(String key) {
        int index = hash(key);

        // Probe until we find the key or reach an empty slot
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % SIZE; // Linear probing
        }

        return null; // Key not found
    }

    // Delete a key-value pair from the hash table
    public void delete(String key) {
        int index = hash(key);

        // Probe until we find the key or reach an empty slot
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                keys[index] = null;
                values[index] = null;
                count--;

                // Rehash elements in the same cluster to avoid breaking the chain
                rehashCluster(index);
                return;
            }
            index = (index + 1) % keys.length; // Linear probing
        }

        System.out.println("Key not found: " + key);
    }

    // Rehash the entire table when load factor exceeds threshold
    private void rehash() {
        System.out.println("Rehashing table...");
        int newTableSize = SIZE * 2;
        String[] oldKeys = keys;
        String[] oldValues = values;

        keys = new String[newTableSize];
        values = new String[newTableSize];
        count = 0;
         SIZE= newTableSize;

        // Reinsert all existing key-value pairs into the new table
        for (int i = 0; i < SIZE; i++) {
            if (oldKeys[i] != null) {
                insert(oldKeys[i], oldValues[i]);
            }
        }
    }

    // Rehash elements in the same cluster after deletion
    private void rehashCluster(int start) {
        int index = (start + 1) % keys.length;

        while (keys[index] != null) {
            String rehashKey = keys[index];
            String rehashValue = values[index];
            keys[index] = null;
            values[index] = null;
            count--;
            insert(rehashKey, rehashValue); // Reinsert the element
            index = (index + 1) % keys.length;
        }
    }

    // Display the hash table
    public void displayTable() {
        System.out.println("Hash Table:");
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                System.out.println("Index " + i + ": Key = " + keys[i] + ", Value = " + values[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }

    // Main method to test the hash table
    public static void main(String[] args) {
        HashTableLinearProbing ht = new HashTableLinearProbing();

        ht.insert("Alice", "24");
        ht.insert("Bob", "30");
        ht.insert("Charlie", "29");
        ht.insert("Diana", "35");
        ht.insert("Eve", "27");
        ht.insert("Frank", "33");
        ht.insert("Grace", "26");
        ht.insert("Hannah", "40");

        ht.displayTable();

        System.out.println("\nSearch for Alice: " + ht.search("Alice"));
        System.out.println("Search for Diana: " + ht.search("Diana"));

        System.out.println("\nDelete Charlie:");
        ht.delete("Charlie");
        ht.displayTable();

        System.out.println("\nInsert Irene:");
        ht.insert("Irene", "31");
        ht.displayTable();
    }
}
