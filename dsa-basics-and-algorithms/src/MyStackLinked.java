interface MyStackLinked {
    public void push(Object obj);
    public Object pop();
    public Object peek();
    public int size();
}
class LinkedStack implements MyStackLinked{
    private static class Node{
        Object obj;
        Node next;

        Node(Object obj, Node next){
            this.obj=obj;
            this.next=next;
        }
    }
    private Node top;  // Here top works as head
    private int size;

    @Override
    public Object peek() {
        if(size==0)
        throw new IllegalStateException("Stack empty");

        return top.obj;

    }
    @Override
    public Object pop() {
        if(size==0)
        throw new IllegalStateException("Stack Empty");
         
        Object oldTop= top.obj;
        top= top.next;

        --size;
        return oldTop;

    }
    @Override
    public void push(Object obj) {
        ++size;
        top= new Node(obj, top);
    }
    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedStack linkedStack= new LinkedStack();
        linkedStack.push(2);
        linkedStack.push(4);
        linkedStack.push(8);
        linkedStack.push(10);

        System.out.println( linkedStack.peek());
        
        System.out.println(linkedStack.pop());
        System.out.println( linkedStack.peek());
    }
}
