

# 39. Combination Sum

### 题目

链接：https://leetcode.com/problems/combination-sum/



### 思路

#### 步骤

- 递归遍历就好
- 指路lc大佬的template模板



#### 复杂度

时间：` O(n!)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int remain, int start) {
        if(remain < 0) return;
        else if(remain == 0) res.add(new ArrayList<>(tmp));
        else {
            for(int i = start; i < nums.length; i++) {
                if (remain < nums[i]) return;
                if(i > start && nums[i] == nums[i - 1]) continue;  // skip continue
                tmp.add(nums[i]);
                dfs(res, tmp, nums, remain - nums[i], i + 1); // i + 1 to avoid duplicate
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
```



##### Python

```python
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        self.dfs(res, [], candidates, target)
        return res
    
    def dfs(self, res, tmp, nums, remain):
        if remain < 0:
            return
        elif remain == 0:
            res.append(tmp)
        else:
            for i in range(len(nums)):
                # 剪枝
                if remain < nums[i]: continue
                # 这里的nums[i:] 就等价于使用了start 
                self.dfs(res, tmp + [nums[i]], nums[i:], remain - nums[i])
```

