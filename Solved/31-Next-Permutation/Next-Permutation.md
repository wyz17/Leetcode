

# 31. Next Permutation

### 题目

链接：https://leetcode.com/problems/next-permutation/

意思是这个数组下一个最大的全排列





### 思路

![Next Permutation](https://leetcode.com/media/original_images/31_Next_Permutation.gif)

#### 步骤

- 这里使用的方法非常巧妙！
- 因为要求出来的是当前排列组合的下一个最大值，所以思路就是
  - 从数组末尾往前遍历，按照升序遍历，直到找到第一个为降序的数字
  - 根据这个降序的数字，我们再从他后面找，找到那个只比他小一点点的数，两者换位置
  - 换完位置之后数组剩下的数只需要逆序就好了



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public void nextPermutation(int[] nums) {
        //find out element need to be swapped
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if(i >= 0) {
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }
    
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while(i < j){
           swap(nums, i, j); 
            i++;
            j--;
        }
    }
    
    //Swap pos i and pos j
    private int[] swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
        return nums;
    }
}
```



##### Python

```python
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # find out min element in asdending order from back to front
        i = len(nums) - 2
        while i >= 0 and nums[i] >= nums[i + 1]:
            i = i - 1
        if i >= 0:
            j = len(nums) - 1
            while j >= 0 and nums[j] <= nums[i]:
                j = j - 1
            self.swap(nums, i, j)
        self.reverse(nums, i + 1)
    
    def reverse(self, nums, start):
        i = start
        j = len(nums) - 1
        while i < j:
            self.swap(nums, i, j)
            i = i + 1
            j = j - 1
        return nums
            
    def swap(self, nums, i, j):
        nums[i], nums[j] = nums[j], nums[i]
```


