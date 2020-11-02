

# 24. Swap Nodes in Pairs

### 题目

链接：https://leetcode.com/problems/swap-nodes-in-pairs/



### 思路

#### 步骤

- 递归求解
- 直接看代码，妙啊



#### 复杂度

时间：` O(L)`

空间：` O(1)`



#### 代码

##### Java

``` java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode res = head.next;
        head.next = swapPairs(res.next);
        res.next = head;
        return res;
    }
}
```



##### Python

```python
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head == None:
            return None
        if head.next == None:
            return head
        res = head.next
        head.next = self.swapPairs(res.next)
        res.next = head
        return res
```



## Python知识点

- 自己调用自己的时候记得加self.xxx