# 303. Range Sum Query - Immutable

### 题目

链接：https://leetcode.com/problems/range-sum-query-immutable/



### 思路1 - 暴力法

#### 步骤

- 每次求rangeSum都计算一遍和



#### 复杂度

时间： `O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class NumArray {
    int[] arr;
    
    public NumArray(int[] nums) {
        this.arr = nums;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
```



##### Python

```python
class NumArray:
    
    def __init__(self, nums: List[int]):
        self.arr = nums
        
    def sumRange(self, left: int, right: int) -> int:
        sum = 0
        for i in range(left, right + 1):
            sum += self.arr[i]
        return sum
```



### 思路2 - 时间优化✨

#### 步骤

- 在构造函数NumArray时，输入了数组nums，同时用一个sum数组保存第一个元素到当前元素的累计和。这样要求对应下表的rangeSum的时候，只需直接返回 sums[j] - sum[i - 1]即可
  

#### 复杂度

时间： `O(1)`

空间：` O(n)`



#### 代码

##### Java

```java
class NumArray {
    int[] arr;
    
    public NumArray(int[] nums) {
        arr = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return arr[right + 1] - arr[left];
    }
}
```



##### Python

```python
class NumArray:
    
    def __init__(self, nums: List[int]):
        self.arr = [0] * (len(nums) + 1)
        for i in range(0, len(nums)):
            self.arr[i + 1] = self.arr[i] + nums[i] 
        

    def sumRange(self, left: int, right: int) -> int:
        return self.arr[right + 1] - self.arr[left]
```



