import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Node> map;
    DoublyLinkedList list;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            list.removeNode(node);
            list.addToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            list.removeNode(node);
            list.addToHead(node);
            return;
        }
        if(this.capacity == map.size()) {
            Node lruNode = list.removeTail();
            map.remove(lruNode.key);

        }
        Node node = new Node(key, value);
        map.put(key , node);
        list.addToHead(node);
        
    }

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public class DoublyLinkedList {
        Node head;
        Node tail;

        public DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addToHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Node removeTail() {
            Node res = tail.prev;
            removeNode(res);
            return res;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        lruCache.get(1);
        lruCache.get(2);
    }
}