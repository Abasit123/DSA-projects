class Node{
     int data;
     Node next;
     Node(int data){
        this.data=data;
     }
     Node(int data, Node next){
        this.data=data;
        this.next=next;
     }
     Node insert(int x, Node head){
        //Pre-Condition: List head is in ascending order and start.data<x
        //Post-condtion: list head is in ascending order

        if(head==null || head.data>x)// To insert an element in start
        {
            head= new Node(x, head);
            return head;

        }

        Node p= head;
        while(p.next!=null){
            if(p.next.data>x)
            break;
            p=p.next;
        }
        p.next= new Node(x, p.next);
        return head;

     }
     
     Node delete(int x, Node head){
       if(head==null || head.data>x )// x is absent
         return head;

       if(head.data==x)
         return head.next; // x is in start

        for(Node p=head; p.next!=null; p=p.next){

            if(p.next.data>x)
                break;
            if(p.next.data==x){
                p.next=p.next.next;
                break;
            }
            
        }
        return head;    


     }
     boolean search(int x, Node head){
        if(head==null || head.data>x )// x is absent
          return false;
 
        if(head.data==x)
          return true; // x is in start
 
         for(Node p=head; p.next!=null; p=p.next){
 
             if(p.next.data>x)
                 break;
             if(p.next.data==x)
             return true;
         }   
         return false;    
 
 
      }
      void display(Node head){
        for(Node p=head; p!=null; p=p.next){
            System.out.println(p.data);
        }
      }

      Node clone(Node head){
        Node head2= new Node(head.data);
         Node temp= head.next;
         while (temp!=null) {
             head2= insert(head.next.data, head2);
             temp=temp.next;
         }


        return head2;

      }
      Node replace(Node head, int element, int rb){
        
        for(Node p=head; p!=null;p=p.next){
            if(p.data==element){
                p.data=rb;
                return head;
            }
        }
           return head;
      }

      Node merge(Node head1, Node head2){
        if(head1 ==null)
        return head2;
        if(head2==null)
        return head1;
        Node temp= head1;
        while(temp.next!=null){
          temp= temp.next;
        }
        temp.next=head2;
        return head1;
      }
      
      

}
public class LinkFunctions{
  public static void main(String[] args) {
       Node head= new Node(2);
      
  }
}


