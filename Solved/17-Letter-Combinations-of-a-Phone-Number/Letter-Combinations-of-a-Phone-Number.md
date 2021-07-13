# 17. Letter Combinations of a Phone Number

### 题目

链接：https://leetcode.com/problems/letter-combinations-of-a-phone-number/



### 思路 - Recursion

#### 步骤

- 将输入分为长度等于1和大于1的字符串
  - 如果长度等于1，直接将对应键盘的str分成list返回
  - 如果长度大于1，则使用递归判断
    - 将输入的第一个字符所对应的str分成list返回

- 新增变量diff，判断当前sum与target的差值是否小于diff
- 根据差值判断返回 / l++ / r--



#### 复杂度

时间：` O(4^n)`

空间：` O(4^n)`



#### 代码

##### Java

``` python
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] buttons = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        
        if(digits.length() == 0)
            return res;
        
        String firstLetters = buttons[digits.charAt(0) - '0'];
        
        if(digits.length() == 1){
            for(int i = 0; i < firstLetters.length(); i++)
                res.add(firstLetters.substring(i, i + 1));
            return res;
        }
        
        List<String> combinations = letterCombinations(digits.substring(1));
        for(int i = 0; i < firstLetters.length(); i++){
            String letter = firstLetters.substring(i, i + 1);
            for(String com: combinations){
                res.add(letter + com);
            }
        }
        return res;
    }
}
```



### 思路 - DFS

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

      
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []      
        if not digits: return res
        
        d = {"2":"abc",
             '3':"def",
             '4':"ghi",
             '5':"jkl",
             '6':"mno",
             '7':"pqrs",
             '8':"tuv",
             '9':"wxyz"}
        self.dfs(res, digits, d, "")
        return res

        
    def dfs(self, res, digits, d, tmp):
        if not digits:
            res.append(tmp)
            return
        for c in d[digits[0]]:
            self.dfs(res, digits[1:], d, tmp + c)
```

python代码相对java来说太简洁了...



### 思路 - BFS

- 利用队列
- 记录一下每一个字符的index
- BFS效率比DFS高很多！



#### 复杂度

时间：` O(4^n)`

空间：` O(2 * 4^n)`

![image-20201025175201455](/Users/weiyizhi/Library/Application Support/typora-user-images/image-20201025175201455.png)



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
        
        Queue<StringBuilder> q = new LinkedList<>();
        q.add(new StringBuilder());

        for(int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            int size = q.size();
            while(size-- > 0) {
                StringBuilder cur = q.remove();
                for (char letter : map.get(digit)) {
                    q.add(new StringBuilder(cur).append(letter));
                }
            }
        }
        while (!q.isEmpty()) {
            res.add(q.remove().toString());
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []
        if not digits: return res
        q = []
        d = {"2":"abc",
             '3':"def",
             '4':"ghi",
             '5':"jkl",
             '6':"mno",
             '7':"pqrs",
             '8':"tuv",
             '9':"wxyz"}
        q.append((0, ""))
        
        while q:
            idx, tmp = q.pop() # i is an index kinda of node id
            if idx == len(digits):
                res.append(tmp)
            else:
                nextDigit = digits[idx]
                cur = d[nextDigit]
                for c in cur:
                    q.append((idx + 1, tmp + c))
        return res
```



### Python知识点

- def方法一定要定义在使用前（与java不同）
- python数据结构中带索引的集合可以使用dict（替换java中的map）