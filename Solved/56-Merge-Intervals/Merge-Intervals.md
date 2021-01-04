

# 56. Merge Intervals

### 题目

链接：https://leetcode.com/problems/merge-intervals/



### 思路

#### 步骤

- 根据num[0]，num[1]将二维数组排序
- 遍历排序后的数组，判断后面的一个数组是否可合并：不可合并就添加到res，可合并就修改到



#### 复杂度

时间：` O(NlogN)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals) {
            if(merged.isEmpty() || merged.getLast()[1] < interval[0])
                merged.add(interval);
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);  
    }
}
```



##### Python

```java
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda x: x[0])
        merged = []
        for interval in intervals:
            if not merged or merged[-1][1] < interval[0]:
                merged.append(interval)
            else:
                merged[-1][1] = max(merged[-1][1], interval[1])
        return merged
```



### No sorting solution

https://leetcode.com/problems/merge-intervals/discuss/21452/Share-my-interval-tree-solution-no-sorting

有空补充！