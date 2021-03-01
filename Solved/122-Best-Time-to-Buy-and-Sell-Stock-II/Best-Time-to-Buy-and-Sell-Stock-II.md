

# 122. Best Time to Buy and Sell Stock II

### 题目

链接：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/



### 思路

#### 步骤

- 看图啦！
- ![Profit Graph](https://leetcode.com/media/original_images/122_maxprofit_2.PNG)
- 所以maxProfit就是每一小段每一小段利润之和



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i+1] - prices[i] > 0) {
                maxProfit += prices[i+1] - prices[i];
            }
        }
        return maxProfit;
    }
}
```



##### Python

```python
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        for i in range(len(prices) - 1):
            if prices[i+1] - prices[i] > 0:
                res += prices[i+1] - prices[i]
        return res
```



