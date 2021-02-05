

# 109. Convert Sorted List to Binary Search Tree

### 题目

链接：https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/



### 思路1 - Recursive

#### 步骤

- 这道题是要求把有序链表转为二叉搜索树，和Convert Sorted Array to Binary Search Tree思路完全一样，只不过是操作的数据类型有所差别，一个是数组，一个是链表
- 由于二分查找法每次需要找到中点，而链表的查找中间点可以通过快慢指针来操作。
- 找到中点后，要以中点的值建立一个树的根节点，然后需要把原链表断开，分为前后两个链表，都不能包含原中节点，然后再分别对这两个链表递归调用原函数，分别连上左右子节点即可




#### 复杂度

时间：` O(NlogN)`

空间：` O(logN)` 



#### 代码

##### Java

```java
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return findMid(head, null);
    }
    
    private TreeNode findMid(ListNode start, ListNode end) {
        if(start == end) return null;
        ListNode fast = start;
        ListNode slow = start;
        while(fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = findMid(start, slow);
        node.right = findMid(slow.next, end);
        return node;
    }
}
```



##### Python

```python
class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        return self.build(head, None)
    
    def build(self, start, end):
        if start == end:
            return None
        fast = start
        slow = start
        while fast != end and fast.next != end:
            slow = slow.next
            fast = fast.next.next
        node = TreeNode(slow.val)
        node.left = self.build(start, slow)
        node.right = self.build(slow.next, end)
        return node
```



### 思路2 - TBC

#### 步骤

- 




#### 复杂度

时间：` O(？)`

空间：` O(？)`



#### 代码

##### Java

```java

```



##### Python

```python

```

