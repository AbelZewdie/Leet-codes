package Arrays.LeetCode_238;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Pass 1: Build prefix products directly into result
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Pass 2: Multiply by running suffix product from the right
        int after = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * after;
            after = after * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        int[] example1 = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(solution.productExceptSelf(example1)));
    }
}
