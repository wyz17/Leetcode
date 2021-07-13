# 90. Subsets II

### 题目

链接：https://leetcode.com/problems/subsets-ii/



### 思路

#### 步骤

- dfs递归遍历就好



#### 复杂度

时间：` O(2^N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, res, new ArrayList<>(), 0);
        return res;
    }
    
    private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> tmpList, int start) {
        if(!res.contains(tmpList)) {
            res.add(new ArrayList<Integer>(tmpList));
        }
        for(int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            backtracking(nums, res, tmpList, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
```



##### Python

```python
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.backtracking(sorted(nums), res, [])
        return res
    
    def backtracking(self, nums, res, tmpList):
        res.append(tmpList[:])
        for i in range(0, len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            self.backtracking(nums[i + 1:], res, tmpList + [nums[i]])
```



### 思路2

https://leetcode.com/problems/subsets-ii/discuss/30166/Simple-python-solution-without-extra-space

有空来整理啦

