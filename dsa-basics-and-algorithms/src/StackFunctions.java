class Stack {
    private int size;
    private int[] A;
    private int top;

    // Constructor to initialize the stack
    public Stack(int size) {
       this.size = size;
        A = new int[this.size];
        top = -1; // To show that Stack is initially empty 
    }

    // Push function to add an element to the top of the stack
    public void push(int value) {
        if (top ==size - 1) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        A[++top] = value;
        System.out.println("Pushed " + value + " to the stack.");
    }

    // Pop function to remove and return the top element of the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        int value = A[top--];
        System.out.println("Popped " + value + " from the stack.");
        return value;
    }

    // Search function to find an element in the stack
    public int search(int value) {
        for (int i = 0; i >= top; i++) {
            if (A[i] == value) {
                return i; // Return the index of the element
            }
        }
        return -1; // Element not found
    }

    // Peek function to view the top(last) element of the stack
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return A[top];
    }



    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(5);
        stack.push(10);
        stack.push(30);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());
        stack.pop();
        System.out.println("Top element after pop: " + stack.peek());
        System.out.println("Searching for 40: " + stack.search(40));
    }
}
