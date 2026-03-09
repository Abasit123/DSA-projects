

class Node{
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
  }
}
class Linkedlist{
        private Node head;
        Linkedlist()
        {
           head= null;
        }

       //INSERTION
        public void insertAtBeginning(int data)
        {
          Node newNode= new Node(data);
          newNode.next= head;
          head= newNode;
        }
        public void insertAtEnd(int data)
        {

          Node newNode= new Node(data);
          if(head==null)
          {
            newNode.next= head;
            head= newNode;
          }
          else{
           Node current= head;
           while (current.next!=null) {
                 current= current.next;
           }
           current.next= newNode;
          }
        }
        public void insertAtPosition(int data, int position)
        {

          Node newNode= new Node(data);
          if(position==1)
          {
            newNode.next= head;
            head= newNode;
            return;
          }

          Node current = head;
          for(int i=1; i< position-1 && current!=null;  i++)
          {
                current = current.next;
          }
          if(current==null)
          {
            System.out.println("Position out of bounds");
          return;
          }
          newNode.next= current.next;
          current.next= newNode;
        }

        //DELETION
        public void DeleteFromBeginning()
        {
          if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        }

        public void DeleteFromEnd()
        {
          if (head == null) {
            System.out.println("List is empty");
            return;
           }
          if(head.next==null)
          {
             head= head.next;
             return;
          }
           
          Node current= head;
          while (current.next.next!=null) {
              current= current.next;
          }
          current.next=null;
        }

        public void deleteFromPosition(int Position)
        {
          if (head == null) {
            System.out.println("List is empty");
            return;
           }
          if(Position==1)
          {
             head= head.next;
             return;
          }
           Node current= head;

             for(int i=1; i<Position-1 && current!=null; i++)
             {
                     current= current.next;
             }
             if(current==null)
             {
             System.out.println("Position out of bounds");
             return;
             }
             current.next= current.next.next;
        }

          // Traversing
          public void traverse()
          {
            if (head == null) {
              System.out.println("List is empty");
              return;
             }

            Node current= head;
            while (current!=null) {
              System.out.print(current.data+" -> ");
              current=current.next;
            } 
            System.out.println("null");
          }
          // Search
          public boolean search(int data)
        {

            Node current= head;
            while (current!=null) {
              if (current.data==data) {
                return true;  
              }
              current=current.next;
            } 
            return false;
        }


}
public class SinglyLinkedlist{
  public static void main(String[] args) {
    Linkedlist list = new Linkedlist();

    // Insertion Operations
    list.insertAtBeginning(10);
    list.insertAtEnd(30);
    list.insertAtPosition(20, 2);
    list.traverse();  // Output: 10 -> 20 -> 30 -> null

    // Deletion Operations
    list.DeleteFromBeginning();
    list.traverse();  // Output: 20 -> 30 -> null

    list.DeleteFromEnd();
    list.traverse();  // Output: 20 -> null

    list.insertAtEnd(40);
    list.insertAtEnd(50);
    list.insertAtEnd(60);
    list.traverse();  // Output: 20 -> 40 -> 50 -> 60 -> null

    list.deleteFromPosition(3);
    list.traverse();  // Output: 20 -> 40 -> 60 -> null

    // Search Operation
    boolean found = list.search(40);  // Output: true
    System.out.println("Found 40: " + found);

    found = list.search(100);  // Output: false
    System.out.println("Found 100: " + found);
  }

}