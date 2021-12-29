public class BrowserHistory {

    DoublyLinkedList list ;
    public BrowserHistory(String homepage) {

         list = new DoublyLinkedList(homepage);

    }

    public void visit(String url) {

        list.visit(url);
    }

    public String back(int steps) {

        return list.back(steps);

    }

    public String forward(int steps) {

        return list.forward(steps);
    }

    public class DoublyLinkedList {


        Node  head, tail, current;

        public DoublyLinkedList(String homePage) {
            head = new Node(homePage);
            tail = head;
            current = head;
        }
        public class Node {
            String url;
            Node next;
            Node prev;

            public Node(String url) {
                this.url = url;
            }
        }

        public String back(int steps) {

            while (steps>=0 && current.prev !=null) {
                current = current.prev;
                steps--;
            }

            return current.url;
        }

        public String forward(int steps) {
            while (steps>=0 && current.next !=null) {
                current = current.next;
                steps--;
            }

            return current.url;
        }

        public void visit(String url) {

            Node newNode = new Node(url);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        public String getCurrentUrl() {
            return current.url;
        }
    }
}
