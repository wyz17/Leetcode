# 16. 3Sum Closest

### 题目

链接：https://leetcode.com/problems/3sum-closest/



### 思路 - 三指针法

类似之前的3Sum方法



#### 步骤

- 利用三个指针 i，l，r
- 在i循环中l++，r--
- 新增变量diff，判断当前sum与target的差值是否小于diff
- 根据差值判断返回 / l++ / r--



#### 复杂度

时间：` O(n^2)`

空间：` O(1)`



#### 代码

##### Java

``` python
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        int diff = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[l] + nums[r] + nums[i];
                diff = Math.abs(sum - target);
                if(diff < min){
                    min = diff;
                    res = sum;
                }
                if(sum == target) return sum;
                if(sum < target) l++;
                else r--;
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort();
        res = nums[0]
        minval = sys.maxsize
        for i in range(0, len(nums)):
            l = i + 1
            r = len(nums) - 1
            while l < r:
                sum3 = nums[l] + nums[r] + nums[i]
                diff = abs(sum3 - target)
                if diff < minval:
                    res = sum3
                    minval = diff
                if sum3 == target:
                    return sum3
                if sum3 < target:
                    l = l + 1
                if sum3 > target:
                    r = r - 1
        return res
```



## Python知识点

- python中list排序

  - ```python
    list.sort(cmp=None, key=None, reverse=False)
    ```

  - key -- 主要是用来进行比较的元素，只有一个参数，具体的函数的参数就是取自于可迭代对象中，指定可迭代对象中的一个元素来进行排序。

  - reverse -- 排序规则，**reverse = True** 降序， **reverse = False** 升序（默认）。

- 获取int最大值

  - ``````python
    import sys
    MAX_INT=sys.maxsize
    print(MAX_INT)
    ``````

- python中没有i++和i--
  - 在python中是没有自增和自减的，但在python中存在 i = i + 1和 i = i -1 的情况。
  - 因为Python的模型规定，数值对象是不可改变的。 i = i + 1 相当于重新创建了一个变量 i ，而不是改变了 i 中的数值