public class BinarySearch2DRecursive {

    // Helper function to perform binary search recursively
    private static boolean binarySearch2DRecursive(int[][] matrix, int left, int right, int target) {
        if (left > right) {
            return false;
        }

        int mid = left + (right - left) / 2;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int midValue = matrix[mid / cols][mid % cols];

        if (midValue == target) {
            return true;
        } else if (midValue < target) {
            return binarySearch2DRecursive(matrix, mid + 1, right, target);
        } else {
            return binarySearch2DRecursive(matrix, left, mid - 1, target);
        }
    }

    // Public function to initialize the binary search process
    public static boolean binarySearch2D(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        return binarySearch2DRecursive(matrix, left, right, target);
    }

    public static void main(String[] args) {
        // Example usage
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };
        int target = 5;

        boolean found = binarySearch2D(matrix, target);

        if (found) {
            System.out.println("Element found in the matrix.");
        } else {
            System.out.println("Element not found in the matrix.");
        }
    }
}
