

# 220. Contains Duplicate III

### 题目

链接：https://leetcode.com/problems/contains-duplicate-iii/description/



### 思路 - 滑动窗口+桶排序

#### 步骤

- 首先划分桶，我们想想与一个数差距不超过t，那么也就是说差距可以是0,1,...,t
- 我们将nums[i] // (t+1)相同的数都放到一个桶里，这个桶里的数字之间差距一定不超过t
- 相邻的桶里也有可能有差距不超过t的数字，所以我们还要check一下桶 nums[i] // (t + 1) - 1和桶 nums[i] // (t+1) - 1
- 实际编程时每个桶用int存而不需要用list存，这是因为每个时刻每个桶里最多只可能有一个数，有两个数的时候已经直接返回True了

Source: https://leetcode.com/problems/contains-duplicate-iii/discuss/61639/JavaPython-one-pass-solution-O(n)-time-O(n)-space-using-buckets



#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Python

```python
class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        if t < 0:
            return False
        n = len(nums)
        d = {}
        w = t + 1
        for i in range(0, n):
            m = nums[i] // w
            if m in d:
                return True
            if m - 1 in d and abs(nums[i] - d[m - 1]) < w:
                return True
            if m + 1 in d and abs(nums[i] - d[m + 1]) < w:
                return True
            d[m] = nums[i]
            if i >= k:
                del d[nums[i - k] // w]
        return False
```

