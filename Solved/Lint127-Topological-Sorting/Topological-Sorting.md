# Lint-127. Topological Sorting

### 题目

链接：https://www.lintcode.com/problem/127/



### 思路1 - BFS

#### 步骤

- 拓扑排序
- 首先将入度为0的点插入队列中（因为入度为0，没有结点是它的父结点，也就是说没有结点要比它先完成，所以它的顺序一定是第一个）
- 再将队列队头结点取出并出队
- 找到此结点的邻接结点，将这些邻接结点的入度减一
- 如果减一后有结点入度为0，继续插入队列中…….依次往下



#### 复杂度

时间： `O(V + E)`

空间：` O(V + E)`

#### 代码

##### Java

```java
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();

        // 根据节点构建入度表
        for(DirectedGraphNode node : graph) {
            for(DirectedGraphNode neighbor : node.neighbors) {
                if (indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                } else {
                    indegree.put(neighbor, 1);
                }
            }
        }

        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) {
                queue.offer(node);
                res.add(node);
            }
        }
        
        while (!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();  //出栈获取结点
            for (DirectedGraphNode neighbor : node.neighbors){ //访问该点的邻居
                indegree.put(neighbor, indegree.get(neighbor) - 1);  //该点的邻居的入度-1（因为访问该点）
                if(indegree.get(neighbor) == 0) {  //邻居入度为0  可以进入队列和结果中
                    queue.offer(neighbor);
                    res.add(neighbor);
                }
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    """
    @param graph: A list of Directed graph node
    @return: Any topological order for the given graph.
    """
    def topSort(self, graph):
        res = []
        queue = []
        degree = {x: 0 for x in graph}

        for node in graph:
            for neighbor in node.neighbors:
                degree[neighbor] += 1

        q = [n for n in graph if degree[n] == 0]

        while q:
            node = q.pop()
            res.append(node)
            for neighbor in node.neighbors:
                degree[neighbor] -= 1
                if degree[neighbor] == 0:
                    q.append(neighbor)
        return res
```