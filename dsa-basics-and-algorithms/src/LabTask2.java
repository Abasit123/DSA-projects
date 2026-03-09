class BinarySearch{

      int OneD(int[] A, int key) {

        int first, last;
          first= 0;
          last= A.length-1;
          int index=-1;
          int count =0;
          while(first<=last){
          int mid= first+(last-first)/2;
          
          if (A[mid] == key) {
            index = mid;
            count++;
            int a = mid-1;
            while (a>=first && A[a]==key) {
                a--;
                count++;
            }
            int b = mid+1;
            while (b<=last && A[b]==key) {
                b++;
                count++;
            }
            return count;
            
        } else if (A[mid] < key) {
            first = mid + 1;
        } else {
            last = mid - 1;
        }
    }
       
    return -1;
               
   }
   public static int[] binarySearch(int[][] matrix, int target) {

    int rows = matrix.length;
    int cols = matrix[0].length;
    int left = 0;
    int right = rows * cols - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midValue = matrix[mid / cols][mid % cols];

        if (midValue == target) {
            return new int[] {mid / cols, mid % cols}; // target found
        } else if (midValue < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return new int[] {-1, -1};
       

   }


}


public class LabTask2 {
    public static void main(String[] args) {
        
    
    int A[]= {2,4,6,8,10,11,11,22,22};
    BinarySearch search= new BinarySearch();
    int count= search.OneD(A, 22);
    System.out.println("Found");
    
    }
}
