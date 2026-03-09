/*
    RULES:
    1. Only one disk can be moved among the towers at any given time.
    2. Only the "top" disk can be removed.
    3. No large disk can sit over a small disk.

   ALGORITHM
    
   1. Move (n-1)th disc from the source to aux.
   2. Move the last disc from souce to dest
   3. Move (n-1)th disc from aux dest. 

 */

public class TowerOfHanoi {
    static void hanoi(int n, char source, char aux, char dest)
    {
        if(n==1)
        System.out.println("Base: "+ source+ "-->"+dest);

        else
        {

            hanoi(n-1, source, aux, dest);
            System.out.println("Take disc "+n+" to destination");
            hanoi(n-1, source, dest, source);
        }
    }

    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }
}
