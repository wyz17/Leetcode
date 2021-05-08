

# 229. Majority Element II

### 题目

链接：https://leetcode.com/problems/majority-element-ii/



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
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if((map.get(nums[i]) > nums.length / 3) && !res.contains(nums[i])) res.add(nums[i]);
        }
        return res;
   }
}
```



##### Python

```python
class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        map = {}
        res = []
        for i in nums:
            map[i] = map.get(i, 0) + 1
            if map[i] > len(nums) / 3 and i not in res:
                res.append(i)
        return res
```



### 思路2 - Boyer-Moore Voting Algorithm ✨

#### 步骤

- ?



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java

```



##### Python

```python

```

