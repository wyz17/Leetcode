

# 206. Reverse Linked List

### 题目

链接：https://leetcode.com/problems/reverse-linked-list/



### 思路1 - Pointer

#### 步骤

- 需要三个指针

  - 两个指向当前reverse的两个node
  - 还需要一个指针指向后一个node来防止丢失后面的list

- Corner Case

  - list为空 / list只有一个node：直接返回node
  - list只有两个node：可以包含在主体代码里，当第三个指针为null时结束返回。

  

#### 复杂度

时间：` O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;
        first.next = null;
        while(third != null) {
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }
        second.next = first;
        return second;
    }
}
```



##### Python

```python
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head == None or head.next == None:
            return head
        first = head
        second = head.next
        third = head.next.next
        first.next = None
        while third != None:
            second.next = first
            first = second
            second = third
            third = third.next
        second.next = first
        return second
```



### 思路2 - Recursive

#### 步骤

- 假设1~n-1已经全部完成
- 那么1 -> 2 -> 3 -> 4   ------>  3 -> 2 -> 1 -> null 和 4
- 因此，我们就把4加在3前面即可
- Corner Case
  - list为空 / list只有一个node：直接返回node
  - list只有两个node：可以包含在主体代码里，当第三个指针为null时结束返回。



#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
```



##### Python

```python
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head == None or head.next == None:
            return head
        cur = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return cur
```

