# 138. Copy List with Random Pointer

### 题目

- 链接：https://leetcode.com/problems/copy-list-with-random-pointer/



### 思路

#### 步骤

- ![alt text](https://raw.githubusercontent.com/hot13399/leetcode-graphic-answer/master/138.%20Copy%20List%20with%20Random%20Pointer.jpg)
- 第一个循环：在原节点后面新增一个复制节点
- 第二个循环：复制原节点后新增节点的random
- 第三个循环：删除原节点，保留复制节点
- 返回复制节点头



#### 复杂度

时间： `O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node c = head;
        
        while(c != null) {
            Node next = c.next;
            c.next = new Node(c.val);
            c.next.next = next;
            c = next;
        }
        
        c = head;
        while(c != null) {
            if(c.random != null) {
                c.next.random = c.random.next;
            }
            c = c.next.next;
        }
        
        c = head;
        Node copyHead = head.next;
        Node copy = copyHead;
        while(copy.next != null) {
            c.next = c.next.next;
            c = c.next;
            
            copy.next = copy.next.next;
            copy = copy.next;
        }
        c.next = c.next.next;
        return copyHead;
    }
}
```



##### Python

```python
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head: return head
        c = head
        
        while c:
            n = c.next
            c.next = Node(c.val)
            c.next.next = n
            c = n
        
        c = head
        while c:
            if c.random != None:
                c.next.random = c.random.next
            c = c.next.next
        
        c = head
        copyHead = head.next
        copy = copyHead
        while copy.next:
            c.next = c.next.next
            c = c.next
            
            copy.next = copy.next.next
            copy = copy.next
        c.next = c.next.next
        return copyHead
```

