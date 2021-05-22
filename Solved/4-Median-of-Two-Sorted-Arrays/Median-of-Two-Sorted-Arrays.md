# 4. Median of Two Sorted Arrays

### 题目

链接：https://leetcode.com/problems/median-of-two-sorted-arrays/



### 思路

#### 步骤

- 二分查找思路

- 寻找分割线满足的条件：分割线左边所有元素 <= 红线右边的所有元素数值（分割线左边最大的数要小于等于分割线右边最小的数） 

  - nums1[mid1 - 1] <= nums2[mid2] && nums2[mid2 - 1] <= nums1[mid1]
  - 分割线在第1个数组右边的第1个元素的下标 mid1 = 分割线在第1个数组左边的元素个数
  - 分割线在第2个数组右边的第1个元素的下标 mid2 = 分割线在第2的数组左边的元素个数
  - mid1 + mid2 = (m+n+1) / 2
  - totalLeft：两个数组合并后，总共在左边的个数

- 寻找到分割线之后，判断上述条件是否成立；如果不成立，则左边界-- 或者 右边界++ 缩小范围

- corner cases

  - 当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了，相当于一个空数组了，那么实际上就变成了在另一个数组中找数字，直接就可以找出来了

  - 还有就是如果 K=1 的话，只要比较 nums1 和 nums2 的起始位置i和j上的数字就可以了。





#### 复杂度

时间： `O(logn)`

空间：` O(n)`

#### 代码

##### Java

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        
        // left elements in the left should satisfy m + (n - m + 1) / 2
        int totalLeft = (m + n + 1) / 2;
        
        //ensure nums1.length < nums2.length
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        
        //corner case, empty array
        if (n == 0) return (nums1[(m - 1) / 2] + nums1[m / 2]) / 2.0;
        
        int left = 0, right = m;
        // nums1[mid1 - 1] <= nums2[mid2] && nums2[mid2 - 1] <= nums1[mid1]
        
        while(left < right) {
            int mid1 = left + (right - left + 1) / 2;
            int mid2 = totalLeft - mid1;
            if(nums1[mid1 - 1] > nums2[mid2]) {
                //next search in [left, i - 1]
                right = mid1 - 1;
            } else {
                //next search in [i, right]
                left = mid1;
            }
        }
        
        int mid1 = left;
        int mid2 = totalLeft - mid1;
        int nums1LeftMax = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
        int nums1RightMin = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
        int nums2LeftMax = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
        int nums2RightMin = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];
        
        if((m + n) % 2 == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
        }
    }
}
```



##### Python

```python
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m, n = len(nums1), len(nums2)
        totalLeft = (m + n + 1) // 2
        if m > n:
            return self.findMedianSortedArrays(nums2, nums1)
        if n == 0:
            return (nums1[(m - 1) // 2] + nums1[m // 2]) / 2.0;
        
        left, right = 0, m
        while left < right:
            mid1 = (left + right + 1) // 2
            mid2 = totalLeft - mid1
            if nums1[mid1 - 1] > nums2[mid2]:
                right = mid1 - 1
            else:
                left = mid1
        mid1 = left
        mid2 = totalLeft - left
        
        nums1LeftMax = float("-inf")  if mid1 == 0 else nums1[mid1 - 1]
        nums1RightMin = float("inf") if mid1 == m else nums1[mid1]
        nums2LeftMax = float("-inf") if mid2 == 0 else nums2[mid2 - 1]
        nums2RightMin = float("inf") if mid2 == n else nums2[mid2]
        
        if (m + n) % 2 == 1:
            return max(nums1LeftMax, nums2LeftMax)
        else:
            return (max(nums1LeftMax, nums2LeftMax) + min(nums1RightMin, nums2RightMin)) / 2
```