# 449. Serialize and Deserialize BST

### 题目

链接：https://leetcode.com/problems/serialize-and-deserialize-bst/



### 思路

#### 步骤

- 构建二叉树



#### 复杂度

时间： `O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
        
    }
    
    private void build(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#").append(",");
        } else {
            sb.append(root.val).append(",");
            build(root.left, sb);
            build(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q);
    }
    
    private TreeNode deserialize(Queue<String> q) {
        String cur = q.poll();
        if (cur.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
    }
}
```



##### Python

```python
class Codec:
    def serialize(self, root: TreeNode) -> str:
        """Encodes a tree to a single string.
        """
        if not root: return ''
        q = collections.deque([root])
        res = []
        while q:
            node = q.popleft()
            if node:
                q.append(node.left)
                q.append(node.right)
                res.append(str(node.val))
            else:
                res.append('None')
        return ' '.join(res)
    
    def deserialize(self, data: str) -> TreeNode:
        """Decodes your encoded data to tree.
        """
        if not data: return None
        data_q = collections.deque(data.split(' '))
        root = TreeNode(int(data_q.popleft()))
        tree_q = collections.deque([root])
        while tree_q:
            node = tree_q.popleft()
            left = data_q.popleft()
            right = data_q.popleft()
            if left != 'None':
                left_node = TreeNode(int(left))
                node.left = left_node
                tree_q.append(left_node)
            if right != 'None':
                right_node = TreeNode(int(right))
                node.right = right_node
                tree_q.append(right_node)
        return root
```

