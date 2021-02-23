

# 108. Pascal's Triangle

### 题目

链接：https://leetcode.com/problems/pascals-triangle/



### 思路 - Dynamic Programming

#### 步骤

- 每一行的首个和结尾一个数字都是1，从第三行开始，中间的每个数字都是上一行的左右两个数字之和



#### 复杂度

时间：` O(numRows^2)`

空间：` O(numRows^2)`



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for(int j = 1; j < i; j++) {
                List<Integer> prevRow = res.get(i - 1); //当前行的上一行
                int tmp = prevRow.get(j-1) + prevRow.get(j);
                row.add(tmp);
            }
            if(i != 0) {
                row.add(1);
            }
            res.add(row);
        }
        return res;
    }
}re
```



##### Python

```python
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        for i in range(numRows):
            res.append([1])
            for j in range(1, i + 1):
                if i == j:
                    res[i].append(1)
                else:
                    res[i].append(res[i-1][j] + res[i-1][j-1])
        return res
```



