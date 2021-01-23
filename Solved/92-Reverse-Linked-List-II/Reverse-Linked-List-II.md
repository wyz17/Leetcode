

# 92. Reverse Linked List II

### 题目

链接：https://leetcode.com/problems/reverse-linked-list/



### 思路1 - Pointer

#### 步骤

- 需要四个指针

  - 一个保存返回的头节点 -- res
  - 一个标记需要reverse的节点的头节点
  - 两个指向当前reverse的两个node -- first & second
  - 还需要一个指针指向后一个node来防止丢失后面的list

- Corner Case

  - list为空 / list只有一个node：直接返回node

  

#### 复杂度

时间：` O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        for(int i = 0; i < m - 1; i++) {
            cur = cur.next;
        }
        ListNode first = cur.next;
        ListNode second = first.next;
        for(int j = 0; j < n - m; j++) {
            first.next = second.next;
            second.next = cur.next;
            cur.next = second;
            second = first.next;
        }
        return res.next;
    }
}
```



##### Python

```python
class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if head == None or head.next == None:
            return head
        res = ListNode(0)
        res.next = head
        cur = res
        for i in range(m - 1):
            cur = cur.next
        first = cur.next
        second = first.next
        for j in range(n - m):
            first.next = second.next
            second.next = cur.next
            cur.next = second
            second = first.next
        return res.next
```


