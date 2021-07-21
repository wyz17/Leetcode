# 140. Word Break II

### 题目

- 链接：https://leetcode.com/problems/word-break-ii/
- 题意：给出字典list和字符串，使用空格分割字符串，使得字符串被分割的每一个单词都是属于字典list中的单词。返回所有符合该条件的字符串。相同的单词可以被重复使用。



### 思路 - DFS

#### 步骤

- 每次维护一个当前结果集，然后遍历剩下的所有子串
- 如果子串在字典中出现，则保存一下结果，并放入下一层递归剩下的字符



#### 复杂度

时间： `O(?)`

空间：` O(?)`



#### 代码

##### Java

```java
class Solution {
    HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return res;
        }
        if(map.containsKey(s)) {
            return map.get(s);
        }
        if(wordDict.contains(s)) {
            res.add(s);
        }
        for(int i = 1 ; i < s.length() ; i++) {
            String t = s.substring(i);
            if(wordDict.contains(t)) {
                List<String> temp = wordBreak(s.substring(0 , i) , wordDict);
                if(temp.size() != 0) {
                    for(int j = 0 ; j < temp.size() ; j++) {
                        res.add(temp.get(j) + " " + t);
                    }
                }
            }
        }
        map.put(s , res);
        return res;
    }
}
```


