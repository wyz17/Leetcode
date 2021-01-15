

# 80. Remove Duplicates from Sorted Array II

### 题目

链接：https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/



### 思路

#### 步骤

- 关键是判断条件： n > nums[i - 2]
- 因为给出的是排序好了的数组，所以如果nums[i - 2]大于n的话就说明一定是不一样的数
- 如果是不一样的数，直接讲数往前挪一位；如果是一样的数，直接覆盖
- 直接对着input思考一下，妙啊



#### 复杂度

时间：` O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
```



##### Python

```python
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        for num in nums:
            if i < 2 or num > nums[i - 2]:
                nums[i] = num
                i += 1
        return i
```


