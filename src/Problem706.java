public class Problem706 {


    /**
     * Initialize your data structure here.
     */

    private int MODULO = 2069;
    private Node[] table;

    public Problem706() {
        table = new Node[MODULO];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {

        int hash = getHash(key);
        for (Node x = table[hash]; x != null; x = x.next) {

            if (x.key == key) {
                x.value = value;
                return;
            }
        }
        Node newEntry = new Node();
        newEntry.key = key;
        newEntry.value = value;
        newEntry.next = table[hash];
        table[hash] = newEntry;

    }

    private int getHash(int key) {

        return (Integer.hashCode(key) & 0x7fffffff) % MODULO;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {

        int hash = getHash(key);
        for (Node x = table[hash]; x != null; x = x.next) {

            if (x.key == key) {
                return x.value;
            }
        }


        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = getHash(key);
        Node prev = null;
        for (Node x = table[hash]; x != null; x = x.next) {
            if (prev == null && x.key == key) {
                table[hash] = x.next;
                x.next = null;
                return;
            } else if (x.key == key) {
                prev.next = x.next;
                return;
            }

            prev = x;
        }
    }

    private class Node {
        private int key;
        private int value;
        private Node next;
    }

    public static void main(String[] args) {
        Problem706 obj = new Problem706();
        obj.put(1, 1);
        obj.put(2, 2);
        obj.put(1, 3);
        obj.remove(1);
        System.out.println(obj.get(1));
    }
}
