

# 40. Combination Sum II

### 题目

链接：https://leetcode.com/problems/combination-sum-ii/



### 思路

#### 步骤

- 递归遍历就好
- 指路lc大佬的template模板



#### 复杂度

时间：` O(1)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1); 
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
```



##### Python

```python
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        self.backtracking(sorted(candidates), [], res, 0, target)
        return res
    
    def backtracking(self, candidates, tmpList, res, start, remain):
        if remain < 0:
            return
        if remain == 0:
            res.append(tmpList)
        else:
            for i in range(start, len(candidates)):
                if(i > start and candidates[i] == candidates[i - 1]):
                    continue
                self.backtracking(candidates, tmpList + [candidates[i]], res, i + 1, remain - candidates[i])
```


