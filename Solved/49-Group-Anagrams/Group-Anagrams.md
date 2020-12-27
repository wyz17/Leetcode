

# 49. Group Anagrams

### 题目

链接：https://leetcode.com/problems/group-anagrams/



### 思路1 - Sorted String

#### 步骤

- 将每一个str的charList sort，将这个作为key值存进hashmap
- 根据hashmap输出

![image-20201228002325372](/Users/weiyizhi/Library/Application Support/typora-user-images/image-20201228002325372.png)

![image-20201228003848833](/Users/weiyizhi/Library/Application Support/typora-user-images/image-20201228003848833.png)



#### 复杂度

时间：` O(NKlogK)`

- N是数组strs的长度
- K是strs中最长字符串的长度
  - for loop是N，内部的sort是KlogK

空间：` O(NK)`



#### 代码

##### Java

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        HashMap<String, List> map = new HashMap<>();
        for(String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
```



##### Python

```python
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = collections.defaultdict(list)
        for str in strs:
            res[tuple(sorted(str))].append(str)
        return res.values()
        
```

Python yyds



## Python Tips

-  **defaultdict** ：初始化一个新数组，可以避免KeyError的错误
