# 912. Sort an Array

### 题目

链接：https://leetcode.com/problems/sort-an-array/



### 思路1 - Quick Sort（快速排序）

#### 步骤

- It picks an element as pivot and partitions the given array around the picked pivot
- 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据比另一部分的所有数据要小，再按这种方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，使整个数据变成有序序列



#### 复杂度

时间： `O(nlogn)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    
    public void quickSort(int[] nums, int low, int high){
        if(low >= high) return;
        int i, j, temp, t;
        i = low;
        j = high;
        temp = nums[low];
        
        while(i < j){
            while(nums[j] >= temp && i < j) j--;
            while(nums[i] <= temp && i < j) i++;
            if(i < j){
                t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
        }
        nums[low] = nums[i];
        nums[i] = temp;
        
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }
}
```



##### Python

```python

```





### 思路2 - Merge Sort（归并排序）

#### 步骤

- Recursive
- Iterative





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

