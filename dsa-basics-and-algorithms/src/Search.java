public class Search {
    public static void main(String[] args) {
        int A[]= {2,4,6,5,10,5};
        LinearSearch search= new LinearSearch();
        long start= System.nanoTime();
         search.SearchCount(A, 5);
        long end= System.nanoTime();
        
        long time= end - start;
        System.out.println("Execution Time: "+time+" ns");
        
        System.out.println("Element Found: "+search.search(A, 7));
        int B[][]={{1,2},
                   {4,8},
                   {7,10},

                    };
        System.out.println("Element Found: "+search.search2D(B, 7));
        System.out.println(search.linearSearch2D2(B, 10));

    }
    
}
class LinearSearch{ 

    void SearchCount(int arr[], int element){
     int size= arr.length;
     int count=0;
      for(int i=0; i<size; i++){
         if(arr[i]==element){
          count++;   
         }

      }
      if(count==0)
      System.out.println("Element not found");
      else
      System.out.println("Element found " +count+ " times");

    }
    boolean search(int A[], int element){
        int size= A.length;
        boolean elementFound=false;
        for(int i=0; i<size; i++){
            if(A[i]==element){
                elementFound=true;
                return elementFound;
            }

        }
        return elementFound;

    }

    boolean search2D(int A[][], int element){
        int size= A.length;
        boolean elementFound=false;

        for(int i=0; i<size; i++){

            for(int j=0; j<A[i].length; j++)
            {
                if(A[i][j]==element)
                {
                    elementFound=true;
                    return elementFound;
                }
            }
        }
        return elementFound;
    }
     int[] linearSearch2D2(int[][] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return new int[]{i, j}; // Return the index (row and column) of the target element
                }
            }
        }
        return new int[]{-1, -1}; // Return (-1, -1) if the target is not found
    }

}