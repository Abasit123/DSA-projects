class Node {
    int data;
    Node next;

    Node(int data) {
        this(data, null); // Call the other constructor
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Method to insert a new value into the sorted list
    Node insert(int x, Node head) {
        if (head == null || head.data > x) { // To insert an element at the start
            return new Node(x, head);
        }

        Node p = head;
        while (p.next != null) {
            if (p.next.data > x) {
                break;
            }
            p = p.next;
        }
        p.next = new Node(x, p.next);
        return head;
    }

    // Method to delete a value from the list
    Node delete(int x, Node head) {
        if (head == null) // List is empty
            return null;

        if (head.data == x) // x is in start
            return head.next;

        Node p = head;
        while (p.next != null) {
            if (p.next.data == x) {
                p.next = p.next.next;
                return head;
            }
            p = p.next;
        }
        return head;
    }

    // Method to search for a value in the list
    boolean search(int x, Node head) {
        Node p = head;
        while (p != null) {
            if (p.data == x)
                return true;
            p = p.next;
        }
        return false;
    }

    // Method to display the list
    void display(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println(); // for a new line after display
    }

    // Method to clone the list
    Node clone(Node head) {
        if (head == null) return null; // Handle null head

        Node clonedHead = new Node(head.data); // Create new head
        Node pOriginal = head.next;
        Node pClone = clonedHead;

        while (pOriginal != null) {
            pClone.next = new Node(pOriginal.data); // Create new node for cloned list
            pClone = pClone.next;
            pOriginal = pOriginal.next;
        }

        return clonedHead;
    }

    // Method to replace the first occurrence of an element with a new value
    Node replace(Node head, int element, int rb) {
        Node p = head;
        while (p != null) {
            if (p.data == element) {
                p.data = rb;
                return head; // Return after replacing the first occurrence
            }
            p = p.next;
        }
        return head; // If the element is not found
    }
}

public class LinkFunctionChatgpt {
    public static void main(String[] args) {
        Node head = new Node(1);
        head = head.insert(5, head); // Inserting 5
        head = head.insert(3, head); // Inserting 3
        head = head.insert(2, head); // Inserting 2
        head.display(head); // Display the linked list

        head = head.delete(3, head); // Delete 3
        head.display(head); // Display after deletion

        System.out.println(head.search(5, head)); // Search for 5
        System.out.println(head.search(10, head)); // Search for 10

        Node clonedList = head.clone(head); // Clone the list
        clonedList.display(clonedList); // Display cloned list

        head = head.replace(head, 2, 4); // Replace 2 with 4
        head.display(head); // Display after replacement
    }
}
