# 528. Random Pick with Weight

### 题目

- 链接：https://leetcode.com/problems/random-pick-with-weight/
- 题意
  - 这道题给了一个权重数组，让我们根据权重来随机取点，现在的点就不是随机等概率的选取了，而是要根据权重的不同来区别选取
  - 比如题目中例子2，权重为 [1, 3]，表示有两个点，权重分别为1和3，那么就是说一个点的出现概率是四分之一，另一个出现的概率是四分之三



### 思路

#### 步骤

- 使用累加和数组累计 array 的和：w[ ] = { 2, 5, 3, 4 } => wsum[ ] = { 2, 7, 10, 14 }
- 再使用 random 函数 ```random.nextInt(14)+1```，范围是 ```[1,14]```
- 随机出一个数字 x 后，然后再在 累加和数组 中查找第一个大于随机数x的数字，使用二分查找法可以找到第一个大于随机数 x 的数字的坐标，即为所求



#### 复杂度

时间： 初始化`O(n)`，查找一次复杂度为```O(logn)```

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    int[] sum;
    Random random;

    public Solution(int[] w) {
        this.random = new Random();
        for(int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.sum = w;
    }
    
    public int pickIndex() {
        int index = random.nextInt(sum[sum.length - 1]) + 1;
        int left = 0, right = sum.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(sum[mid] == index) {
                return mid;
            } else if(sum[mid] < index) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
```



##### Python

```python
class Solution:

    def __init__(self, w: List[int]):
        self.sum = w
        for i in range(1, len(w)):
            self.sum[i] += self.sum[i - 1]
        

    def pickIndex(self) -> int:
        index = random.randint(1, self.sum[-1])
        left, right = 0, len(self.sum) - 1
        while left <= right:
            mid = (left + right) // 2
            if self.sum[mid] == index:
                return mid
            elif self.sum[mid] > index:
                right = mid - 1
            else:
                left = mid + 1
        return left
```