public class Queue {
    private class Node {
        Patient data;
        Node next;
    
        Node(Patient data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void add(Patient data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public Patient poll() {
        if (front == null) {
            return null;
        }
        Patient data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        Node current = front;
        while (current != null) {
            System.out.println("Name: " + current.data.name + ", Age: " + current.data.age);
            current = current.next;
        }
    }
}






