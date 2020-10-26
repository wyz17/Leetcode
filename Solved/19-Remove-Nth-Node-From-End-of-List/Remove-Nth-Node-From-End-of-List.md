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

- 利用dfs递归遍历



#### 复杂度

时间：` O(4^n)`

空间：` O(4^n + n)`

![image-20201025172200156](/Users/weiyizhi/Library/Application Support/typora-user-images/image-20201025172200156.png)



#### 代码

##### Java

```java
class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        
        dfs(digits, res, map, 0, "");
        return res;
    }
    
    private void dfs(String digits, List<String> res, Map<Character, char[]> map, int start, String cur){
        //dfs的退出条件
        if(start >= digits.length()){
            res.add(cur);
            return;
        }
        for(char c: map.get(digits.charAt(start))){
            dfs(digits, res, map, start + 1, cur + c);
        }
    }
}
```



##### Python

```python
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        dict = {'2':['a','b','c'],
                '3':['d','e','f'],
                '4':['g','h','i'],
                '5':['j','k','l'],
                '6':['m','n','o'],
                '7':['p','q','r','s'],
                '8':['t','u','v'],
                '9':['w','x','y','z']
               }
        res = []
        length = len(digits)
        
        if digits == "":
            return res
        
        def dfs(num, string, res):
            if num == length:
                res.append(string)
                return
            for letters in dict[digits[num]]:
                dfs(num + 1, string + letters, res)
        
        dfs(0, "", res)
        return res
```

python代码相对java来说太简洁了...



### 思路 - BFS

这里需要用到队列去做 

to be continue



#### 复杂度

时间：` O(4^n)`

空间：` O(2 * 4^n)`

![image-20201025175201455](/Users/weiyizhi/Library/Application Support/typora-user-images/image-20201025175201455.png)



### Python知识点

- Python中没有null

  - 替代：None

  