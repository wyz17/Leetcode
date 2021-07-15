# 491. Increasing Subsequences

### 题目

- 链接：https://leetcode.com/problems/increasing-subsequences/
- 题意：求出给出序列中的递增子序列



### 思路 - DFS

#### 步骤

- DFS递归一下
- DFS好慢啊！
- Java中用set可以速度更快



#### 复杂度

时间： `O(N!)`

空间：` O(N^2)`



#### 代码

##### Java

```java
// 使用ArrayList + constains方法，在有15个数的时候会超时；这里使用Set改进
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res= new HashSet<List<Integer>>();
        dfs(res, new ArrayList<>(), nums, 0);
        List result = new ArrayList(res);
        return result;
    }
    
    private void dfs(Set<List<Integer>> res, List<Integer> path, int[] nums, int start) {
        if(path.size() >= 2) {
            res.add(new ArrayList(path));
        }
        for(int i = start; i < nums.length; i++) {
            if(path.size() > 0 && path.get(path.size() - 1) > nums[i]) continue;
            path.add(nums[i]);
            dfs(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
```



##### Python

```python
class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.dfs(res, [], nums)
        return res
    
    def dfs(self, res, path, nums):
        if len(path) >= 2 and path not in res:
            res.append(path)
        for i in range(len(nums)):
            if len(path) > 0 and path[-1] > nums[i]: continue
            self.dfs(res, path + [nums[i]], nums[i + 1:])
```

