public interface MyStack {
    public void push(Object a);
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
        if(size== a.length)
        resize();

     a[size++] =obj;
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
          Object[] temp a;
         a= new Object[2*temp.length];
          System.arraycopy(temp, 0, a, 0, size);;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("ArrayStack [");
        for (int i = 0; i < size; i++) {
            sb.append a[i]);
            if (i < size - 1) {
                sb.append(", "); 
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public static void main(String[] args) {
        ArrayStack fruitStack= new ArrayStack(6);
        
        fruitStack.push("Apple");
        fruitStack.push("Kiwi");
        fruitStack.push("Grapefruit");
        fruitStack.push("Banana");
        fruitStack.push("Mango");
        fruitStack.push("Watermelon");
         
        int size= fruitStack.size();

        ArrayStack fruitStack2= new ArrayStack(size);
        System.out.println("Storing FruitStack From top to bottom in FruitStack2 ");
          while (fruitStack.size()>0) {
             fruitStack2.push(fruitStack.pop());
          }
        int half= size/2;
        ArrayStack splitStack1= new ArrayStack(half);
        ArrayStack splitStack2= new ArrayStack(size-half);

        while (fruitStack2.size()>half) {
           splitStack2.push(fruitStack2.pop());
         }
        while (fruitStack2.size()>0) {
            splitStack1.push(fruitStack2.pop());
      }
      System.out.println("SplitStack 1 : "+splitStack1.toString());
      System.out.println("SplitStack 2 : "+splitStack2.toString());

      ArrayStack merge= new ArrayStack(size);
  
      while (splitStack1.size()>0) {
         merge.push(splitStack1.pop());
      }
      while (splitStack2.size()>0) {
        merge.push(splitStack2.pop());
     }

     System.out.println("Merged Stack: "+merge.toString());
     System.out.println("Merged Stack peek: "+merge.peek());

    }

    }
   


