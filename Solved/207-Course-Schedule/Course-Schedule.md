# 207. Course Schedule

### 题目

- 链接：https://leetcode.com/problems/course-schedule/
- 题意：给出课程的先决条件，基于课程总数和先决条件成对列表，判断是否可以完成所有课程



### 思路1 - BFS

#### 步骤

- 首先构建出一个有向图，对于二元对[i, j]，因为j是i的先决条件，因此我们构建有向图使得j指向i
- 我们计算每一个顶点的**入度**。然后我们在图中寻找图中**入度为0的顶点**。
- 如果一个图中没有入度为0的顶点，说明这个图中存在环，我们返回false；
- 否则，我们将这个入度为0的顶点的入度设置为-1防止再次访问它，并将它的邻居的入度都减少1。





#### 复杂度

时间： `O(Vertices + Edge)`

空间：` O(Vertices + Edge)`

#### 代码

##### Java

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList();
        
        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            degree[ready]++;
            graph[pre].add(ready);
        }
        
        int count = 0;
        for (int i = 0; i < degree.length; i++) {
            if(degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        
        while (!queue.isEmpty()) {
            int course = (int)queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
```



##### Python

```python
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = [[] for _ in range(numCourses)]
        degree = [0] * numCourses
        q = []
        count = 0
        
        for ready, pre in prerequisites:
            graph[pre].append(ready)
            degree[ready] += 1
        
        for i in range(0, numCourses):
            if degree[i] == 0:
                q.append(i)
                count += 1
        
        
        while q:
            course = q.pop()
            for j in graph[course]:
                degree[j] -= 1
                if degree[j] == 0:
                    q.append(j)
                    count += 1
            
        return count == numCourses
```

