class Node {
    Object data;
    int value;
    Node next;

    Node(Object data) {
        this.data = data;
        this.next = null;
    }

    Node(Object data, int value) {
        this.data = data;
        this.value = value;
        this.next = null;
    }

    public static Node insert(Object data, int id, Node ObjectNode) {
        Node p = ObjectNode;
        Node newnode = new Node(data, id);

        if (ObjectNode == null || ObjectNode.value > id) {
            newnode.next = ObjectNode;
            return newnode;
        }
        while (p.next != null) {
            if (p.next.value > id) {
                break;
            }
            p = p.next;
        }
        newnode.next = p.next;
        p.next = newnode;
        return ObjectNode;
    }
}

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Name: " + name + "\nID: " + id;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
}

public class DSATheoryTask {
    public static void main(String[] args) {
        Student S1 = new Student(15, "Jibram");
        Student S2 = new Student(24, "Sachin");
        Student S3 = new Student(3, "Akkhtar");

        Node ObjectNode = null;
        ObjectNode = Node.insert(S1, S1.getId(), ObjectNode);
        ObjectNode = Node.insert(S2, S2.getId(), ObjectNode);
        ObjectNode = Node.insert(S3, S3.getId(), ObjectNode);

        Node temp = ObjectNode;
        while (temp != null) {
            System.out.println(temp.data.toString() + " ");
            temp = temp.next;
        }
    }
}