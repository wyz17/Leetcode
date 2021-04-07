

# 130. Surrounded Regions

### 题目

链接：https://leetcode.com/problems/surrounded-regions/



### 思路 - DFS

#### 步骤

- 把矩阵边界连通的O全部找到，其余的O改为X
- 起始顶点为所有边界O的坐标
- flag\[i][j]标志O是否已经走过，若使用flag标记，则使用了O（m*n）的额外空间复杂度，所以把走过的标记为V
- 邻接点为上下左右且符合要求的O.



#### 复杂度

时间： `O(nh)`

空间：` O(h)`



#### 代码

##### Java

```java

```



##### Python

```python

```


