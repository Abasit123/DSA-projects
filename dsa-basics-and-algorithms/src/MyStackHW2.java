public interface MyStackHW2 {
    public void push(Object obj);
    public Object pop();
    public Object peek();
    public int size();
}

class ArrayStack implements MyStack{
    private Object[] a;
    private int size;

    public ArrayStack(int capacity){
        a=new Object[capacity];
    }
    public void push(Object obj){
        if(size==a.length)
        resize();

        a[size++]=obj;
    }
    public Object peek(){
        if(size==0)
        throw new IllegalStateException("Stack is empty");

        return a[size-1];
    }
    public Object pop(){
        if(size==0)
        throw new IllegalStateException("Stack is empty");
         
        Object temp= a[--size];
        a[size]=null;

        return temp;
    }
    public int size(){
        return size;
    }

    public void resize(){
          Object[] temp=a;
          a= new Object[2*temp.length];
          System.arraycopy(temp, 0, a, 0, size);;
    }
    public static void main(String[] args) {
        ArrayStack fruitStack= new ArrayStack(6);
        fruitStack.push("Apple");
        fruitStack.push("Kiwi");
        fruitStack.push("Grapefruit");
        fruitStack.push("Banana");
        fruitStack.push("Mango");
        fruitStack.push("Watermelon");

        int half= fruitStack.size/2;
      ArrayStack st1= new ArrayStack(half);
      ArrayStack st2= new ArrayStack(half);

      while (fruitStack.size()>half) {
           st1.push(fruitStack.pop());
      }
      while (fruitStack.size()>half) {
        st1.push(fruitStack.pop());
      }
      System.out.print("Stack 1 Peek:"+st1.peek());
      System.out.print("Stack 2 Peek:"+st2.peek());

    }
   

}

