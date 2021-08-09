# 875. Koko Eating Bananas

### 题目

链接：https://leetcode.com/problems/peak-index-in-a-mountain-array/



### 思路

#### 步骤

- 二分查找思路
- 指针移动条件：判断当前为mid的值的时候，koko是否能够全部吃完





#### 复杂度

时间： `O(mlogn)`

空间：` O(1)`

#### 代码

##### Java

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isPossible(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public boolean isPossible(int [] piles, int k, int h) {
        int time = 0;
        for(int p: piles) {
            time += (p - 1) / k + 1;
        }
        return time <= h;
    }
}
```



##### Python

```python
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, 1000000000
        while left <= right:
            mid = (left + right) // 2
            if self.isPossible(piles, h, mid):
                right = mid - 1
            else:
                left = mid + 1
        return left
    
    def isPossible(self, piles, h, k):
        time = 0
        for p in piles:
            time += (p - 1) // k + 1
        return time <= h
```

