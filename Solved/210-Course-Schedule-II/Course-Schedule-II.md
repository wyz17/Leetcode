# 210. Course Schedule II

### 题目

- 链接：https://leetcode.com/problems/course-schedule-ii/
- 题意：给出课程的先决条件，基于课程总数和先决条件成对列表，判断是否可以完成所有课程，并输出课程学习顺序



### 思路1 - BFS

#### 步骤

- 首先构建出一个有向图，对于二元对[i, j]，因为j是i的先决条件，因此我们构建有向图使得j指向i
- 我们计算每一个顶点的**入度**。然后我们在图中寻找图中**入度为0的顶点**。
- 如果一个图中没有入度为0的顶点，说明这个图中存在环，我们返回false；
- 否则，我们将这个入度为0的顶点的入度设置为-1防止再次访问它，并将它的邻居的入度都减少1
- 这一题对比前一题[Course Schedule](../../Solved/207-Course-Schedule/Course-Schedule.md)的区别就是需要输出学习课程的顺序
  - 在这里修改一下，将队列出队的每一个节点添加到res
  - 最后返回的时候判断一下res的长度是否等于给出的课程数量；若等于的话，直接返回res，不等于的话返回空数组





#### 复杂度

时间： `O(Vertices + Edge)`

空间：` O(Vertices + Edge)`

#### 代码

##### Java

```java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        
        int[] res = new int[numCourses];
        int count = 0;
        
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList();
        
        for(int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            degree[prerequisites[i][0]]++;
        }
        
        for (int i = 0; i < degree.length; i++) {
            if(degree[i] == 0) {
                queue.add(i);
                res[count++] = i;
            }
        }
        
        while(!queue.isEmpty()) {
            int course = (int)queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0) {
                    res[count++] = pointer;
                    queue.add(pointer);
                }
            }
        }
        return count == numCourses ? res : new int[0];   
    }
}
```



##### Python

```python
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(numCourses)]
        degree = [0] * numCourses
        res = []
        q = []
        
        for ready, pre in prerequisites:
            graph[pre].append(ready)
            degree[ready] += 1
        
        q = [cour for cour, deg in enumerate(degree) if deg == 0]
        
        while q:
            course = q.pop()
            res.append(course)
            for j in graph[course]:
                degree[j] -= 1
                if degree[j] == 0:
                    q.append(j)
        return res if len(res) == numCourses else []
```



### 思路2 - DFS

#### 步骤

- 





#### 复杂度

时间： `O(Vertices + Edge)`

空间：` O(Vertices + Edge)`

#### 代码

##### Java

```java

```



##### Python

```python

```

