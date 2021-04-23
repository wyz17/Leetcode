# 12. Integer To Roman

### 题目

链接：https://leetcode.com/problems/integer-to-roman/



### 思路

#### 步骤

- 判断num的最大可换算成罗马字符的值
- 循环减去该值，同时返回的字符串append

最开始的想法就是这个思路，没想到run一遍发现结果出乎意料的好——beats double 100%![image-20201008224118467](https://tva1.sinaimg.cn/large/008i3skNgy1gptvq5huc9j30x20rq0wa.jpg)

顺便吐槽一下这个难度不应该放med里...



#### 复杂度

时间：最低```O(1)```，最高```O(logn)```

空间：```O(1)```



#### 代码

##### Java

``` java
class Solution {
    public String intToRoman(int num) {
        StringBuffer res = new StringBuffer();
        while(num > 0){
            if(num >= 1000){
                res.append('M');
                num -= 1000;
                continue;
            }
            if(num >= 900){
                res.append("CM");
                num -= 900;
                continue;
            }
            if(num >= 500){
                res.append('D');
                num -= 500;
                continue;
            }
            if(num >= 400){
                res.append("CD");
                num -= 400;
                continue;
            }
            if(num >= 100){
                res.append('C');
                num -= 100;
                continue;
            }
            if(num >= 90){
                res.append("XC");
                num -= 90;
                continue;
            }
            if(num >= 50){
                res.append('L');
                num -= 50;
                continue;
            }
            if(num >= 40){
                res.append("XL");
                num -= 40;
                continue;
            }
            if(num >= 10){
                res.append('X');
                num -= 10;
                continue;
            }
            if(num >= 9){
                res.append("IX");
                num -= 9;
                continue;
            }
            if(num >= 5){
                res.append('V');
                num -= 5;
                continue;
            }
            if(num >= 4){
                res.append("IV");
                num -= 4;
                continue;
            }
            if(num >= 1){
                res.append('I');
                num -= 1;
                continue;
            }
        }
        return res.toString();
        
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

