# Notes for Java

刷lc时查的内容 & 知识点记录



## Contents

[TOC] 



## Data Structure



## Others

### 溢出处理

注意溢出处理校验方式，new_res/10 != old_res时则说明有溢出



### 判断int整型溢出处理

- **if(res >= (Integer.MAX_VALUE / 10))**
- 在这道题中的判断：
  - **if(res > Integer.MAX\_VALUE / 10 || (res == Integer.MAX\_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX\_VALUE % 10))**



### 判断字符是否是数字的方法

- **Character.isDigit('c')**

```java
public class Test {

    public static void main(String args[]) {
        System.out.println(Character.isDigit('c'));
        System.out.println(Character.isDigit('5'));
    }
}
```



### 相似问题返回正负的处理方法

- 可以用一个 **int flg = 1 / -1** 来表示
- 最后的返回值是 **flg * res** 就好（boolean没有int方便）



### 一行新建list的方法

**Arrays.asList()**

```java
res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
```

