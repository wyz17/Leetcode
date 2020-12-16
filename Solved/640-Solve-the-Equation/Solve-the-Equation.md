

# 640. Solve the Equation

### 题目

链接：https://leetcode.com/problems/solve-the-equation/

解一元一次方程组



### 思路 - 解析字符串

#### 步骤

- 先将一元一次方程组根据“=”划分为左边和右边
- 遍历字符串求出左边和右边的系数
- 左加右减求出结果
- 注意处理一下No solution和 Infinite solutions的情况

不难但很烦的题目



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public String solveEquation(String equation) {
        String before = equation.split("=")[0];
        String after = equation.split("=")[1];
        int[] left = getRes(before);
        int[] right = getRes(after);
        int num = right[1] - left[1];
        int x_times = left[0] - right[0];
        if(num == 0 && x_times == 0)
            return "Infinite solutions";
        if(num != 0 && x_times == 0)
            return "No solution";
        return "x=" + num/x_times;
    }
    
    public int[] getRes(String input){
        //int[0] x的系数
        //int[1] 常数项
        int x_times = 0;
        int num = 0;
        int start = 0;
        int end = 0;
        char flag = '+';
        if(input.charAt(0) == '-'){
            flag = '-';
            start = 1;
            end = 2;
        }
        while(end <= input.length()){
            while (end < input.length() && input.charAt(end) != '+' && input.charAt(end) != '-')
                end++; //防止第一位数是多位数
            String cur = input.substring(start, end);
            
            //是系数的情况
            if(cur.indexOf('x') != -1){
                String numString = cur.substring(0, cur.indexOf('x'));
                int tmp = 0;
                if(!numString.equals("")){
                    tmp = Integer.parseInt(numString);
                }
                else
                    tmp = 1;
                if(flag == '-')
                    x_times -= tmp;
                else
                    x_times += tmp;
            }
            
            //是常数的情况
            if(cur.indexOf('x') == -1){
                int tmp = 0;
                tmp = Integer.parseInt(cur);
                if(flag == '-')
                    num -= tmp;
                else
                    num += tmp;
            }
            
            if(end < input.length())
                flag = input.charAt(end);
            start = end + 1;
            end = start + 1;
        }
        return new int[]{x_times, num};
    }
}
```



##### Python

```python
class Solution:
    def solveEquation(self, equation: str) -> str:
        
        def getRes(string):
            start = 0
            end = 1
            times = 0
            num = 0
            flg = '+'
            
            if string[0] == '-':
                flg = '-'
                start = 1
                end = 2
                
            while end <= len(string):
                while end < len(string) and string[end] != '+' and string[end] != '-':
                    end = end + 1
                cur = string[start: end]
                print(flg)
                
                #判断系数
                if 'x' in cur:
                    numString = cur[0: cur.index('x')]
                    if len(numString) != 0:
                        tmp = int(numString)
                    else:
                        tmp = 1
                    if flg == '-':
                        times = times - tmp
                    else:
                        times = times + tmp
                
                #判断常数
                else:
                    tmp = int(cur)
                    if flg == '-':
                        num = num - tmp
                    else:
                        num = num + tmp
                if end < len(string):
                    flg = string[end]
                start = end + 1 
                end = start + 1
                
            return [times, num]
        
        left_res = equation.split('=')[0]
        right_res = equation.split('=')[1]
        left = getRes(left_res)
        right = getRes(right_res)
        times = left[0] - right[0]
        num = right[1] - left[1]
        if num == 0 and times == 0:
            return "Infinite solutions"
        if num != 0 and times == 0:
            return "No solution"
        return "x=" + str(int(num/times))
```


