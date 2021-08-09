# 876. Middle of the Linked List

### 题目

链接：https://leetcode.com/problems/middle-of-the-linked-list/



### 思路 - Two Pointers

#### 步骤

- fast和slow遍历指针
- 当fast到末尾的时候直接返回slow就好



#### 复杂度

时间： `O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
```



##### Python

```python
class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        fast = head
        slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        return slow
```

