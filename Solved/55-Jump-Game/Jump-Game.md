

# 55. Jump Game

### 题目

链接：https://leetcode.com/problems/jump-game/



### 思路1 - BackTracking X

#### 步骤

- 递归判断是否return true



#### 复杂度

时间：` O(2^N)`

空间：` O(n)`，递归需要调用额外的栈内存



这个方法超时...pass



#### 代码

##### Java

```java
class Solution {
    public boolean canJump(int[] nums) {
        return canJumpNext(nums, 0);
    }
    
    public boolean canJumpNext(int[] nums, int pos) {
        int len = nums.length;
        if(pos == nums.length - 1)
            return true;
        if(len - 1 - pos <= nums[pos])
            return true;
        int next = Math.min(pos + nums[pos], nums.length - 1);
        for(int i = next; i >= pos + 1; i--) {
            if(canJumpNext(nums, i))
                return true;
        }
        return false;
    }
}
```



### 思路2 - Dynamic Programming

#### 步骤

- 通过dp数组保存每一个index的 true & false



#### 复杂度

时间：` O(N^N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        int len = nums.length - 1;
        dp[len] = true;
        
        for(int i = len - 1; i >= 0; i--) {
            int next = Math.min(i + nums[i], len);
            for(int j = next; j >= i; j--) {
                if(dp[j] == true) {
                    dp[i] = true;
                    break;
                }
                dp[i] = false;
            }
        }
        return dp[0];
    }
}
```

和java一样的思路Python就是死活调不通...果然我就是Python的后妈...无语





### 思路3 - Dynamic Programming  - O(n)

#### 步骤

- 直接更改当前数组num
- 将每一个num[i]更改成最大可达的index

  - 如果第一个数为0（自己的前一个数为0），那就到达不了现在的index，所以将自己也改成0
  - 否则我们可以至少从前跳一步到后一个，存入最大可达的index
  - 最后check从第二个到最后一个的jump index >= 1

#### 复杂度

时间：` O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i - 1] == 0)
                nums[i] = 0;
            else
                nums[i] = Math.max(nums[i - 1] - 1, nums[i]);
        }
        return nums[nums.length - 2] >= 1;
    }
}
```

注意边界⚠️ 循环的len - 1和return的len - 2

##### Python

```python
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 1:
            return True
        
        for i in range(1, len(nums)-1):
            if nums[i-1] == 0:
                nums[i] = 0
            else:
                nums[i] = max(nums[i-1]-1, nums[i])
            
        
        return nums[-2] >= 1
```





### 思路4 - Greedy ✨

#### 步骤

- 维护一个变量 reach，表示最远能到达的位置，初始化为0。
- 遍历数组中每一个数字，如果当前坐标大于 reach 或者 reach 已经抵达最后一个位置则跳出循环，否则就更新 reach 的值为其和 i + nums[i] 中的较大值
  - 其中 i + nums[i] 表示当前位置能到达的最大位置

这个方法太绝啦！！



#### 复杂度

时间：` O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public boolean canJump(int[] nums) {
        int reach = nums[0];
        for(int i = 1; i < nums.length - 1; i++) {
            if(i > reach || reach >= nums.length - 1) break;
            else reach = Math.max(reach, i + nums[i]);
        }
        return reach >= nums.length - 1;
    }
}
```



##### Python

```python
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        reach = 0
        for i, num in enumerate(nums):
            if i > reach or reach >= len(nums) - 1: break
            else: reach = max(reach, i + num)
        return reach >= len(nums) - 1
```



###### StefanPochmann：One-liner version:

```python
def canJump(self, nums):
    return reduce(lambda m, (i, n): max(m, i+n) * (i <= m), enumerate(nums, 1), 1) > 0
```

