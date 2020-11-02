

# 22. Generate Parentheses

### 题目

链接：https://leetcode.com/problems/generate-parentheses/



### 思路1 - 递归 - Backtracking

#### 步骤

- DFS递归求解
- 注意判断当右括号在做括号前面的情况，即左边需要添加的括号数量小于右括号，则是无效情况



#### 复杂度

参见lc上

![image-20201102002336035](/Users/weiyizhi/Library/Application Support/typora-user-images/image-20201102002336035.png)



#### 代码

##### Java

``` java
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        generateParenthesisDFS(n, n, "", res);
        return res;
    }
    
    private void generateParenthesisDFS(int left, int right, String str, List<String> res){
        if(left < 0 || right < 0 || left > right) return;
        if(left == 0 && right == 0){
            res.add(str);
            return;
        }
        generateParenthesisDFS(left - 1, right, str + "(", res);
        generateParenthesisDFS(left, right - 1, str + ")", res);
    }
}
```



##### Python

```python
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def generateParenthesisDFS(left, right, output):
            if left < 0 or right < 0 or left < right:
                return
            if left == 0 and right == 0:
                res.append(output)
            generateParenthesisDFS(left - 1, right, output + ')')
            generateParenthesisDFS(left, right - 1, output + '(')
        generateParenthesisDFS(n, n, '')
        return res            
```



### 思路2 - DP

#### 步骤

- 观察规律

```
P[0]= [""]

P[1] = [()] = "("+P[0]+")"+P[0]

P[2] = [()(),(())] = "("+P[0]+")"+P[1] , "("+P[1]+")" +P[0]

P[3] = [()()(),()(()),(())(),(()()),((()))] = "("+P[0]+")"+P[2] , "("+P[1]+")"+P[1], "("+P[2]+")" +P[0]
```

- 得出结论 **P[i] =  "(" + P[i - j - 1] + ")" + P[j]    ( j < i, j = 0, 1, 2, ......)**

理解中ing



#### 复杂度

时间 & 空间

均与上述方法一样



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
