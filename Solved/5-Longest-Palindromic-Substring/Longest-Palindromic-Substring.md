# 5. Longest Palindromic Substring

### 题目

链接：https://leetcode.com/problems/longest-palindromic-substring/



### 思路1 - 暴力法

#### 步骤

- 先求出所有的字串
- 再判断每一个子串是不是回文



#### 复杂度

时间：```O(n^3)```，三重循环

空间：```O(1)```



#### 代码

##### Java

``` java
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        for(int i = s.length(); i > 0 ; i--){ //字串长度
            for(int j = 0; j <= s.length() - i; j++){ //字串位置
                String sub = s.substring(j, i + j);
                int count = 0;
                for(int k = 0; k < sub.length() / 2; k++){
                    if(sub.charAt(k) == sub.charAt(sub.length() - k - 1))
                        count++;
                }
                if(count == sub.length() / 2)
                    return sub;
                
            }
        }
        return "";
    }
}
```



### 思路2 - 动态规划法

#### 步骤

- 从中心开始（选择一个字符），向两边扩散
- 比较扩散的字符串的长度



#### 复杂度

时间：```O(n^2)```

思路：

1. 判断字符串是否是回文字符串：从中心开始向两边扩散，最坏的情况是全都是回文字符串，所以就是全部访问了一次，复杂度为 O(n)
2. 以每一个字符作为起点，向两边扩散判断，所以这里便利的次数是n次
3. 总的时间复杂度为 O(n^3)



空间：```O(1)```



#### 代码

##### Java

``` java
class Solution {
    public String longestPalindrome(String s) {
        int len = 0; //记录长度
        int start = 0; //记录res开始位置
        for(int i = 0; i < s.length(); i++){
            int cur = Math.max(getLongestLen(s, i, i), getLongestLen(s, i, i+1)); //比较单数长度和双数长度哪个长
            if(cur > len){
                len = cur;
                start = i - (cur - 1)/2; //计算开始的位置
            }
        }
        
        return s.substring(start, start + len);
    }
    
    public int getLongestLen(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){ //循环求出最大回文字符串
            l--;
            r++;
        }
        return r - l - 1;
    }
}
```

