

# 141. Linked List Cycle

### 题目

链接：https://leetcode.com/problems/linked-list-cycle/



### 思路 - 双指针

#### 步骤

- 快慢指针双重循环



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        while(p1 != p2){
            if(p2 == null || p2.next == null)
                return false;
            p2 = p2.next.next;
            p1 = p1.next;
        }
        return true;
    }
}
```



##### Python

```python
class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if head == None:
            return False
        slow = head
        fast = head.next
        while slow != fast:
            if fast == None or fast.next == None:
                return False
            fast = fast.next.next
            slow = slow.next
        return True
```


