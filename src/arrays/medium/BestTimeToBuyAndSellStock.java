package arrays.medium;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0, cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - cost);
            cost = Math.min(cost, prices[i]);
        }
        return maxProfit;
    }
}
