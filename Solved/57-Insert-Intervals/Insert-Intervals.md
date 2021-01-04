

# 57. Insert Intervals

### 题目

链接：https://leetcode.com/problems/insert-interval/



### 思路

#### 步骤

- 判断有两种情况
  - 不重叠：直接将新区间插入到对应的位置即可
  - 重叠：有时候会有多个重叠，需要更新新区间的范围以便包含所有重叠，之后将新区间加入结果 res，最后将后面的区间再加入结果 res 即可
- 具体思路
  - 用一个变量 cur 来遍历区间
  - 如果当前 cur 区间的结束位置小于要插入的区间的起始位置的话，说明没有重叠，则将 cur 区间加入结果 res 中，然后 cur 自增1，直到有 cur 越界或有重叠 while 循环退出
  - 再用一个 while 循环处理所有重叠的区间，每次用取两个区间起始位置的较小值，和结束位置的较大值来更新要插入的区间，然后 cur 自增1。直到 cur 越界或者没有重叠时 while 循环退出
  - 之后将更新好的新区间加入结果 res，然后将 cur 之后的区间再加入结果 res 中即可



#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> res = new LinkedList<>();
        int cur = 0;
        while(cur < intervals.length && intervals[cur][1] < newInterval[0]) {
            res.add(intervals[cur]);
            cur++;
        }
        while(cur < intervals.length && intervals[cur][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[cur][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[cur][1]);
            cur++;
        }
        res.add(newInterval);
        while (cur < intervals.length) {
            res.add(intervals[cur]);
            cur++;
        }
        return res.toArray(new int[res.size()][]);  
    }
}
```



##### Python

```java
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        cur = 0
        while(cur < len(intervals) and intervals[cur][1] < newInterval[0]):
            res.append(intervals[cur])
            cur = cur + 1
        while(cur < len(intervals) and intervals[cur][0] <= newInterval[1]):
            newInterval[0] = min(newInterval[0], intervals[cur][0])
            newInterval[1] = max(newInterval[1], intervals[cur][1])
            cur = cur + 1
        res.append(newInterval)
        while(cur < len(intervals)):
            res.append(intervals[cur])
            cur = cur + 1
        return res
```


