package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-4
 */
public class BestTimetoBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy = 0;
        int sell = 1;
        int days = prices.length;
        int maxProfit = 0;
        while (sell < days) {
            int p1 = prices[buy];
            int p2 = prices[sell];
            if (p1 >= p2) {
                buy = sell;
                sell++;
            } else {
                maxProfit = Math.max(maxProfit, p2 - p1);
                sell++;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimetoBuyAndSellStock bs = new BestTimetoBuyAndSellStock();
        int[] a = {7, 6, 4, 3, 1};
        System.out.println(bs.maxProfit(a));
    }
}
