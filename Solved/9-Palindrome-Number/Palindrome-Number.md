# 9. Palindrome Number

### 题目

链接：https://leetcode.com/problems/palindrome-number/



### 思路1 - String翻转

#### 步骤

- 将数字转换为字符串
- 利用循环遍历字符串判断



#### 复杂度

时间：`O(n) `

空间：`O(1) `

Leetcode中要求不用字符串的方法，pass



### 思路2 - 翻转一半的数

#### 步骤

- 求出翻转一半的数
- 将原数除到一半
- 对比两者



#### 复杂度

时间：`O(log 10(n)) `

空间：`O(1) `



#### 代码

##### Java

``` python
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int num = 0;
        while(x > num){
            num = num * 10 + x % 10;
            x/= 10;
        }
        return num == x || x == num / 10;
    }
}
```

