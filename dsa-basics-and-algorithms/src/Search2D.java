

import java.util.Arrays;

class Main {

    // Function to perform binary search on a specific row
    static boolean binarySearch(int[][] mat, int row, int x) {

        int lo = 0;
        int hi = mat[0].length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mat[row][mid] == x) {
                return true;
            }
            if (mat[row][mid] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

    // Function to find the appropriate row and search within it
    static boolean searchSortedMatrix(int[][] mat, int x) {
        int n = mat.length;          // Number of rows
        int m = mat[0].length;       // Number of columns

        int lo = 0;
        int hi = n - 1;      // Row indices
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // Check the leftmost and rightmost elements of the row
            if (x == mat[mid][0] || x == mat[mid][m - 1]) {
                return true;
            }

            // Check if x is within the range of the current row
            if (x > mat[mid][0] && x < mat[mid][m - 1]) {
                return binarySearch(mat, mid, x);
            }

            // Adjust row search boundaries
            if (x < mat[mid][0]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return false;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] mat = {
        		{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        


        int x = 6; // Element to search

        boolean result = searchSortedMatrix(mat, x);
        System.out.println(result ? "true" : "false");
    }
}

