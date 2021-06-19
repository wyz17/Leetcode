# 167. Two Sum II - Input array is sorted

### 题目

链接：https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/



### 思路 - Two Pointers

#### 步骤

- 双指针记录左右结果



#### 复杂度

时间： `O(n)`

空间：` O(1)`

#### 代码

##### Java

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left = 0
        right = len(numbers) - 1
        while left < right:
            sum = numbers[left] + numbers[right]
            if sum == target:
                return [left + 1, right + 1]
            elif sum < target:
                left += 1
            else:
                right -= 1
```

