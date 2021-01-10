

# 75. Sort Colors

### 题目

链接：https://leetcode.com/problems/sort-colors/



### 思路1 - Quick Sort



#### 步骤

- 参考快排思路啦



#### 复杂度

时间：` O(NlogN)`

空间：` O(1)` 



#### 代码

##### Java

```java
class Solution {
    public void sortColors(int[] nums) {
        quickSort(0, nums.length - 1, nums);
    }
    
    private void quickSort(int l, int r, int[] nums) {
        if(l >= r) return;
        int i = l, j = r, tmp = nums[l];
        int t = 0;
        while(i < j) {
            while(tmp <= nums[j] && i < j) j--;
            while(tmp >= nums[i] && i < j) i++;
            if(i < j) swap(nums, i, j)
        }
        nums[l] = nums[i];
        nums[i] = tmp;
        quickSort(l, j - 1, nums);
        quickSort(j + 1, r, nums);
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```



### 思路2 ✨

#### 步骤

- 核心思路就是将所有的0放到左边，将所有的2放到右边，这样中间就全都是1



#### 复杂度

时间：` O(N)`

空间：` O(1)` 



#### 代码

##### Java

```java
class Solution {
    public void sortColors(int[] nums) {
        int l = 0, h = nums.length - 1, i = 0;
        while(i <= h) {
            if(nums[i] == 0) swap(nums, l++, i++);
            else if (nums[i] == 2) swap(nums, i, h--);
            else i++;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```



##### Python

```python
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l, h, i = 0, len(nums) - 1, 0
        while i <= h:
            if nums[i] == 2:
                nums[i], nums[h] = nums[h], nums[i]
                h -= 1
            elif nums[i] == 0:
                nums[i], nums[l] = nums[l], nums[i]
                i += 1
                l += 1
            else:
                i += 1
```

