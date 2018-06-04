package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-4
 */
public class BestTimetoBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int days = prices.length;
        int buy = 0, sell = 1;
        int localMaxProfit = 0, globalMaxProfit = 0;
        while (sell < days) {
            int p1 = prices[buy];
            int p2 = prices[sell];
            if (p1 >= p2 || p2 < prices[sell - 1]) {
                globalMaxProfit += localMaxProfit;
                localMaxProfit = 0;
                buy = sell;
                sell++;
            } else {
                localMaxProfit = p2 - p1;
                sell++;
            }
        }
        globalMaxProfit += localMaxProfit;
        return globalMaxProfit;
    }

    public static void main(String[] args) {
        BestTimetoBuyAndSellStockII btii = new BestTimetoBuyAndSellStockII();
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] b = {1, 2, 3, 4, 5};
        int[] c = {5, 4, 3, 2, 1};
        System.out.println(btii.maxProfit(c));
    }
}
