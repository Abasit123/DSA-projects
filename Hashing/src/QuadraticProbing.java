class HashTableQuadraticProbing {
    private static final int TABLE_SIZE = 10;  // Size of the hash table
    private String[] keys;  // Array to store keys
    private String[] values;  // Array to store values
    private int count;  // Current number of elements in the table

    // Constructor to initialize the hash table
    public HashTableQuadraticProbing() {
        keys = new String[TABLE_SIZE];
        values = new String[TABLE_SIZE];
        count = 0;
    }

    // Hash function
    private int hash(String key) {
        return Math.abs(key.hashCode()) % TABLE_SIZE;
    }

    // Insert key-value pair into the hash table using quadratic probing
    public void insert(String key, String value) {
        if (count >= TABLE_SIZE) {
            System.out.println("Hash table is full!");
            return;
        }

        int index = hash(key);
        int i = 0;  // Initial probe count
        int newIndex;

        // Try quadratic probing to find an empty slot
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                values[index] = value;  // Update value if key exists
                return;
            }
            i++;
            newIndex = (index + i * i) % TABLE_SIZE;  // Quadratic probing
            if (newIndex == index) break;  // Avoid infinite loop if table is full
            index = newIndex;
        }

        // Insert the key-value pair
        keys[index] = key;
        values[index] = value;
        count++;
    }

    // Search for a key in the hash table using quadratic probing
    public String search(String key) {
        int index = hash(key);
        int i = 0;

        // Probe until we find the key or reach an empty slot
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];  // Key found
            }
            i++;
            index = (index + i * i) % TABLE_SIZE;  // Quadratic probing
        }

        return null;  // Key not found
    }

    // Delete a key-value pair from the hash table using quadratic probing
    public void delete(String key) {
        int index = hash(key);
        int i = 0;

        // Probe until we find the key or reach an empty slot
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                // Element found, delete it
                keys[index] = null;
                values[index] = null;
                count--;
                
                // Rehash all following elements in the cluster
                rehashCluster(index);
                return;
            }
            i++;
            index = (index + i * i) % TABLE_SIZE;  // Quadratic probing
        }

        System.out.println("Key not found: " + key);
    }

    // Rehash elements in the same cluster after deletion to avoid breaking the probe chain
    private void rehashCluster(int start) {
        int index = (start + 1) % TABLE_SIZE;
        int i = 0;

        // Rehash all subsequent elements in the cluster to their correct positions
        while (keys[index] != null) {
            String rehashKey = keys[index];
            String rehashValue = values[index];
            keys[index] = null;
            values[index] = null;
            count--;
            insert(rehashKey, rehashValue);  // Reinsert the element
            i++;
            index = (index + i * i) % TABLE_SIZE;
            
        }
    }

    // Display the hash table
    public void displayTable() {
        System.out.println("Hash Table:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (keys[i] == null) {
                System.out.println("Index " + i + ": Empty");
            } else {
                System.out.println("Index " + i + ": [" + keys[i] + ", " + values[i] + "]");
            }
        }
    }

    // Main method to test the hash table
    public static void main(String[] args) {
        HashTableQuadraticProbing ht = new HashTableQuadraticProbing();

        ht.insert("Alice", "24");
        ht.insert("Bob", "30");
        ht.insert("Charlie", "29");
        ht.insert("Diana", "35");

        ht.displayTable();

        System.out.println("\nSearch for Alice: " + ht.search("Alice"));
        System.out.println("Search for Bob: " + ht.search("Bob"));

        System.out.println("\nDelete Charlie:");
        ht.delete("Charlie");
        ht.displayTable();

        System.out.println("\nInsert Eve:");
        ht.insert("Eve", "27");
        ht.displayTable();
    }
}
