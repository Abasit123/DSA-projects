

class Array{

    
    int[] update(int A[], int index, int value){
        
            if (index < 0 || index >= A.length) {
                throw new ArrayIndexOutOfBoundsException("Index out of bounds");
            }
            A[index] = value;
            return A;
    }
       
   
    
    int[] delete1(int A[], int index){
        int size= A.length;

       if (index < 0 || index > A.length) {
           throw new ArrayIndexOutOfBoundsException("Index out of bounds");
       }

       int[] temp= new int[size-1];

       for(int i=0; i<index; i++)
       {
            temp[i]= A[i];
       }
       
       System.arraycopy(A, index+1, temp, index, (size-index)-1);
        
       return temp;
       
   }
   int[] delete2(int A[], int index){
    int size= A.length;

   if (index < 0 || index > A.length) {
       throw new ArrayIndexOutOfBoundsException("Index out of bounds");
   }

   int[] temp= new int[size-1];

   System.arraycopy(A, 0, temp, 0, index);
   for(int i=index; i<size-1; i++)
   {
     temp[i]=A[i+1];
   }
    
   return temp;
   
}
    
    int[] insert1(int A[], int index, int value){
         int size= A.length;

        if (index < 0 ) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        if(index > A.length)
        {
           A= resize(A);
        }

        int[] temp= new int[size+1];

        for(int i=0; i<index; i++)
        {
             temp[i]= A[i];
        }
        temp[index]=value;
        System.arraycopy(A, index, temp, index+1, size-index);
         
        return temp;
        
    }
    int[] insert2(int A[], int index, int value){
        int size= A.length;

       if (index < 0 || index > A.length) {
           throw new ArrayIndexOutOfBoundsException("Index out of bounds");
       }

       int[] temp= new int[size+1];

       for(int i=0; i<index; i++)
       {
            temp[i]= A[i];
       }
       temp[index]=value;
       for(int i=index; i<size; i++){
          temp[i+1]= A[i];
       }
        
       return temp;
       
   }
    
    int minimumValue(int A[]){

        int size= A.length;
        int min= A[0];

        for(int i=0; i<size; i++){
            if(min>A[i])
               min= A[i];
            
        }
        return min;
        
    }
    int maximumValue(int A[]){

        int size= A.length;
        int max= A[0];

        for(int i=0; i<size; i++){
            if(max<A[i])
               max= A[i];
            
        }
        return max;
        
    }
    int[] reverse(int[] A){

        int size= A.length;
        int start= 0;
        int end= size-1;
        int temp=0;

        while(start<end){

           temp= A[start];
           A[start]=A[end];
           A[end]=temp;

           start++;
           end--;

        }
        return A;
    }
    
    boolean sortCheck(int[] A){

        boolean isSorted=true;

        for(int i=0; i<A.length-1; i++){

            if(A[i]>A[i+1])
            {
            isSorted=false;
            break;
            }
              
        }
        return isSorted;
    } 
    int[] resize(int A[])
    {
        int size= A.length;
        int[] newArray= new int[size*2];
        System.arraycopy(A,0, newArray,0, size);
        A= newArray;
        return A;
    }
    void display(int[] A)
    {
        int size= A.length;
        for(int i=0; i<size; i++)
        {
            System.out.print(A[i]+ " ");
        }
    }
}


public class Arrays {

    public static void main(String[] args) {
        int[] B= {2,1,5,5,7,19,0,-1};
        int[] BSorted= {-1,0,1,2,5,5,7,19};
        Array A= new Array();
        
        B=A.insert1(B, 8, 5);
        for(int i: B)
        {
            System.out.print(i+ " ");
        }
        //MIN AND MAX
        System.out.println(A.minimumValue(B));
        System.out.println(A.maximumValue(B));
        
        //REVERSE
        for(int e: A.reverse(B)){
            System.out.print(e+"  ");
        }

        //SORT-CHECK
        System.out.println("\nArray is sorted: "+ A.sortCheck(B));
        System.out.println("Array is sorted: "+ A.sortCheck(BSorted));
        
        //INSERT
        for(int i: A.insert1(B, 4, 50)){
            System.out.print(i+" ");
        }
        System.out.println("");
        for(int i: A.insert2(B, 6, 1000)){
            System.out.print(i+" ");
        }

        //DELETE
        System.out.println("");
        for(int i: A.delete1(BSorted, 3)){
            System.out.print(i+" ");
        }
        System.out.println("");
        for(int i: A.delete2(BSorted, 0)){
            System.out.print(i+" ");
        }

        //Update
        System.out.println("");
        for(int i: A.update(BSorted, 5,7)){
            System.out.print(i+" ");
        }
}
}