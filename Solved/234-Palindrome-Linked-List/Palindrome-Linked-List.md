

# 234. Palindrome Linked List

### 题目

链接：https://leetcode.com/problems/palindrome-linked-list/



### 思路1 - 双指针 + 反转链表 

#### 步骤

- 通过指针fast和slow找到链表的中点
- 在链表中点翻转后半部分的链表
- 比较判断是否与head相同



#### 复杂度

时间： `O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        slow = reverseList(slow);
        fast = head;
        while(slow != null){
            if(fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
```



##### Python

```python
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or not head.next:
            return head
        fast, slow = head, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        if fast:
            slow = slow.next
        slow = self.reverseListNode(slow)
        while slow:
            if head.val != slow.val:
                return False
            slow = slow.next
            head = head.next
        return True
    
    def reverseListNode(self, head):
        pre = None
        while head:
            nex = head.next
            head.next = pre
            pre = head
            head = nex
        return pre
```



### 思路2 - 栈 

#### 步骤

- 快慢指针找到链表的中点同时将慢指针的值入栈
- 到终点之后slow指针继续遍历，出栈并与slow指针比较val
- 注意在中点的时候处理奇数链表：```  if(fast != null) slow = slow.next;```



#### 复杂度

时间： `O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            stk.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) slow = slow.next;
        while(slow != null) {
            int val = stk.pop();
            if(val != slow.val) return false;
            slow = slow.next;
        }
        return true;   
    }
}
```



##### Python

```python
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or not head.next:
            return head
        fast, slow = head, head
        stk = []
        while fast and fast.next:
            stk.append(slow.val)
            fast = fast.next.next
            slow = slow.next
        if fast:
            slow = slow.next
        while slow:
            tmp = stk.pop()
            if tmp != slow.val:
                return False
            slow = slow.next
        return True
```

