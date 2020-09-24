# 8. String to Integer

### 题目

链接：https://leetcode.com/problems/string-to-integer-atoi/



### 思路

- **纯粹看耐心**
- 遍历字符串就好



### 复杂度

时间：```O(n)```，每一个字符都被访问了一次。

空间：```O(1)```



### 代码

``` java
class Solution {
    public int myAtoi(String str) {
        int res = 0;
        int flg = 1;
        int i = 0;
        str = str.trim();
        if(str.length() == 0) return 0;
        //while(str.charAt(i) == ' ') i++;
        if(str.charAt(i) == '+') i++;
        else if(str.charAt(i) == '-'){ flg = -1; i++;}
        
        while(i < str.length() && Character.isDigit(str.charAt(i))){
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10))
               return (flg == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + str.charAt(i) -'0';
            i++;
        }
        return flg * res;
    }
    
}
```





### Tips

#### 判断int整型溢出处理

- **if(res >= (Integer.MAX_VALUE / 10))**
- 在这道题中的判断：
  - **if(res > Integer.MAX\_VALUE / 10 || (res == Integer.MAX\_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX\_VALUE % 10))**



#### 判断字符是否是数字的方法

- **Character.isDigit('c')**

```java
public class Test {

    public static void main(String args[]) {
        System.out.println(Character.isDigit('c'));
        System.out.println(Character.isDigit('5'));
    }
}
```



#### 相似问题返回正负的处理方法

- 可以用一个 **int flg = 1 / -1** 来表示
- 最后的返回值是 **flg * res** 就好（boolean没有int方便）

