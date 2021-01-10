

# 77. Combinations

### 题目

链接：https://leetcode.com/problems/combinations/



### 思路

#### 步骤

- 递归遍历就好
- 指路lc大佬的template模板



#### 复杂度

时间：` O(?)`

空间：` O(?)`



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(res, new ArrayList<Integer>(), n, 1, k);
        return res;
    }
    
    private void backtracking(List<List<Integer>> list, List<Integer> tmpList, int n, int start, int k) {
        if(k == 0) {
            list.add(new ArrayList<Integer>(tmpList));
            return;
        } else {
            for(int i = start; i <= n - k + 1; i++) {
                tmpList.add(i);
                backtracking(list, tmpList, n, i + 1, k - 1);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
```



##### Python

```python
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
       # in mathematics, C(4, 2) = C(3, 1) + C(3, 2)
#we are taking one less element in combine(n - 1, k - 1), so we add n to it.
        if n == k: return [[i for i in range(1, n + 1)]]
        elif n < k or k <= 0: return [[]]
        exclude_n = self.combine(n - 1, k)
        combs_incl = self.combine(n - 1, k - 1)
        include_n = [lst + [n] for lst in combs_incl]
        return exclude_n + include_n
    
    def combine2(self, n: int, k: int) -> List[List[int]]:
        res = []
        self.backtracking(res, list(range(1, n+1)), [], k)
        return res
    
    def backtracking(self, res, nums, tmpList, k):
        if len(tmpList) == k:
            res.append(tmpList)
            return
        else:
            for i in range(len(nums)):
                self.backtracking(res, nums[i + 1:], tmpList + [nums[i]], k)
        
```


