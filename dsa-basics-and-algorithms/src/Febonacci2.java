

public class Febonacci2 {
    public static long febRec(int n)
    {
        if(n<1) return 0;
        if(n<3) return 1;

        return febRec(n-1)+ febRec(n-2);

    }

    public static long feb(int n)
    {
        if(n < 1) return 0;
        if(n < 3) return 1;

        long p = 1, pp = 1, feb = 0;
        int i = 3;

        while (i<=n) {
            feb=p+pp;
            pp=p;
            p=feb;
            i++;
        }
        return feb;
    }

    public static void main(String[] args) {
       
        for(int i=10; i<=20; i++)
        {
            long t1= System.nanoTime();

            long m= feb(i);

            long t2= System.nanoTime();
            
            System.out.println("Fab(non-recursive) "+ i+" is : "+ m+ "   Time: "+(t2-t1)+" ns");
        }
       System.out.println("\n\n");
        for(int i=10; i<=20; i++)
        {
            long t1= System.nanoTime();

            long m= febRec(i);

            long t2= System.nanoTime();
            
            System.out.println("Fab(recursive) "+ i+" is : "+ m+ "   Time: "+(t2-t1)+" ns");
        }
        
    }
    }
        

