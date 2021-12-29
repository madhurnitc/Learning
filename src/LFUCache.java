import java.util.HashMap;
import java.util.Map;

class LFUCache {

    int capacity, size, minFreq;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> freqMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.size = 0;
        this.minFreq = 0;

    }

    public int get(int key) {
        DLLNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {

        if(capacity == 0) {
            return ;
        }

        if(cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            node.val = value;
            updateNode(node);
        }else {
            size++;
            if(size > capacity) {
                DoubleLinkedList minFreqList = freqMap.get(minFreq);
                DLLNode deleteNode = minFreqList.removeTail();
                cache.remove(deleteNode.key);
                size--;
            }
            minFreq = 1;
            DLLNode node = new DLLNode(key, value);
            DoubleLinkedList currList = freqMap.getOrDefault(1, new DoubleLinkedList());
            currList.addNode(node);
            freqMap.put(1, currList);
            cache.put(key, node);
        }
    }

    public void updateNode(DLLNode node) {
        int currentFrequency = node.freq;
        DoubleLinkedList freqList = freqMap.get(currentFrequency);
        freqList.removeNode(node);
        if(currentFrequency == minFreq && freqList.size == 0) {
            minFreq++;
        }
        node.freq++;
        DoubleLinkedList newFreqList = freqMap.getOrDefault(node.freq, new DoubleLinkedList());
        newFreqList.addNode(node);
        freqMap.put(node.freq, newFreqList);

    }

    public class DoubleLinkedList {

        DLLNode head;
        DLLNode tail;
        int size;
        public DoubleLinkedList () {
            size = 0;
            this.head = new DLLNode(0,0);
            this.tail = new DLLNode(0,0);
            head.next = tail;
            head.prev = head;
        }

        //adds a node the front of the DLL
        public void addNode(DLLNode node) {
            DLLNode currentHead = head.next;
            node.next = currentHead;
            node.prev = head;
            head.next = node;
            currentHead.prev = node;
            size++;
        }

        public void removeNode(DLLNode node) {
            DLLNode prevNode = node.prev;
            DLLNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        public DLLNode removeTail() {
            if(size <=0) {
                return null;
            }

            DLLNode tail = this.tail.prev;
            removeNode(tail);
            return tail;
        }
    }
    public class DLLNode {
        int key, val, freq;
        DLLNode next, prev;
        public DLLNode (int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }


    }
}