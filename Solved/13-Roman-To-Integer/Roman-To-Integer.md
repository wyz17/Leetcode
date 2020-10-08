# 13. Roman to Integer

### 题目

链接：https://leetcode.com/problems/roman-to-integer/



### 思路1

#### 步骤

- 遍历字符串，判断对应数字
- 涉及到4/9的多判断一位



#### 复杂度

时间：```O(n)```

空间：```O(1)```



#### 代码

#### Java

``` java
class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i <= s.length() - 1; i++){
            if(s.charAt(i) == 'M'){
                res += 1000;
                continue;
            }
            if(i < s.length() -1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M'){
                i++;
                res += 900;
                continue;
            }
            if(s.charAt(i) == 'D'){
                res += 500;
                continue;
            }
            if(i < s.length() - 1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D'){
                res += 400;
                i++;
                continue;
            }
            if(s.charAt(i) == 'C'){
                res += 100;
                continue;
            }
            if(i < s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C'){
                i++;
                res += 90;
                continue;
            }
            if(s.charAt(i) == 'L'){
                res += 50;
                continue;
            }
            if(i < s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L'){
                i++;
                res += 40;
                continue;
            }
            if(s.charAt(i) == 'X'){
                res += 10;
                continue;
            }
            if(i < s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X'){
                i++;
                res += 9;
                continue;
            }
            if(s.charAt(i) == 'V'){
                res += 5;
                continue;
            }
            if(i < s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V'){
                i++;
                res += 4;
                continue;
            }
            if(s.charAt(i) == 'I'){
                res += 1;
                continue;
            }
        }
        return res;
    }
}
```



简化版代码

````java
class Solution {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < values.length; i++){
            while(num >= values[i]){
                num = num - values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
````



### 思路2

#### 步骤

- 遍历字符串，存到对应数组中
- 如果出现前面的小于后面的，则相减



#### 复杂度

时间：```O(n)```

空间：```O(n)```



#### 代码

#### Java

```java
public int romanToInt(String s) {
    int nums[]=new int[s.length()];
    for(int i=0;i<s.length();i++){
        switch (s.charAt(i)){
            case 'M':
                nums[i]=1000;
                break;
            case 'D':
                nums[i]=500;
                break;
            case 'C':
                nums[i]=100;
                break;
            case 'L':
                nums[i]=50;
                break;
            case 'X' :
                nums[i]=10;
                break;
            case 'V':
                nums[i]=5;
                break;
            case 'I':
                nums[i]=1;
                break;
        }
    }
    int sum=0;
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]<nums[i+1])
            sum-=nums[i];
        else
            sum+=nums[i];
    }
    return sum+nums[nums.length-1];
}
```



#### 类似思路的Python代码：

```python
class Solution:
# @param {string} s
# @return {integer}
def romanToInt(self, s):
    roman = {'M': 1000,'D': 500 ,'C': 100,'L': 50,'X': 10,'V': 5,'I': 1}
    z = 0
    for i in range(0, len(s) - 1):
        if roman[s[i]] < roman[s[i+1]]:
            z -= roman[s[i]]
        else:
            z += roman[s[i]]
    return z + roman[s[-1]]
```



### 思路3

#### 步骤

- replace 4/9
- 遍历求和



#### 代码

#### Python

```python
class Solution:
    def romanToInt(self, s: str) -> int:
        translations = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000
        }
        number = 0
        s = s.replace("IV", "IIII").replace("IX", "VIIII")
        s = s.replace("XL", "XXXX").replace("XC", "LXXXX")
        s = s.replace("CD", "CCCC").replace("CM", "DCCCC")
        for char in s:
            number += translations[char]
        return number
```