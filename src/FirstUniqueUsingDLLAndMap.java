import java.util.HashMap;
import java.util.Map;

public class FirstUniqueUsingDLLAndMap {

    DLLNode head, tail;
    Map<Integer, DLLNode> map;
    public FirstUniqueUsingDLLAndMap(int[] nums) {

        map = new HashMap<>();
        for (int num : nums) {

            add(num);
        }

    }

    public int showFirstUnique() {

        if(head == null) {
            return -1;
        }

        return head.value;
    }

    public void add(int value) {
        DLLNode node = map.putIfAbsent(value, new DLLNode(value));
       if(node != null) { // the value exists in the map
           remove(node);
       }else { // the value doesn't exist in the map
           addToTheEnd(map.get(value));
       }

    }

    private void addToTheEnd(DLLNode node) {
        if(head == null && tail == null) {
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    private void remove(DLLNode node) {

       if(node.prev == null || node.next == null) {
           return ;
       }
    }

    public class DLLNode {

        int value;
        DLLNode prev, next;

        public DLLNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7};
        FirstUniqueUsingDLLAndMap obj =new FirstUniqueUsingDLLAndMap(nums);
        System.out.println(obj.showFirstUnique());
        obj.add(7);
        System.out.println(obj.showFirstUnique());
        obj.add(3);
        System.out.println(obj.showFirstUnique());
        obj.add(3);
        System.out.println(obj.showFirstUnique());
        obj.add(7);
        System.out.println(obj.showFirstUnique());
        obj.add(17);
        System.out.println(obj.showFirstUnique());
    }
}
