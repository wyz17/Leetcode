# 238. Product of Array Except Self

### 题目

- 链接：https://leetcode.com/problems/product-of-array-except-self/
- 题意：给定我们一个数组，返回一个新数组，新数组中对于每一个位置上的数都是其他位置上数的乘积，限定了时间复杂度 O(n)，并且不能用除法。



### 思路

#### 步骤

- 对于某一个数字，如果我们知道其前面所有数字的乘积，同时也知道后面所有的数乘积，那么二者相乘就是我们要的结果
- 所以可以分别创建出这两个数组，分别从数组的两个方向遍历就可以分别创建出乘积累积数组
  - 空间复杂度还可以继续优化
  - before 和 after 的数组可以用两个变量 left 和 right 去替换
  - 在遍历 left 的时候，就将 res 数组赋值为 left
  - 之后遍历 right，res数组再乘 right 就好
- 注意
  - left和right初始值为1
  - res[0] 要赋值为1，否则就是0



#### 复杂度

时间： `O(n)`

空间：` O(n)`

#### 代码

##### Java

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] before = new int[nums.length];
        int[] after = new int[nums.length];
        int[] res = new int[nums.length];
        before[0] = 1;
        after[nums.length - 1] = 1;
        
        for(int i = 0; i < nums.length - 1; i++) {
            before[i + 1] = before[i] * nums[i];
        }
        for(int i = nums.length - 1; i > 0; i--) {
            after[i - 1] = after[i] * nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            res[i] = before[i] * after[i];
        }
        return res;
    }
}

// 空间复杂度优化
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1;
        int right = 1;
        res[0] = 1;
        
        for(int i = 1; i < nums.length; i++) {
            left = left * nums[i - 1];
            res[i] = left;
        }
        for(int i = nums.length - 2; i >= 0; i--) {
            right = right * nums[i + 1];
            res[i] = res[i] * right;
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [1] * len(nums)
        left = right = 1
        
        for i in range(1, len(nums)):
            left = left * nums[i - 1]
            res[i] = left
        
        for j in range(len(nums) - 2, -1, -1):
            right = right * nums[j + 1]
            res[j] = res[j] * right
        return res
```

