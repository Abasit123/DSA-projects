import java.util.Scanner;

class Node{
    int data;
    Node next;
    static int size;

    Node(int data){
        this.data=data;
        size++;
    }

}

public class HwTask {
    public static void main(String[] args) {
         Scanner sc= new Scanner(System.in);

         // Take input
         System.out.println("Enter Elements");
         int element= sc.nextInt();
         sc.close();

        Node start= new Node(element);
          Node p= start;
        
        for(int i=0; i<4; i++)
        {
               element= sc.nextInt();
               p.next= new Node(element);
               p= p.next;
        }
         
        //Display Elements
         System.out.println("Your elements are:");
        for(Node q=start; q!=null; q=q.next)
        {
            System.out.println(q.data);
        }
        //Display Number of elements
        System.out.println("Number of elements: "+Node.size);
    }

    
}
