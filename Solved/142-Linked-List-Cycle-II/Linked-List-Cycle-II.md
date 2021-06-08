

# 142. Linked List Cycle II

### 题目

链接：https://leetcode.com/problems/linked-list-cycle-ii/



### 思路 - 双指针

#### 步骤

- ![](https://img-blog.csdn.net/20151009091556303?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
- x点为head，y点为环的起始点start，z点为meet
- 根据fast和slow，可以得出 2 (a + b) = a + b + c + b， 从而得出结论 a = c
- 根据fast和slow，我们可以知道meet
- 要求出start，实际上就是meet再走一段c的路程，而这段路程等于 a，也就是等于head走到meet的路程
- 因此算法逻辑为
  - 根据fast和slow求出meet
  - 从meet这里，将slow赋值为head
  - 接下来slow和head同时走，相遇即求出了start
- corner cases
  - 链表无环：fast没有与slow相遇，即循环结束fast与fast.next为空值，返回空



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }
        if(fast == null || fast.next == null) return null;
        if(fast == slow) {
            slow = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
        return head;
    }
}
```



##### Python

```python
class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        slow = fast = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break
        if not fast or not fast.next:
            return None
        if fast == slow:
            slow = head
            while slow != fast:
                slow = slow.next
                fast = fast.next
            return fast
        return None
```

