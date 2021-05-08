

# 55. Jump Game II

### 题目

链接：https://leetcode.com/problems/jump-game-ii/



### 思路 - Greedy 

#### 步骤

- 变量 jumps，表示返回的跳数
- 变量far，表示当前可到达的最远距离
- 变量end，表示当前jump可到达的最远距离
- 视频解析：https://www.youtube.com/watch?v=vBdo7wtwlXs
- 注意遍历数组的长度是length - 1，因为最后一位不用去判断

| Value | 2    | 3    | 1    | 1    | 4    |
| ----- | ---- | ---- | ---- | ---- | ---- |
| index | 0    | 1    | 2    | 3    | 4    |
| far   | 2    | 4    | 4    | 4    | 8    |
| end   | 0    | 2    | 2    | 4    | 4    |
| jump  | 0    | 1    | 1    | 2    | 2    |



#### 复杂度

时间：` O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int far = 0;
        int end = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            far = Math.max(i + nums[i], far);
            if( i == end) {
                jumps++;
                end = far;
            }
            if (end >= nums.length - 1) break;
        }
        return jumps;

    }
}
```



##### Python

```python
class Solution:
    def jump(self, nums: List[int]) -> int:
        jumps, far, end = 0, 0, 0
        for i in range(0, len(nums) - 1):
            far = max(nums[i] + i, far)
            if end == i:
                jumps += 1
                end = far
            if end >= len(nums) - 1:
                break;
        return jumps
```



