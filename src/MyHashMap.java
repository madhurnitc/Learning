public class MyHashMap {


    Node[] map;
    int size ;
    public MyHashMap() {
        this.size = 2048;
        this.map = new Node[this.size];
    }

    public void put(int key, int value) {
        int index = getHash(key);
        for(Node x= map[index]; x!=null; x= x.next){
            if(x.key == key){
                x.value = value;
                return;
            }
        }
        Node newNode = new Node(key, value);
        newNode.next = map[index];
        map[index] = newNode;
    }

    private int getHash(int key){
        return (Integer.hashCode(key) & 0x7fffffff) % this.size;
    }

    public int get(int key) {
        int index = getHash(key);
        for(Node x = map[index] ; x != null ; x= x.next){
            if(x.key == key) {
                return x.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = getHash(key);
        Node prev = null;
        for(Node x = map[index]; x!= null; x= x.next){
            if(prev == null && x.key == key) {
                map[index] = x.next;
            }else if(x.key == key){
                prev.next = x.next;
                x.next = null;
            }
            prev = x;
        }

    }


    public class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value) {

            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        map.get(1);
    }
}
