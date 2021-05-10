

# 334. Increasing Triplet Subsequence

### 题目

链接：https://leetcode.com/problems/increasing-triplet-subsequence/description/



### 思路

#### 步骤

- 使用两个指针first和second，初始化为整型最大值
- 遍历数组，如果first大于等于当前数字，则将当前数字赋给first
- 如果first小于当前数字且second大于等于当前数字，那么将当前数字赋给second，一旦second被更新了，说明一定会有一个数小于second，那么我们就成功的组成了一个长度为2的递增子序列，所以我们一旦遍历到比second还大的数，我们直接返回ture
- 如果我们遇到比first小的数，还是要更新first，有可能的话也要更新second为更小的值，毕竟second的值越小，能组成长度为3的递增序列的可能性越大



#### 复杂度

时间： `O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= first) first = nums[i];
            else if(nums[i] <= second) second = nums[i];
            else return true;
        }
        return false;
    }
}
```



##### Python

```python
class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        first = float("inf")
        second = float("inf")
        if len(nums) < 3:
            return False
        for num in nums:
            if num <= first:
                first = num
            elif num <= second:
                second = num
            else:
                return True
        return False
```

