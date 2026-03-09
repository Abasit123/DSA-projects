class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Static method to insert a new element into a sorted linked list
    static Node insert(int x, Node head) {
        if (head == null || head.data > x) {
            return new Node(x, head);
        }

        Node current = head;
        while (current.next != null && current.next.data <= x) {
            current = current.next;
        }

        current.next = new Node(x, current.next);
        return head;
    }

    // Static method to delete an element from a sorted linked list
    static Node delete(int x, Node head) {
        if (head == null) {
            return null;
        }

        if (head.data == x) {
            return head.next;
        }

        Node current = head;
        while (current.next != null && current.next.data != x) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }

        return head;
    }

    // Static method to search for an element in a sorted linked list
    static boolean search(int x, Node head) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return true;
            }
            if (current.data > x) {
                return false;
            }
            current = current.next;
        }
        return false;
    }

    // Static method to display the linked list
    static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Static method to clone a sorted linked list
    static Node clone(Node head) {
        if (head == null) {
            return null;
        }

        Node newHead = new Node(head.data);
        Node newCurrent = newHead;
        Node originalCurrent = head.next;

        while (originalCurrent != null) {
            newCurrent.next = new Node(originalCurrent.data);
            newCurrent = newCurrent.next;
            originalCurrent = originalCurrent.next;
        }

        return newHead;
    }

    // Static method to replace an element in a sorted linked list
    static Node replace(Node head, int element, int replacement) {
        Node current = head;
        while (current != null) {
            if (current.data == element) {
                current.data = replacement;
                return head;
            }
            current = current.next;
        }
        return head;
    }

    // Static method to merge two sorted linked lists
    static Node merge(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.data < head2.data) {
            head1.next = merge(head1.next, head2);
            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }
}

public class LinkFunctions {
    public static void main(String[] args) {
        Node head = new Node(2);
        head = Node.insert(1, head);
        head = Node.insert(4, head);
        head = Node.insert(3, head);

        System.out.println("Original List:");
        Node.display(head);

        head = Node.delete(4, head);
        System.out.println("After Deleting 4:");
        Node.display(head);

        System.out.println("Search for 3: " + Node.search(3, head));

        Node clonedHead = Node.clone(head);
        System.out.println("Cloned List:");
        Node.display(clonedHead);

        head = Node.replace(head, 2, 5);
        System.out.println("After Replacing 2 with 5:");
        Node.display(head);

        Node mergedHead = Node.merge(head, clonedHead);
        System.out.println("Merged List:");
        Node.display(mergedHead);
    }
}
