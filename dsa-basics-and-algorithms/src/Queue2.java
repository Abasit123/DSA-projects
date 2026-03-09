
public interface Queue2 {
    public void add(Object o);
    public Object remove();
    public int size();
    public Object first();
}
class LinkedQueue implements Queue2 {
    private int size;
    private Node head= new Node(null);

    @Override
    public Object first() {
        if(size==0)
            throw new IllegalStateException("Queue is empty");
        return  head.next.obj;
    }

    @Override
    public Object remove() {
        if (size==0)
            throw new IllegalStateException("Queue is empty");
        Object temp = head.next.obj;
        head.next = head.next.next;
        head.next.prev=head;
        size--;
        return temp;
    }

    @Override
    public void add(Object obj) {
        ++size;
        head.prev = new Node(obj, head.prev, head);
        head.prev= head.prev.next;

    }
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head.next;
        while (current != null) {
            sb.append(current.obj);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node{
        Object obj;
        Node prev=this;
        Node next=this;

        Node(Object obj) {
            this.obj=obj;
        }
        Node(Object obj, Node prev, Node next) {
            this.obj=obj;
            this.prev=prev;
            this.next=next;

        }
    }
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.add(1);
        queue.add(2);
        queue.add(5);
        queue.add(10);

        System.out.println(queue.toString());
    }
}
