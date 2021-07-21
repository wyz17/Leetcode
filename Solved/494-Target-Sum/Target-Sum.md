# 494. Target Sum

### 题目

- 链接：https://leetcode.com/problems/target-sum/
- 题意：求出数组中加 / 减最终和等于target的组合个数



### 思路1 - DFS

#### 步骤

- DFS递归一下
- 递归元素：数组nums；给出的target；idx用来记录当前数组的index；sum用来记录当前路径和
- 递归结束条件：res++
  - index等于数组的长度
  - sum等于target
- 注意点
  - 判断递归结束条件的时候不要同时判断上面的两个条件，要先判断idx == nums.length，进入这个判断之后再去判断sum，否则直接return。不然的话会继续递归，出现数组越界的情况。



#### 复杂度

时间： `O(N!)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return res;
    }
    
    private void dfs(int[] nums, int target, int idx, int sum) {
        if(idx == nums.length) {
            if(sum == target) res++;
            else return;
        } else {
            dfs(nums, target, idx + 1, sum + nums[idx]);
            dfs(nums, target, idx + 1, sum - nums[idx]); 
        }
    }
}
```



##### Python

```python
# Python version Time Limit Exceeded X
class Solution:
    # python中int是作为值去递归，和list不一样，所以这里递归参数传入res = 0是没有效的
    res = 0
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        self.dfs(nums, target, 0, 0)
        return self.res

    def dfs(self, nums, target, idx, s):
        if idx == len(nums):
            if s == target:
                self.res += 1
        else:
            self.dfs(nums, target, idx + 1, s + nums[idx])
            self.dfs(nums, target, idx + 1, s - nums[idx])
```

