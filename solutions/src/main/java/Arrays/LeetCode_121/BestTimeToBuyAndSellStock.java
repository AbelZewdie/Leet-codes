package Arrays.LeetCode_121;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices){
        int minPrice = prices[0]; // Create a variable to trace the minimum price.
        int maxProfit = 0; // a variable to trace the maximum profit.

        // we will start the loop from 1 because index 0 is already set for minPrice.
        for (int i = 1; i < prices.length; i++){

            // update the minPrice if today's price is lower.
            if (prices[i] < minPrice){      // if the current i is less than the minPrice... put the current price in the minPrice place.
                minPrice = prices[i];
            }

            // check if today's profit beats maxProfit.
            if ((prices[i] - minPrice) > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        System.out.println("Example 1: " + solution.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }
}
