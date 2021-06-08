# 287. Find the Duplicate Number

### 题目

链接：https://leetcode.com/problems/find-the-duplicate-number/



### 思路1 - Two-pointers

#### 步骤

- ![](https://leetcode.com/problems/find-the-duplicate-number/Figures/287/simple_cycle.png)
- 步骤如图



#### 复杂度

时间： `O(n)`

空间：` O(n)`

#### 代码

##### Java

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]]; 
        }
        //slow and fast meet
        
        int res = nums[0];
        while(res != slow) {
            res = nums[res];
            slow = nums[slow];
        }
        //find res
        return slow;
    }
}
```



##### Python

```python
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow, fast = nums[0], nums[0]
        slow = nums[slow]
        fast = nums[nums[fast]]
        while slow != fast:
            slow = nums[slow]
            fast = nums[nums[fast]]
        res = nums[0]
        while res != slow:
            slow = nums[slow]
            res = nums[res]
        return res
```



### 思路2 - Sorting

#### 步骤

- 排序，求值



#### 复杂度

时间： `O(nlgn)`

空间：` O(n)`

#### 代码

##### Java

```java
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
```



##### Python

```python
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        nums.sort()
        for i in range(0, len(nums) - 1):
            if nums[i] == nums[i + 1]:
                return nums[i]
        return nums[len(nums) - 1]
```





### 思路3 - Set

#### 步骤

- Set里面不允许存在重复值
- 遍历数组，存入值的时候就可以判断是否存在重复值，直接返回就好



#### 复杂度

时间： `O(n)`

空间：` O(n)`

#### 代码

##### Java

```java
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for(int num: nums) {
            if(seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1;
    }
}
```



##### Python

```python
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        seen = set()
        for num in nums:
            if num in seen:
                return num
            seen.add(num)
```

