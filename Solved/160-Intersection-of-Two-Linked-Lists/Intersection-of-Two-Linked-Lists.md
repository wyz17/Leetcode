

# 160. Intersection of Two Linked Lists

### 题目

链接：https://leetcode.com/problems/intersection-of-two-linked-lists/



### 思路 - 双指针

#### 步骤

- 查找两个链表的第一个公共节点，如果两个节点的尾节点相同，肯定存在公共节点
- 两个指针L1和L2：L1指向headA，L2指向headB
- 两个指针同时后移，直到他们到达链尾
- 这时指针指向另一个链表头部（比如，L1到达尾部，则指向headB，L2到达尾部，则指向headA)
- 经过一次交换链表的指向，就相当于是跳过了两个链表长度的差值
- 之后就可以开始判断是否有共同的交叉节点了



#### 复杂度

时间：` O(n + m)`

空间：` O(1)`



#### 代码

##### Java

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB) {
            pA = pA == null? headB : pA.next;
            pB = pB == null? headA : pB.next;    
        }
        return pA;  
    }
}
```



##### Python

```python
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None
        pA, pB = headA, headB
        while pA != pB:
            pA = headB if not pA else pA.next
            pB = headA if not pB else pB.next
        return pA
```
