

# 46. Permutations

### 题目

链接：https://leetcode.com/problems/permutations/



### 思路1 - Backtracking

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
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, new ArrayList<>(), res);
        return res;
    }
    
    public void backtracking(int[] nums, List<Integer> tempList, List<List<Integer>> res) {
        if(tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtracking(nums, tempList, res);
                tempList.remove(tempList.size() - 1);
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



### 思路2 - DFS

#### 步骤

- dfs遍历就好



#### 复杂度

时间：` O(？)`

空间：` O(？)`



#### 代码

##### Python

```python
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.dfs(nums, [], res)
        return res
        
    def dfs(self, nums, tempList, res):
        if not nums:
            res.append(tempList[:])
        else:
            for i, num in enumerate(nums):
                self.dfs(nums[:i] + nums[i+1:], tempList + [num], res)
```

