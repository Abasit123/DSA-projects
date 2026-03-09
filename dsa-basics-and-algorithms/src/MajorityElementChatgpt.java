public class MajorityElementChatgpt {

    // Method to find the majority element using Boyer-Moore Voting Algorithm
    public static Integer findMajorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null; // Handle empty or null array
        }

        // Phase 1: Find the candidate for majority element
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        // Phase 2: Verify the candidate
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        } else {
            return null; // No majority element
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};

        Integer majorityElement = findMajorityElement(nums);

        if (majorityElement != null) {
            System.out.println("Majority Element: " + majorityElement);
        } else {
            System.out.println("No majority element found.");
        }
    }
}

