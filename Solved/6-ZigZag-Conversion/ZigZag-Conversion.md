# 6. ZigZag Conversion

### 题目

链接：https://leetcode.com/problems/zigzag-conversion/



### 思路

- **找规律**
- 考虑情况
  - 第一行和最后一行的规律：2n-2
  - 中间行数的规律：当前列 j + (2n - 2) - 2i (i是行的index）



### 复杂度

时间：```O(n)```，虽然是双重循环，但是实际上走的步数还是s的长度，每一个字符都被访问了一次。

空间：```O(1)```，不包括返回的字符串空间的话就是常数。



### 代码

#### Java

``` java
class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <=0)
            return "";  
        if(numRows == 1)
            return s;
        
        StringBuilder res = new StringBuilder();
        int circle = 2 * numRows - 2;
        
        for(int i = 0; i < numRows; i++){ //行数
            for(int j = i; j < s.length(); j += circle){
                res.append(s.charAt(j));
                if(i != 0 && i != numRows - 1){
                    //except the first row and the last row
                    int temp = j + circle - 2 * i;
                    if(temp < s.length())
                        res.append(s.charAt(temp));
                }
            }
        }
        
        return res.toString();
    }
}
```

