# 11. Container With Most Water

### 题目

链接：https://leetcode.com/problems/container-with-most-water/



### 思路1 - 暴力法（x）

#### 步骤

- 双重循环遍历求出体积



#### 复杂度

时间：```O(n^2)```

空间：```O(1)```



#### 代码

##### Java

``` java
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i; j < height.length; j++){
                int cal = (j - i) * Math.min(height[i], height[j]);
                if(cal > res)
                    res = cal;
            }
        }
        return res; 
    }
}
```



##### Python

```python
class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        res = 0
        for i in range(0, len(height) - 1):
            for j in range(i+1, len(height)):
                tmp = min(height[i], height[j]) * (j - i)
                if(tmp > res):
                    res = tmp
        return res;
```

<u>Python会超时</u>



### 思路2 - 双指针法

#### 思路

- 左右设置两个指针
- 当且仅当小的那个值往里面移动才有可能出现更高的res，所以每次只要min++就好



#### 复杂度

时间：```O(n)```，左指针+右指针仅遍历一次

空间：```O(1)```



#### 代码

##### Java

```java
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r){
            int cal = (r - l) * Math.min(height[r], height[l]);
            if(cal > res) res = cal;
            if(height[r] < height[l]) r--;
            else l++;
        }
        return res;
    }
}
```



##### Python

```python
class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        res = 0
        l = 0
        r = len(height) - 1
        while(l < r):
            tmp = min(height[l], height[r]) * (r - l)
            if tmp > res:
                res = tmp
            if height[r] < height[l]:
                r = r - 1
            else:
                l = l + 1
        return res
```



# Python知识点

### Python 中 ++ & --

- python中没有这个，实现自增只能 a = a + 1 或 a += 1
  - python中的数字类型是不可变数据，也就是数字类型数据在内存中不会发生改变，当变量值发生改变时，会新申请一块内存赋值为新值，然后将变量指向新的内存地址
    - += 是改变变量，相当于重新生成一个变量，把操作后的结果赋予这个新生成的变量
    - -- 是改变了对象本身，而不是变量本身，即改变数据地址所指向的内存中的内容

