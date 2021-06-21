

# 297. Serialize and Deserialize Binary Tree

### 题目

- 链接：https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
- 题意：序列化和反序列化一个二叉树



### 思路

#### 步骤

- 序列化二叉树：利用字符串n来代表空值
- 反序列化二叉树：用一个队列来存二叉树；默认左子树和右子树为非空节点，然后在队列中添加非空节点



#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
public class Codec {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        buildString(root, res);
        return res.toString();
    }
    
    // Build up a tree using String.
    private void buildString(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if(val.equals(NN)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
```



##### Python

python的方法真的是太绝了

Source：https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/396124/Python-very-easy-to-understand-recursive-preorder-with-comments

```python
class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        res = ""
        if not root: return 'x'
        return root.val, self.serialize(root.left), self.serialize(root.right)
    

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data[0] == 'x': return None
        node = TreeNode(data[0])
        node.left = self.deserialize(data[1])
        node.right = self.deserialize(data[2])
        return node
        
```

