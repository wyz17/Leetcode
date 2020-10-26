# 7. Reverse Integer

### 题目

链接：https://leetcode.com/problems/reverse-integer/



### 思路1 - str翻转

#### 步骤

- 利用String



#### 复杂度

时间：```O(n)```

空间：```O(1)```



效率低，pass



### 思路2 - 利用位翻转

#### 步骤

- 循环步骤：
  - 求余10，res加上再乘10



#### 代码

##### Java

``` java
class Solution {
    public int reverse(int x) {
        int res = 0;
        boolean flg = true;
        if(x < 0){
            flg = false;
            x = -x;
        }
        
        int oldres = 0;
        while(x > 0){
            int bit = x % 10;
            oldres = res;
            res = res * 10 + bit;
            x /= 10;
            //溢出处理
            if(oldres != (res - bit)/10)
                return 0;
        }
        return flg == true ? res : -res;
    }
}
```



#### 复杂度

时间：```O(log(x))```

空间：```O(1)```



# Java Tips

- 注意溢出处理校验方式，new_res/10 != old_res时则说明有溢出





