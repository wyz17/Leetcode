

# 83. Remove Duplicates from Sorted List



### 题目

链接：https://leetcode.com/problems/remove-duplicates-from-sorted-list/



### 思路

#### 步骤

- 新初始化链表头res作为虚拟头节点
- 再初始化链表结点prev用来保存连接时head的前一个节点
- 之后判断操作head就好



#### 复杂度

时间：` O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode prev = res;
        while(head != null) {
            if(head.next != null && head.val == head.next.val) {
                while(head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return res.next;
        
    }
}
```



##### Python

```python
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        res = ListNode(0, head)
        prev = res
        while(head != None):
            if head.next != None and head.val == head.next.val:
                while head.next != None and head.val == head.next.val:
                    head = head.next
                prev.next = head.next
            else:
                prev = prev.next
            head = head.next
        return res.next
```

