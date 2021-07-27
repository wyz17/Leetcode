

# 48. Rotate Image

### 题目

链接：https://leetcode.com/problems/rotate-image/



### 思路

#### 步骤

- 两次遍历matrix
- 第一次反转matrix
  - 注意要给j设置一下范围，否则全遍历的话就等于翻转两次 == 🈚️操作
- 第二次上下反转matrix
  - 注意一下对应的范围，应该是只遍历上下的一半就好



#### 复杂度

时间：` O(N^2)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-1-j] = tmp;
            }
        }
    }
}
```



##### Python

```python
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix[0])
        for i in range(n):
            for j in range(i, n):
                matrix[j][i], matrix[i][j] = matrix[i][j], matrix[j][i]
        
        for i in range(n):
            matrix[i].reverse()
```

Python也太简洁了8！！！



###### 再指路一些Python的大佬思路：

https://leetcode.com/problems/rotate-image/discuss/18884/Seven-Short-Solutions-(1-to-7-lines)



## Python Tips

-  **zip** 函数：

```python
a = [[1,2,3],
     [4,5,6],
     [7,8,9]]
zip(*a)
# 经过zip的压缩得到的结果如下
[(1, 4, 7),  (2, 5, 8),  (3, 6, 9)] 
123456
```

到这里我们其实就已经明白了这个函数的作用，zip本来就是压缩，在这里就是直接将一个二维数组纵向压成了一个一维的。 
这个时候我们再把其中压缩后产生的元组转换回list看看它变成了什么样子



```python
map(list, zip(*[[1,2,3],[4,5,6],[7,8,9]]))

# 经过map转换的list的得到的结果如下
[[1, 4, 7],  
 [2, 5, 8],  
 [3, 6, 9]] 

# 而我们期望得到的矩阵是这样的
[[7, 4, 1],  
 [8, 5, 2],  
 [9, 6, 3]] 

# 他们两个是左右相反的，到了这里我们已经明白了原理，将他左右颠倒还不简单，
# 利用python的slice特性[::-1]就可以了呗

matrix[:] = map(list,zip(*a))[::-1]
```



