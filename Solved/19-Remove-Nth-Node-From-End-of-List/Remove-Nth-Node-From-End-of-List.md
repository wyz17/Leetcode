# 19. Remove Nth Node From End of List

### 题目

链接：https://leetcode.com/problems/remove-nth-node-from-end-of-list/



### 思路1 - Two Pass

#### 步骤

- 第一次遍历求出链表的长度len
- 第二次遍历则删除对应节点



#### 复杂度

时间：` O(L)`

- L：链表长度

空间：` O(1)`



#### 代码

##### Java

``` python
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        len -= n;
        cur = res;
        while(len > 0){
            len--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return res.next;
    }
}
```



##### Python

```python
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        res = ListNode(0)
        res.next = head
        cur = head
        length = 0;
        while cur != None:
            length = length + 1
            cur = cur.next
        cur = res
        length = length - n
        while length > 0:
            cur = cur.next
            length = length - 1
        cur.next = cur.next.next
        
        return res.next
```





### 思路2 - One Pass

#### 步骤

- 利用双指针，第一个指针为i，第二个指针为n+i
- 当第二个指针到达末端的时候，第一个指针就指向要删除的节点



#### 复杂度

时间：` O(L)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p1 = res;
        ListNode p2 = res;  //防止出现.next为空指针的情况，这里p.next指向head
        while(n >= 0){
            p2 = p2.next;
            n--;
        }
        
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        p1.next = p1.next.next;
        return res.next;
    }
}
```



##### Python

```python
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        res = ListNode(0)
        res.next = head
        p1 = res
        p2 = res
        while n >= 0:
            p2 = p2.next
            n = n - 1
        while p2 != None:
            p1 = p1.next
            p2 = p2.next
        p1.next = p1.next.next
        return res.next
```



### Python知识点

- Python中没有null

  - 替代：None

  