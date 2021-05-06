

# 217. Contains Duplicate

### 题目

链接：https://leetcode.com/problems/contains-duplicate/description/



### 思路1 - Sorting 

#### 步骤

- 先将数组排序
- 傻瓜解法



#### 复杂度

时间：` O(nlogn)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}
```



##### Python

```python
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        nums.sort()
        for i in range(0, len(nums) - 1):
            if nums[i] == nums[i + 1]:
                return True
        return False
```



### 思路2 - HashTable

#### 步骤

- 空间换时间
- 傻瓜解法



#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) return true;
            map.put(nums[i], 1);
        }
        return false;
    }
}
```



##### Python

```python
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        lst = {}
        for i in range(0, len(nums)):
            if nums[i] in lst:
                return True
            lst[nums[i]] = 1
        return False
```



### 思路3 - Set

#### 步骤

- 空间换时间
- 傻瓜解法



#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Python

```python
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
         numsSet =  set(nums)
            if len(nums) == len(numsSet):
                return False
        return True
```

