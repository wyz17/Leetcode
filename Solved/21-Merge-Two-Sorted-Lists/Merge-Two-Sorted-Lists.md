

# 21. Merge Two Sorted Lists

### 题目

链接：https://leetcode.com/problems/merge-two-sorted-lists/



### 思路1 - 迭代法

#### 步骤

- 直接遍历ListNode求解就好



#### 复杂度

时间：` O(L(m+n))`

空间：` O(1)`



#### 代码

##### Java

``` java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        res.next = l1.val > l2.val ? l2 : l1;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;   
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return res.next;
    }
}
```



##### Python

```python
class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None:
            return l2
        if l2 == None:
            return l1
        res = ListNode(0)
        cur = res
        res.next = l2 if l1.val > l2.val else l1
        while l1 != None and l2 != None:
            if l1.val > l2.val:
                cur.next = l2
                l2 = l2.next
            else:
                cur.next = l1
                l1 = l1.next
            cur = cur.next
        cur.next = l1 if l1 != None else l2
        return res.next
            
```



### 思路2 - 递归法

#### 步骤

- 将上面的方法变成递归



#### 复杂度

时间：` O(L(m+n))`

空间：` O(1)`



#### 代码

##### Java

``` java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
      if(l1 == null) return l2;
			if(l2 == null) return l1;
			if(l1.val < l2.val){
				l1.next = mergeTwoLists(l1.next, l2);
				return l1;
			} else{
				l2.next = mergeTwoLists(l1, l2.next);
				return l2;
			}
	}
}
```



##### Python

```python
class Solution(object):
    def mergeTwoLists(self, l1, l2):
    if not l1 or not l2:
        return l1 or l2
    if l1.val < l2.val:
        l1.next = self.mergeTwoLists(l1.next, l2)
        return l1
    else:
        l2.next = self.mergeTwoLists(l1, l2.next)
        return l2
            
```

