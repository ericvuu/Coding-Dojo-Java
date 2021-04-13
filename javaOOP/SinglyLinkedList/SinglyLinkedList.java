public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }

    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            System.out.println("adding " + current.value);
        }
    }

    public void remove() {
        if(head == null) {
            System.out.println("There is nothing to remove");
            return;
        } else {
            Node current = head;
            while(current.next.next != null) {
                current = current.next;
            }
            System.out.println("removing " + current.next.value);
            current.next = null;
        }
    }

    public void printValues(){
        if(head == null) {
            System.out.println("There is nothing to print");
            return;
        } else {
            Node current = head;
            while(current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }
    }
}
