public class HashMap {
    private final int SIZE = 100;
    private String[] keys;
    private String[] values;
    private int count;

    public HashMap() {
        keys = new String[SIZE];
        values = new String[SIZE];
        count = 0;
    }

    public void put(String key, String value) {
        for (int i = 0; i < count; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    public String get(String key) {
        for (int i = 0; i < count; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public boolean containsKey(String key) {
        for (int i = 0; i < count; i++) {
            if (keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }
}