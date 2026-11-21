package Arrays.LeetCode_53;

public class MaximumSubarray {

    public int maxSubArray(int[] nums){
        int globalMax = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++){
            currentMax = Math.max(nums[i], (currentMax + nums[i]));
            globalMax = Math.max(currentMax, globalMax);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();

        int[] example1 = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int[] example2 = new int[] {1};
        int[] example3 = new int[] {5,4,-1,7,8};

        System.out.println("\nExample 1: \n  Input: nums = [-2,1,-3,4,-1,2,1,-5,4] \n  Answer: " + solution.maxSubArray(example1));
        System.out.println("\nExample 2: \n  Input: nums = [1] \n  Answer: " + solution.maxSubArray(example2));
        System.out.println("\nExample 3: \n  Input: nums = [5,4,-1,7,8] \n  Answer: " + solution.maxSubArray(example3));
    }
}
