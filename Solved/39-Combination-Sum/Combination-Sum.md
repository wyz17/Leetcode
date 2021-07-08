

# 39. Combination Sum

### 题目

链接：https://leetcode.com/problems/combination-sum/



### 思路

#### 步骤

- 递归遍历就好
- 指路lc大佬的template模板



#### 复杂度

时间：` O(N^target)`

空间：` O(target)`



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
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
                self.dfs(res, tmp + [nums[i]], nums[i:], remain - nums[i])
```

