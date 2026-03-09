import java.util.Scanner;

class Contact{
    String[][] C;
    int r;
    int c;
    int flagr=0;
    int flagc=0;
    int contactCount=0;
    Contact(int r, int c)
    {
        this.r=r;
        this.c=c;
        C= new String[r][c];
    }
    Scanner sc= new Scanner(System.in);

    int menu(){
        System.out.println("Select:");
        System.out.println("1: Display Contacts");
        System.out.println("2: Add Contact");
        System.out.println("3: Search Contact:");
        System.out.println("4: Delete Contact");
        System.out.println("5: Update Contact");
        System.out.println("6: Exit");
        int option= sc.nextInt();
        return option;
    }

    void display()
    {
        for(int i=0; i<C.length; i++)
        {
             for(int j=0; j<C[i].length; j++)
             {
                System.out.println(C[i][j]);
             }
        }
    }

    void add(){
        if(C[r-1][0]!=null)
        {
            System.out.println("Memory Full");
        }
        else{
            for(int i=0; i<C.length ; i++)
            {
              
               if(C[i][0]==null)
               {
                 break;
               }
               else{
                 flagr++;
               }   
            }
            sc.nextLine();
            System.out.println("Enter Name");
            C[flagr][flagc]= sc.nextLine();
            flagc++;
            System.out.println("Enter Number");
            C[flagr][flagc]= sc.nextLine();
            System.out.println("Contact added successfully.");
            flagr=0;
            flagc--;
            contactCount++;
        }

    }

    void Search(){
        String Name;
        boolean found= false;
        System.out.println("Ener Name to search:");
        sc.nextLine();
        Name= sc.nextLine();
        for(int i=0; i<contactCount; i++)
        {
            
            if(C[i][0].toLowerCase().contains(Name.toLowerCase())) {
                 System.out.println(C[i][0]);
                 System.out.println(C[i][1]);
                 
                found=true;
            
        }
        
        
        
        }
        if(!found)
        {
            System.out.println("Contact Not Found");
        }

    }

    void update()
    {
        boolean found=false;
        System.out.println("Enter the name of contact you want to update");
        sc.nextLine();
        String Name=sc.nextLine();
        for(int i=0; i<contactCount; i++)
        {
           
            if(C[i][0].equalsIgnoreCase(Name)) {
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new number: ");
                String newNumber = sc.nextLine();

                C[i][0] = newName;
                C[i][1] = newNumber;
                System.out.println("Contact updated successfully.");
                found=true;
            
        }
        
        }
        
        if(!found)
        {
            System.out.println("Contact Not Found");
        }
        

    }
    void delete()
    {
        System.out.print("Enter the name of the contact to delete: ");
        sc.nextLine();
        String name = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < contactCount; i++) {
            if (C[i][0].equalsIgnoreCase(name)) {
                for (int j = i; j <contactCount - 1; j++) {
                    C[j][0] = C[j + 1][0];
                    C[j][1] = C[j + 1][1];
                }
                C[contactCount - 1][0] = null;
                C[contactCount - 1][1] = null;
                
                System.out.println("Contact deleted successfully.");
                contactCount--;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }


}
public class ContactMain {
      public static void main(String[] args)
      {

        Contact contact= new Contact(4,2);
       
        int choice;
        do{
         choice=contact.menu();
        
        switch (choice) {
            case 1:
               contact.display();
             break;
            
             case 2:
                contact.add();
                break;

                case 3:
                 contact.Search();
                 break;

                 case 4:
                 contact.delete();
                 break;

                 case 5:
                 contact.update();
                 break;
                
                 case 6:
                      break;

                 default:  
                 System.out.println("Inavlide Choice");
                 
        
        }
    }while (choice!=6) ;
            
        
        
      
        
        
       
      }
    }

