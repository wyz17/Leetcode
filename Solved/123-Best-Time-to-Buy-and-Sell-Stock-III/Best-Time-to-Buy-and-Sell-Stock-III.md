

# 123. Best Time to Buy and Sell Stock III

### 题目

链接：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/



### 思路

#### 步骤

- 使用 局部最优 和 全局最优 解法

- 维护两个变量并得出对应的递推式

  - global\[i][j]：当前到达第 i 天可以最多进行 j 次交易，最好的利润是多少

    - 递推公式：**global\[i][j] = max ( local\[i][j], global\[i-1][j] )**
    - 就是取当前局部最好的，和历史全局最好的中，较大的数；因为最后一次交易如果更大，则会更新在local里面，否则就是原global

  - local\[i][j]：当前到达第 i 天，最多可进行 j 次交易，并且最后一次交易在当天卖出的最好的利润是多少

    - 递推公式：**local\[i][j] = max( global\[i-1][j-1] + max(diff, 0), local\[i-1][j] + diff )**

      - global\[i-1][j-1] + max(diff, 0)：是全局到i-1天进行j-1次交易，然后加上今天的交易（如果今天赚钱）；也就是前面只要j-1次交易，最后一次交易取当前天
    - local\[i-1][j] + diff：取local第i-1天j次交易，然后加上今天的差值（这里因为local\[i-1][j]比如包含第i-1天卖出的交易，所以现在变成第i天卖出，并不会增加交易次数，而且这里无论diff是不是大于0都一定要加上，因为否则就不满足local\[i][j]必须在最后一天卖出的条件了）
    - 递推公式更新：**local\[i][j] = max(global\[i - 1][j - 1], local\[i - 1][j]) + diff**
      - 第 i 天卖第 j 支股票的话，一定是下面的一种：
        - 今天刚买的：那么 Local(i, j) = Global(i-1, j-1)，相当于啥都没干（不需要考虑的，因为当天买当天卖不会增加利润，完全是重复操作，这种情况可以归纳在global\[i-1][j-1]中，所以我们就不需要max(0, diff)了，那么由于两项都加上了diff，所以我们可以把diff抽到max的外面）
        - 昨天买的：那么 Local(i, j) = Global(i-1, j-1) + diff，等于Global(i-1, j-1) 中的交易，加上今天干的那一票
        - 更早之前买的：那么 Local(i, j) = Local(i-1, j) + diff，昨天别卖了，留到今天卖



- 可以这样理解

  - 对于局部变量，第i天最多进行j次交易，可以分两种情况

    - 第一种：第j次交易就是前一天（i-1）买入，当天（i）卖出，所以最大收益就是  global\[i-1][j-1] + max(diff, 0)， diff为第i天当天股价变化
    - 第二种：第j次交易早就买入了，但是拖到第i天当天才卖出。可以当作：第i-1天卖出的收益 + 第i天当天的股价变化，所以就是local\[i-1][j] + diff

    

空间优化：这里 global\[i][j] & local\[i][j] 可以替换为两个**一维数组** ```int[3]```

我们如果假设prices数组为1, 3, 2, 9, 那么我们来看每次更新时local 和 global 的值：

第一天两次交易：　　　　　　第一天一次交易：

local:　　  0 0 0 　　　　　	local:　　  0 0 0 

global:　　0 0 0　　　　　 　global:　　0 0 0

第二天两次交易：　　　　　　第二天一次交易：

local:　　  0 0 2 　　　　　	local:　　  0 2 2 

global:　　0 0 2　　　　　 　global:　　0 2 2

第三天两次交易：　　　　　　第三天一次交易：

local:　　  0 2 2 　　　　　	local:　　  0 1 2 

global:　　0 2 2　　　　 　	global:　　0 2 2

第四天两次交易：　　　　　　第四天一次交易：

local:　　  0 1 9 　　　　　	local:　　  0 8 9 

global:　　0 2 9　　　　　 　global:　　0 8 9



#### 复杂度

时间：` O(n * k)`，对于天数需要一次扫描，而每次要对交易次数进行递推式求解，如果是最多进行两次交易，那么复杂度还是 ```O (n)```

空间：` O(k)`：空间上只需要维护当天数据皆可以，所以是O(k)，当k=2，则是O(1)



#### 代码

##### Java

```java

```



##### Python

```python

```



