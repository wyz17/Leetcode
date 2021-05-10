

# 287. Find the Duplicate Number 

### 题目

链接：https://leetcode.com/problems/find-the-duplicate-number/description/



### 思路1 - Sorting

#### 步骤

- 排序
- 判断nums[i]和nums[i + 1]的值是否一样



#### 复杂度

时间： `O(nlogn)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) return nums[i];
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
        for i in range(0, len(nums)):
            if nums[i] == nums[i + 1]:
                return nums[i]
        return nums[len(nums) - 1]
```





### 思路2 -  HashMap

#### 步骤

- 用map存储数



#### 复杂度

时间： `O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) return nums[i];
            else map.put(nums[i], 1);
        }
        return -1;
    }
}
```



##### Python

```python
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        lst = {}
        for num in nums:
            if num in lst:
                return num
            lst[num] = 0
        return -1
```



### 思路3 -  Cycle Detection ✨

#### 步骤

- 利用两个变量：slow和fast
- ![pic](https://leetcode.com/problems/find-the-duplicate-number/Figures/287/first_intersection.png)
- 先通过走两步的fast和走一步的slow求出相遇的地点
- 在设置另一个指针从起点出发，求出最后相遇结果，这就是重复数



#### 复杂度

时间： `O(n)`

空间：` O(1)`



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

