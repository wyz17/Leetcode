

# 169. Majority Element

### 题目

链接：https://leetcode.com/problems/majority-element/



### 思路1 - HashMap 

#### 步骤

- 傻瓜解法



#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if(map.get(nums[i]) > nums.length / 2) return nums[i];
        }
        return 0;
    }
}
```



##### Python

```python
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        map = {}
        for i in nums:
            map[i] = map.get(i, 0) + 1
            if map[i] > len(nums) / 2:
                return i
        return -1
```



### 思路2 - Boyer-Moore Voting Algorithm ✨

#### 步骤

- 这种投票法先将第一个数字假设为过半数，然后把计数器设为1，比较下一个数和此数是否相等，若相等则计数器加一，反之减一
- 然后看此时计数器的值，若为零，则将下一个值设为候选过半数。以此类推直到遍历完整个数组，当前候选过半数即为该数组的过半数。
- 一定会有一个出现超过半数的数字存在，那么如果计数器减到0，说明目前不是候选者数字的个数已经跟候选者的出现个数相同了，那么这个候选者已经很 weak，不一定能出现超过半数，此时选择更换当前的候选者



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) res = nums[i];
            count += (nums[i] == res) ? 1 : -1;
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        counter = 0
        res = None
        for num in nums:
            if counter == 0:
                res = num
            counter += 1 if (num == res) else -1            
        return res
```

