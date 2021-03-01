

# 123. Best Time to Buy and Sell Stock III

### 题目

链接：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/



### 思路

#### 步骤

- 使用 局部最优 和 全局最优 解法

- 维护两个变量并得出对应的递推式

  - global\[i][j]：当前到达第 i 天可以最多进行 j 次交易，最好的利润是多少

    - 递推公式：global\[i][j] = max( local\[i][j], global\[i-1][j] )
    - 就是取当前局部最好的，和历史全局最好的中，较大的数；因为最后一次交易如果更大，则会更新在local里面，否则就是原global

  - local\[i][j]：当前到达第 i 天，最多可进行 j 次交易，并且最后一次交易在当天卖出的最好的利润是多少

    - 递推公式：local\[i][j] = max( global\[i-1][j-1] + max(diff, 0), local\[i-1][j] + diff )

      - global\[i-1][j-1] + max(diff, 0)：是全局到i-1天进行j-1次交易，然后加上今天的交易；如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天）

      - local\[i-1][j] + diff：取local第i-1天j次交易，然后加上今天的差值（这里因为local\[i-1][j]比如包含第i-1天卖出的交易，所以现在变成第i天卖出，并不会增加交易次数，而且这里无论diff是不是大于0都一定要加上，因为否则就不满足local\[i][j]必须在最后一天卖出的条件了）



#### 复杂度

时间：` O(n * k)`，对于天数需要一次扫描，而每次要对交易次数进行递推式求解，如果是最多进行两次交易，那么复杂度还是 O ( n )

空间：` O(k)`：空间上只需要维护当天数据皆可以，所以是O(k)，当k=2，则是O(1)



#### 代码

##### Java

```java

```



##### Python

```python

```



