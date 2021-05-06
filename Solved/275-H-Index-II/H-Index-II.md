

# 275. H-Index-II

### 题目

链接：https://leetcode.com/problems/h-index/description/



### 思路

#### 步骤

- 循环遍历判断是否为h



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            // 得到当前的H指数
            int currH = Math.min(citations[i], citations.length - i);
            if(currH > h){
                h = currH;
            }
        }
        return h;
    }
}
```



##### Python

```python
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        h = 0
        for i in range(len(citations) - 1, -1, -1):
            curH = min(citations[i], len(citations) - i)
            if curH > h:
                h = curH
        return h
```


