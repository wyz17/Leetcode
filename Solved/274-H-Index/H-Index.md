

# 274. H-Index

### 题目

链接：https://leetcode.com/problems/h-index/description/



### 思路1 - Sorting 

#### 步骤

- 先将数组排序
- 循环遍历判断是否为h



#### 复杂度

时间：` O(nlogn)`

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



### 思路2 - 

#### 步骤

- 额外使用一个大小为N+1的数组stats
- `stats[i]`表示有多少文章被引用了 i 次，这里如果一篇文章引用大于N次，我们就将其当为N次，因为H指数不会超过文章的总数
- 遍历citations，构建stats数组
- 统计完后，我们从N向1开始遍历这个统计数组。如果遍历到某一个引用次数时，大于或等于该引用次数的文章数量，大于引用次数本身时，我们可以认为这是H指数。
- 之所以不用再向下找，因为我们要取最大的H指数。
- 那如何求大于或等于某个引用次数的文章数量呢？我们可以用一个变量，从高引用次的文章数累加下来。
- 因为我们知道，如果有x篇文章的引用大于等于3次，那引用大于等于2次的文章数量一定是x加上引用次数等于2次的文章数量。



#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public int hIndex(int[] citations) {
        int[] stats = new int[citations.length + 1];
        int n = citations.length;
        for(int i = 0; i < n; i++) {
           stats[citations[i] <= n ? citations[i] : n] += 1;
        }
        int h = 0;
        for(int i = n; i > 0; i--) {
            // 引用大于等于i次的文章数量，等于引用大于等于i+1次的文章数量，加上引用等于i次的文章数量 
            h += stats[i];
            // 如果引用大于等于i次的文章数量，大于引用次数i，说明是H指数
            if(h >= i){
                return i;
            }
        }
        return -1;
    }
}
```



##### Python

```python
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        stats = [0] * (n + 1)
        for i in range(0, n):
            stats[citations[i] if citations[i] <= n else n] += 1;
        h = 0
        for i in range(n, -1, -1):
            h += stats[i]
            if h >= i:
                return i
        return 0
```

