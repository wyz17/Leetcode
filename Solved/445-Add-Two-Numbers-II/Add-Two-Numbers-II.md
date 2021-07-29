# 445. Add Two Numbers II

### 题目

- 链接：https://leetcode.com/problems/add-two-numbers-ii/
- 题意
  - 给出两条链表，链表尾部为起始点，将两条链表相加
  - 注意节点和超过10的时候需要进位
  - 如果头节点和超过10的话需要在链表首部新增进位的节点



### 思路 - 栈

#### 步骤

- 利用栈先进后出的特性，将两个链表分别存入栈中
- 遍历两个栈，求和并更新返回的链表
- 处理进位
  - 每次新增的节点更新在头节点上
  - 使用carry变量来保存上一次计算的进位
  - 在while循环中判断carry是否等于0，不等于0的话说明还需要添加一个进位的头节点



#### 复杂度

时间： `O(max(M, N))`，栈空间取决于输入链表的长度，复杂度是较长的链表长度

空间：` O(max(M, N))`



#### 代码

##### Java

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stk1 = new Stack<>();
        Stack<ListNode> stk2 = new Stack<>();
        
        while(l1 != null) {
            stk1.push(l1);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            stk2.push(l2);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode res = null;
        while(!stk1.isEmpty() || !stk2.isEmpty() || carry != 0) {
            int a = stk1.isEmpty() ? 0 : stk1.pop().val;
            int b = stk2.isEmpty() ? 0 : stk2.pop().val;

            int sum = a + b + carry;
            carry = sum / 10;
            sum %= 10;

            ListNode node = new ListNode(sum);
            node.next = res;
            res = node;
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        s1 = []
        s2 = []
        
        while l1:
            s1.append(l1)
            l1 = l1.next
        while l2:
            s2.append(l2)
            l2 = l2.next
        
        carry = 0
        res = None
        while s1 or s2 or carry != 0:
            a = s1.pop().val if s1 else 0
            b = s2.pop().val if s2 else 0
            s = a + b + carry
            carry = s // 10
            cur = ListNode(s % 10)
            cur.next = res
            res = cur
        return res
```