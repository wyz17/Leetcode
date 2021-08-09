# 328. Odd Even Linked List

### 题目

链接：https://leetcode.com/problems/odd-even-linked-list/



### 思路

#### 步骤

- 步骤如图
- head：current
- odd：奇链表的current
- even：偶链表的current
- evenHead：偶链表头，用于拼接奇链表和偶链表

![](https://leetcode.com/problems/odd-even-linked-list/Figures/328_Odd_Even.svg)



#### 复杂度

时间： `O(n)`

空间：` O(1)`

#### 代码

##### Java

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        
        ListNode odd = head, even = head.next, evenHead = even;
        
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
       odd.next = evenHead;
        return head;
    }
}
```



##### Python

```python
class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if not head:
            return head
        odd = head
        even = head.next
        evenHead = even
        while even and even.next:
            odd.next = even.next
            odd = odd.next
            even.next = odd.next
            even = even.next
        odd.next = evenHead
        return head
```

