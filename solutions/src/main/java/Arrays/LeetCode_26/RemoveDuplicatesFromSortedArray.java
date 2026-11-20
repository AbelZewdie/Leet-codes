package Arrays.LeetCode_26;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int trackingPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[trackingPosition]) {
                trackingPosition++;
                nums[trackingPosition] = nums[i];
            }
        }

        return trackingPosition + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

        // Example 1
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Example 1 Count: " + k1); // Expected: 2
        System.out.print("Example 1 Array: ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " "); // Expected: 1 2
        }
        System.out.println("\n");

        // Example 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Example 2 Count: " + k2); // Expected: 5
        System.out.print("Example 2 Array: ");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " "); // Expected: 0 1 2 3 4
        }
        System.out.println();
    }
}