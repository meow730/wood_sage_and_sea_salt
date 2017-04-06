public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int max = 0; int curMin = prices[0];
    for (int i = 1; i < prices.length; i++) {
      max = Math.max(prices[i] - curMin, max);
      curMin = Math.min(curMin, prices[i]);
    }
  return max;
}
