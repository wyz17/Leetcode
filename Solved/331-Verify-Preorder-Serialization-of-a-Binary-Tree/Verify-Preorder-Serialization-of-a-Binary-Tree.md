# 331. Verify Preorder Serialization of a Binary Tree

### 题目

- 链接：https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
- 题意：输入一个二叉树先序遍历的字符串，判断这个序列是否可以转换成一个二叉树



### 思路

#### 步骤

- 根据输入的字符串判断入度和出度，diff = 出度 - 入度
- diff初始化为1：假设树的根节点被一个虚拟节点所指
- 数字（一个树节点）：入度为1，出度为2
- #（空节点）：入度为1，出度为0
- 遍历整个输入序列，整个流程判断是否存在出度 > 入度的情况
  - 存在的话就返回false
  - 不存在的话，最后判断diff是否等于0



#### 复杂度

时间： `O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public boolean isValidSerialization(String preorder) {
        int diff = 1;
        String[] s = preorder.split(",");
        if(!s[s.length - 1].equals("#")) return false; 
        for(String c: s) {
            diff--;
            if(diff < 0) return false;
            if(!c.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
```



##### Python

```python
class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        diff = 1
        s = preorder.split(",")
        for c in s:
            diff -= 1
            if diff < 0:
                return False
            if c != '#':
                diff += 2
        return diff == 0
```
