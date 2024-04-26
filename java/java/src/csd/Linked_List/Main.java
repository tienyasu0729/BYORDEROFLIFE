package csd.Linked_List;

public class Main {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        l.insertAfter(a, null);
        l.insertAfter(b, null);
        l.insertAfter(c, null);
        System.out.println(l.toString());
    }
}
