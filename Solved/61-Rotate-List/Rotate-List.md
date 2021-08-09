

# 61. Rotate List

### 题目

链接：https://leetcode.com/problems/rotate-list/



### 思路

#### 步骤

- 按照题意直接写就好
- 思路很简单，但是处理边界值有点烦
- 这里在求length的同时可以直接将end和head连起来，继续遍历，从而避免中途使用多个node去记录断开的地方



#### 复杂度

时间：` O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            cur = cur.next;
            len++;
        }
        k %= len;
        cur.next = head;
    
        for(int i = 0; i < len - k; i++) {
            cur = cur.next;
        }
        ListNode res = new ListNode(0);
        res = cur.next;
        cur.next = null;
        return res;
    }
}
```



##### Python

```python
class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head == None or head.next == None or k == 0:
            return head
        l = 1
        cur = head
        while cur != None and cur.next != None:
            cur = cur.next
            l = l + 1
        k %= l
        cur.next = head
        
        for i in range(0, l-k):
            cur = cur.next
        res = cur.next
        cur.next = None
        return res
```

