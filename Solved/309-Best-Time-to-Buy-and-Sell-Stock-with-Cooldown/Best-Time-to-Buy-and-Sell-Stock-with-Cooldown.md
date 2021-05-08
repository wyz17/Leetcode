

# 309. Best Time to Buy and Sell Stock with Cooldown

### 题目

链接：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/



### 思路 - Dynamic Programming

#### 步骤

- 设立两个状态数组
- **buy[i]**：第i天最后一个动作是购买，可获得的最大利润
  - buy[i] = max (sell[i-2] - price, buy[i - 1])
  - 可以分别是前面i-1天中买的，或者是在第i天买的（由于有cooldown，只能是sell[i-2]）
- **sell[i]**：第i天最后一个动作是卖，可获得的最大利润
  - sell[i] = max (buy[i - 1] + price, sell[i - 1])
  - 表示前i天的任意序列中以sell为结尾的最大利润
- 全局最优肯定不能以持有结束，只会是sell[N-1]

**空间优化：**

- 用三个变量存储

  - buy：代表购买的状态
  - sell：代表卖出的状态
  - rest：代表冷冻期状态

  ![alt text](https://raw.githubusercontent.com/hot13399/leetcode-graphic-answer/master/Best%20Time%20to%20Buy%20and%20Sell%20Stock%20with%20Cooldown.jpg)



#### 复杂度

时间： `O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] buy = new int[prices.length + 1];
        int[] sell = new int[prices.length + 1];
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[1] = Math.max(0, prices[1] - prices[0]);
        for(int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        return sell[prices.length - 1];
    }
}

//空间优化
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int sell = 0;
        int buy = -prices[0];
        int rest = 0;
        
        for(int i = 0; i < prices.length; i++) {
            int pre_sell = sell;
            sell = buy + prices[i];
            buy = Math.max(buy, rest - prices[i]);
            rest = Math.max(rest, pre_sell);   
        }
        return Math.max(sell, rest);
    }
}
```



##### Python

```python
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) <= 1:
            return 0
        sell, buy, rest = 0, -prices[0], 0
        for price in prices:
            pre_sell = sell
            sell = buy + price
            buy = max(buy, rest - price)
            rest = max(rest, pre_sell)
        return max(rest, sell)
```

