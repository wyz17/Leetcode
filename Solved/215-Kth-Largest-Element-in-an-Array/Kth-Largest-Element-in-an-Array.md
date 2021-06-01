# 215. Kth Largest Element in an Array

### 题目

链接：https://leetcode.com/problems/kth-largest-element-in-an-array/



### 思路1 - Quick Sort

#### 步骤

- 要先找一个中枢点 pivot，然后遍历其他所有的数字
- 题目要求从大往小排，所以将大于pivot的数字放到左半边，把小于pivot的放在右半边，这样就能确定pivot是整个数组中第几大的数字
- 再求出pivot的位置，如果正好是 k-1，那么直接返回该位置上的数字；如果大于 k-1，说明要求的数字在左半部分，更新右边界，再求新的中枢点位置；反之则更新右半部分，求中枢点的位置



#### 复杂度

时间： `O(nlogn)`

空间：` O(1)`

#### 代码

##### Java

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos == k - 1) {
                return nums[pos];
            }
            if (pos > k - 1) {
                right = pos - 1;
            }
            else left = pos + 1;
        }
    }
    
    
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left], l = left + 1, r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, r, l);
            }
            if (nums[l] >= pivot) ++l;
            if (nums[r] <= pivot) --r;
        }
        swap(nums, left, r);
        return r;
    }
    
    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
```



##### Python

```python
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        left, right = 0, len(nums) - 1
        while True:
            pos = self.partition(nums, left, right)
            if pos == k - 1:
                return nums[pos]
            if pos > k - 1:
                right = pos - 1
            else:
                left = pos + 1
                
    
    def partition(self, nums, left, right):
        pivot = nums[left]
        l, r = left + 1, right
        while l <= r:
            if nums[l] < pivot and nums[r] > pivot:
                nums[l], nums[r] = nums[r], nums[l]
            if nums[l] >= pivot:
                l += 1
            if nums[r] <= pivot:
                r -= 1
        nums[left], nums[r] = nums[r], nums[left]
        return r
```



### 思路2 -Heap

#### 步骤

- ?



#### 复杂度

时间： `O(nlogn)`

空间：` O(1)`

#### 代码

##### Java

```java

```



##### Python

```python

```

