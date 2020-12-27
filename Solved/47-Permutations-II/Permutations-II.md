

# 46. Permutations II

### 题目

链接：https://leetcode.com/problems/permutations-ii/



### 思路

#### 步骤

- 递归遍历就好
- 指路lc大佬的template模板



#### 复杂度

可以参考这个link：https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071

时间：` O(？)`

空间：` O(？)`



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }
    
    public void backtracking(int[] nums, List<Integer> tempList, List<List<Integer>> res, boolean[] used) {
        if(tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                tempList.add(nums[i]);
                used[i] = true;
                backtracking(nums, tempList, res, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        } 
    }
}
```



去重那段代码的理解：

回溯过程类比为树节点的创建过程，每次选择一个元素就是在当前回溯层创建了一个节点。

假如数组是[1, 1, 2]，那么第一轮回溯的时候我们会选第一个1，然后进入第二轮回溯和第三轮回溯，得到了[1 , 1, 2]和[1, 2, 1]。现在，我们已经涵盖了数字1排在第一位的所有情况。那么第一轮回溯接下来要处理的元素就是第二个1，如果我们将这个1放在第一位肯定就包含重复情况了。这行代码处理的就是这种情况，之所以跟前一个元素做比较是因为数组已经是排序过的，如果有重复元素那一定是当前元素的前一个元素。如果数组没有排序的话代码就应该是这样：

```python
for(int j = 0; j < i; j++)
    if( nums[j] == nums[i] && !used[j] )
        continue;
```



##### Python

```python
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        self.dfs(nums, [], res)
        return res
        
    def dfs(self, nums, tempList, res):
        if not nums:
            res.append(tempList)
        
        for i, num in enumerate(nums):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            self.dfs(nums[:i] + nums[i+1:], tempList + [nums[i]], res)
```
