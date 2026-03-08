public class Stack {
    private City top;
    private int size;

    public void push(City city) {
        size++;
        City newTop = new City(city); // Copy city data
        if (top == null) {
            top = newTop;
            return;
        }
        newTop.next = top;
        top = newTop;
    }

    public City pop() {
        if (size == 0) throw new IllegalStateException("stack is empty");
        City temp = top;
        top = top.next;
        size--;
        return temp;
    }

    public void addCities(LinkedList L) {
        City current = L.head;
        while (current != null) {
            push(current);
            current = current.next;
        }
    }

    public City peek() {
        if (size == 0) throw new IllegalStateException("stack is empty");
        return top;
    }

    public int size() {
        return size;
    }
}
