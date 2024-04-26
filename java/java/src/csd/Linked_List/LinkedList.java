package csd.Linked_List;

public class LinkedList {
    Node Head;
    Node Tail;

    public LinkedList() {
        Head = null;
        Tail = null;
    }

    public boolean isEmpty() {
        return (Head == null);
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "Head=" + Head.toString() +
                ", Tail=" + Tail +
                '}';
    }

    // thêm node vào sau một nào node nào đó
    // nếu pred != null thì là thêm vào một vị trí nào đó hoặc ở tail (đuôi)
    // nếu pred == null thì là thêm vào head (đầu danh sách liên kết)
    public void insertAfter(Node new_ele, Node pred){
        if (pred != null){
            new_ele.next = pred.next;
            pred.next = new_ele;
        }else {
            new_ele.next = Head;
            Head = new_ele;
        }
    }
}
