public class LabTask1 {
    static int[] functionMain(){
        return new int[]{1,3};
      }
       int[] functionMain2(){
        return new int[]{1,3};
      }
      
    public static void main(String[] args) throws Exception {

        int[] A;  //Declare
        A= new int[20];  //Assign Size
         

        // Enter Elements
        int value=1;
        for(int i=0; i<A.length; i++)
        {
             A[i]=value;
             value++;
        }
        // Print
        for(int x: A)
        {
            System.out.println(x);
        }

        String[] B= new String[5] ;
        float[] C= new float[5] ;
        
          for(String i: B)
          System.out.println(i);

          for(float i: C)
          System.out.println(i);
        
          
          System.out.println(functionMain()[1]);

          LabTask1 Obj= new LabTask1();
          System.out.println(Obj.functionMain2()[0]);

    }
}
