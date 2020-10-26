# 18. 4Sum

### 题目

链接：https://leetcode.com/problems/4sum/



### 思路 - Two Pointer

#### 步骤

- 和 [3Sum](../15-3Sum/3Sum.md) 一样的方法



#### 复杂度

时间：` O(n^3)`

空间：` O(n)`



#### 代码

##### Java

``` python
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int sum = 0;
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j-1])
                    continue;
                l = j + 1;
                r = nums.length - 1;
                while(l < r){
                    sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l + 1]) l++;
                        while(l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                    if(sum < target) l++;
                    if(sum > target) r--;
                }
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        if len(nums) < 3:
            return []
        nums.sort()
        res = []
        for i in range(0, len(nums) - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(i + 1, len(nums) - 2):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                l = j + 1
                r = len(nums) - 1
                while l < r:
                    sum4 = nums[i] + nums[j] + nums[l] + nums[r]
                    if sum4 < target:
                        l = l + 1
                    if sum4 > target:
                        r = r - 1
                    if sum4 == target:
                        res.append([nums[i], nums[j], nums[l], nums[r]])
                        while l < r and nums[l] == nums[l + 1]:
                            l = l + 1
                        while l < r and nums[r] == nums[r - 1]:
                            r = r - 1
                        l = l + 1
                        r = r - 1
        return res
```



## Java Tips

### 一行新建list的方法

- **Arrays.asList()**

- ```java
  res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
  ```



## Python 知识点

- python和java对应逻辑运算符
  - && ： and
  - || ：or
  - ！：not