

# 203. Remove Linked List Elements

### 题目

链接：https://leetcode.com/problems/remove-linked-list-elements/



### 思路

#### 步骤

- 循环遍历求解就好
- 注意细节



#### 复杂度

时间： `O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0);
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        res.next = head;
        pre = res;
        
        while(cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
       return res.next;
    }
}
```



##### Python

```python
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        res = ListNode(0)
        res.next = head
        pre = res
        cur = head
        
        while cur:
            if cur.val == val:
                pre.next = cur.next
            else:
                pre = pre.next
            cur = cur.next
        return res.next
```

