

# 86. Partition List



### 题目

链接：https://leetcode.com/problems/partition-list/



### 思路

#### 步骤

- 这个难度真的是medium吗？还是我变强了呜呜呜
- 记得考虑right后面要断开



#### 复杂度

时间：` O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode res = left;
        ListNode joint = right;
        
        while(head != null) {
            if(head.val < x) {
                left.next = head;
                left = left.next;
            }
            else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = joint.next;
        return res.next;
    }
}
```



##### Python

```python
class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        left = ListNode(0)
        res = left
        right = ListNode(0)
        joint = right
        
        while head != None:
            if head.val < x:
                left.next = head
                left = left.next
            else:
                right.next = head
                right = right.next
            head = head.next
        right.next = None
        left.next = joint.next
        return res.next
```

