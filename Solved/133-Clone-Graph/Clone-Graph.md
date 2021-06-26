# 133. Clone Graph

### 题目

- 链接：https://leetcode.com/problems/clone-graph/
- 题意：复制输入的无向图，包括其中的节点和他的所有邻接节点



### 思路1 - BFS

#### 步骤

- 用一个HashMap存储旧节点到新节点的映射
- 用一个队列去存储Node
- 每一次queue出列一个node，然后检查这个node的所有的neighbors
- 如果没visited过，就入队，并更新neighbor
- 然后更新新的neighbor列表



#### 复杂度

时间： `O(V + E)`

空间：` O(V + E)`



#### 代码

##### Java

```java
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Node res = new Node(node.val);
        HashMap<Node, Node> m = new HashMap<Node, Node>();
        m.put(node, res);
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(Node neigh: cur.neighbors) {
                if(!m.containsKey(neigh)) {
                    q.add(neigh);
                    Node newNeigh = new Node(neigh.val);
                    m.put(neigh, newNeigh);
                }
              	//add neighbor to new created nodes
                m.get(cur).neighbors.add(m.get(neigh));
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        m = {node: Node(node.val)}
        q = []
        q.append(node)
        
        while q:
            cur = q.pop(0);
            for n in cur.neighbors:
                if n not in m:
                    q.append(n)
                    m[n] = Node(n.val)
                m[cur].neighbors.append(m[n])
        return m[node]
```


