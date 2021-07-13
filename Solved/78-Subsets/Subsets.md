

# 78. Subsets

### 题目

链接：https://leetcode.com/problems/subsets/



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
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(res, new ArrayList(), nums, 0);
        return res;
    }
    
    private void backtracking(List<List<Integer>> res, List<Integer> tmpList, int[] nums, int start) {
        res.add(new ArrayList<Integer>(tmpList));
        for(int i = start; i < nums.length; i++) {
            if(tmpList.contains(nums[i])) continue;
            tmpList.add(nums[i]);
            backtracking(res, tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
```



##### Python

```python
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.backtracking(res, [], nums)
        return res
    
    def backtracking(self, res, tmpList, nums):
        res.append(tmpList[:])
        for i in range(0, len(nums)):
            self.backtracking(res, tmpList + [nums[i]], nums[i + 1:])
```



### 思路2

https://leetcode.com/problems/subsets/discuss/?currentPage=1&orderBy=most_votes&query=

有空来整理