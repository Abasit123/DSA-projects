public interface Queue {
    public void add(Object obj);
    public Object first();
    public Object remove();
    public int size();

    public static void main(String[] args) {
        LinkedQueue PocketMoney= new LinkedQueue();
        int i=0;

        while ( i < 30 ) {
            PocketMoney.add(500);
            i++;
        }

        System.out.println("Money on first day: "+ PocketMoney.first());

        LinkedQueue PocketMoneyCopy= new LinkedQueue();

        while ( PocketMoney.size() > 0 ) {
            PocketMoneyCopy.add(PocketMoney.remove());
        }
         
        int sum=0;
        while ( PocketMoneyCopy.size() > 0 ) {
            sum += (Integer)PocketMoneyCopy.remove();
        }

        System.out.println("Total sum of moneysum "+ sum );
    }

}
class LinkedQueue implements Queue{
    private static class Node{
        Object obj;
        Node prev= this, next=this;

        Node(Object obj)
        {
            this.obj=obj;
        }
        Node(Object obj, Node prev, Node next)
        {
            this.obj=obj;
            this.prev= prev;
            this.next= next;
        }
    }
    private int size;
    private Node head= new Node(null);

    @Override
    public void add(Object obj) {
        ++size;
        head.prev.next= new Node(obj, head.prev, head);
        head.prev= head.prev.next;
    }

    @Override
    public Object first() {
        if(size==0)
        throw new IllegalStateException("Queue is empty");

        return head.next.obj;
    }
    @Override
    public Object remove() {
        if(size==0)
        throw new IllegalStateException("Queue is empty");

        Object tempObj= head.next.obj;
        head.next= head.next.next;
        head.next.prev= head;
        --size;

        return tempObj;
    }

    @Override
    public int size() {
        return size;
    }

    

}
