# 127. Word Ladder

### 题目

- 链接：https://leetcode.com/problems/word-ladder/
- 题意：字符变换，给出备选的word list，判断是否能从当前的start变成给出的end；如果可以变换的话，给出最小步骤



### 思路1 - BFS

#### 步骤

- BFS经典思路
- 利用队列保存每个遍历的有效的字符串，然后对队列中的每个字符串再次遍历，保存每次遍历的长度即可。



#### 复杂度

时间： `O(V + E)`

空间：` O(V + E)`



#### 代码

##### Java

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String i : wordList) set.add(i);
        
        if (!set.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int steps = 0;
        q.offer(beginWord);
        visited.add(beginWord);
        int step = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            step++;
            for(int i = 0; i < size; i++) {
                char[] chs = q.poll().toCharArray();
                for(int j = 0; j < chs.length; j++) {
                    char ch = chs[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if (c == ch) continue;
                        chs[j] = c;
                        String next = new String(chs);
                        if(next.equals(endWord)) return step + 1;
                        if (!set.contains(next) || visited.contains(next)) continue;
                        q.add(next);
                        visited.add(next);
                    }
                    chs[j] = ch;
                }
            }
        }
        return 0;
    }
}
```



### 思路1优化 - 双向BFS

source：https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
