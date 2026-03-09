import java.util.Arrays;
import java.util.Scanner;

class KthElementFinder {

    public int findKthSmallest(int[] arr, int k) {
        Arrays.sort(arr);  // Sort the array
        return arr[k - 1]; // Kth smallest element
    }

    public int findKthLargest(int[] arr, int k) {
        Arrays.sort(arr);  // Sort the array
        return arr[arr.length - k]; // Kth largest element
    }

    
}
public class LargeSmall{
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter K: ");
        k=sc.nextInt();
        sc.close();

        KthElementFinder find= new KthElementFinder();

        int kthSmallest = find.findKthSmallest(arr, k);
        int kthLargest = find.findKthLargest(arr, k);
        
        System.out.println(k + "th smallest element is: " + kthSmallest);
        System.out.println(k + "th largest element is: " + kthLargest);
    }
}
