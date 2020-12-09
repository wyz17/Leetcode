

# 121. Best Time to Buy and Sell Stock

### 题目

链接：https://leetcode.com/problems/best-time-to-buy-and-sell-stock/



### 思路 - 遍历循环

#### 步骤

- 只要找出当前的min和max就好



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0 ; i < prices.length; i++){
            if(prices[i] < min)
                min = prices[i];
            else if(prices[i] - min > profit){
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}
```



##### Python

```python
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_value = float('inf')
        max_profit = 0
        for i in  prices:
            min_value = min(i, min_value)
            profit = i - min_value
            max_profit = max(max_profit, profit)
        return max_profit
        
```



## Python知识点

### Python中没有Integer.MAX_VALUE的方法

- 替换参考：正负无穷

  - ```python
    float("inf"), float("-inf")
    ```