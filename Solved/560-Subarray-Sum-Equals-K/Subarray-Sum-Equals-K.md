# 560. Subarray Sum Equals K

### 题目

- 链接：https://leetcode.com/problems/subarray-sum-equals-k/
- 题意：求出连续子序列和等于k的子序列数量



### 思路

#### 步骤

- 求子数组和```sum[i, j]```，我们可以划分成 ```sum[i, j] = sum[0, j] - sum[0, i-1]```，所以存在的关系就是```sum[0, j] - sum[0, i-1] = k```
- 遍历循环，用sum代表当前数组中index的累加和
- 用 HashMap 来建立连续子数组之和跟其出现次数之间的映射，循环判断另一边所需要的sum是否存在于map中，如果存在，res++；如果不存在，就将当前的sum存入map中
- 初始化要加入 {0,1} 这对映射，因为当 sum 刚好为k的时候，数组从起始到当前位置的这段子数组的和就是k，满足题意，如果 HashMap 中事先没有存入 m[0] 项的话，这个结果就不会加入 res了



#### 复杂度

时间： ```O(n)```

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        sum = res = 0
        map = {}
        map[0] = 1
        for i in range(0, len(nums)):
            sum += nums[i]
            if sum - k in map:
                res += map[sum - k]
            if sum in map:
                map[sum] += 1
            else:
                map[sum] = 1
        return res
```