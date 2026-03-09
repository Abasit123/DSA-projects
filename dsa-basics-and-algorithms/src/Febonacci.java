import java.math.BigInteger;

public class Febonacci {
    public static int febRec(int n)
    {
        if(n<1) return 0;
        if(n<3) return 1;

        return febRec(n-1)+ febRec(n-2);

    }

    public static BigInteger feb(int n)
    {
        if(n < 1) return BigInteger.ZERO;
        if(n < 3) return BigInteger.ONE;

        BigInteger p = BigInteger.ONE, pp = BigInteger.ONE, feb = BigInteger.ZERO;
        int i = 3;

        while (i<n) {
            feb=p.add(pp);
            pp=p;
            p=feb;
            i++;
        }
        return feb;
    }

    public static void main(String[] args) {
       
        for(int i=80; i<=90; i++)
        {
            long t1= System.nanoTime();

            BigInteger m= feb(i);

            long t2= System.nanoTime();
            
            System.out.println("Fab(non-recursive) "+ i+" is : "+ m+ "   Time: "+(t2-t1));
        }
        for(int i=80; i<=90; i++)
        {
            long t1= System.nanoTime();

            long m= febRec(i);

            long t2= System.nanoTime();
            
            System.out.println("Fab(non-recursive) "+ i+" is : "+ m+ "   Time: "+(t2-t1));
        }
    }
    }
        

