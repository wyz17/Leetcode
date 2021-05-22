

# 658. Find K Closest Elements

### 题目

链接：https://leetcode.com/problems/find-k-closest-elements/



### 思路

#### 步骤

- 二分查找思路
- 比较思路：m 与 x 的距离 与 m + k 与 x 的距离



#### 复杂度

时间： `O(logn)`

空间：` O(n)`

#### 代码

##### Java

```java
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<Integer>();
        int left = 0, right = arr.length - k - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        
        for (int i = 0; i < k; i++) {
            res.add(arr[left + i]);
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left, right = 0, len(arr) - k - 1
        while left <= right:
            mid = (left + right) // 2
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid - 1
        return arr[left : left + k]
```