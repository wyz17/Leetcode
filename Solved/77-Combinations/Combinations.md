

# 77. Combinations

### 题目

链接：https://leetcode.com/problems/combinations/



### 思路1 - Backtracking

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



### 思路2 - Math Recursive

核心思路： C(n,k) = C(n-1,k-1) + C(n-1,k)



#### 步骤

- 数学思路：C(4, 2) = C(3, 1) + C(3, 2)
- 所以在针对 combine(n - 1, k - 1)，我们在对应的列表中加入n



#### 复杂度

时间：` O(?)`

空间：` O(?)`



#### 代码

##### Java

```java
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = this.combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(this.combine(n - 1, k));
        return result;
    }
}
```



##### Python

```python
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if n == k: return [[i for i in range(1, n + 1)]]
        elif n < k or k <= 0: return [[]]
        exclude_n = self.combine(n - 1, k)
        combs_incl = self.combine(n - 1, k - 1)
        include_n = [lst + [n] for lst in combs_incl]
        return exclude_n + include_n
```

