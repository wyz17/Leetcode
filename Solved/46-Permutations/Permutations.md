

# 46. Permutations

### 题目

链接：https://leetcode.com/problems/permutations/



### 思路 - DFS

#### 步骤

- 递归遍历就好



#### 复杂度

可以参考这个link：https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071

时间：` O(N!)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums) {
        if(tmp.size() == nums.length) res.add(new ArrayList<>(tmp));
        else {
            for(int i = 0; i < nums.length; i++) {
                if(tmp.contains(nums[i])) continue;
                tmp.add(nums[i]);
                dfs(res, tmp, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
```



##### Python

```python
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.dfs(res, [], nums)
        return res
    
    def dfs(self, res, tmp, nums):
        if len(nums) == len(tmp):
            res.append(tmp)
        else:
            for i in range(len(nums)):
                if nums[i] in tmp: continue
                self.dfs(res, tmp + [nums[i]], nums)
 


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.backtracking(nums, [], res)
        return res
        
    def backtracking(self, nums, tempList, res):
        if len(tempList) == len(nums):
            res.append(tempList[:])
            print(res)
        else:
            for i in nums:
                if i in tempList:
                    continue
                tempList.append(i)
                self.backtracking(nums, tempList, res)
                tempList.pop()
```



```python
res.append(tempList[:])
```

**这个语句要高亮！！！！**

作用是避免python的浅拷贝，如果不加的话就会一直添加一样的list进res
