

# 219. Contains Duplicate II

### 题目

链接：https://leetcode.com/problems/contains-duplicate-ii/description/



### 思路 - HashMap

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
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
               if(i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
```



##### Python

```python
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        lst = {}
        for i in range(0, len(nums)):
            if nums[i] in lst and i - lst[nums[i]] <= k:
                return True
            lst[nums[i]] = i
        return False
```


