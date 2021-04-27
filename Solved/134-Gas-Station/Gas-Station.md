

# 134. Gas Station

### 题目

链接：https://leetcode.com/problems/gas-station/



### 思路 - Greedy

#### 步骤

- left：在每个位置剩余的油量
- start：如果存在循环，返回的index
- lack：离循环缺少的值
- 累加在每个位置的 left += gas[i] - cost[i]
- 如果left一直大于0，就可以一直走下取
- 如果left小于0，那么就从下一个位置重新开始计数，并且将之前欠下的多少记录下来
- 如果最终遍历完数组后left可以弥补lack，那么就可以到达，并返回最后一次开始的位置start
- 否则就返回-1



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int left = 0;
        int count = 0;
        int lack = 0;
        for(int i = 0; i < gas.length; i++) {
            left += gas[i] - cost[i];
            if(left < 0) {
                count = i + 1;
                lack += left;
                left = 0;
            }
        }
        return left + lack >= 0 ? count : -1;
    }
}
```



##### Python

```python
class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        start = left = lack = 0
        for i in range(0, len(gas)):
            left += gas[i] - cost[i]
            if left < 0:
                start = i + 1
                lack += left
                left = 0
        return start if lack + left >= 0 else -1
```


