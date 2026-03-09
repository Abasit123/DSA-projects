public class TowerOfHanoiGPT
 {

    // Recursive function to solve the Tower of Hanoi
    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        // Base case: if only one disk, move it directly
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        } 

        // Move n-1 disks from source to auxiliary, using destination as helper
        solveHanoi(n - 1, source, destination, auxiliary);

        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move n-1 disks from auxiliary to destination, using source as helper
        solveHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3; // You can change this value to test for different numbers of disks

        // Call the recursive function
        System.out.println("Steps to solve Tower of Hanoi with " + numberOfDisks + " disks:");
        solveHanoi(numberOfDisks, 'A', 'B', 'C');
    }
}
