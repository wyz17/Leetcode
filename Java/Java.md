# Notes for Java

刷lc时查的内容 & 知识点记录



## Contents

<!--ts-->
   * [Notes for Java](#notes-for-java)
      * [Contents](#contents)
      * [Data Structure](#data-structure)
      * [Others](#others)
         * [溢出处理](#\xE6\xBA\xA2\xE5\x87\xBA\xE5\xA4\x84\xE7\x90\x86)
         * [判断int整型溢出处理](#\xE5\x88\xA4\xE6\x96\xADint\xE6\x95\xB4\xE5\x9E\x8B\xE6\xBA\xA2\xE5\x87\xBA\xE5\xA4\x84\xE7\x90\x86)
         * [判断字符是否是数字的方法](#\xE5\x88\xA4\xE6\x96\xAD\xE5\xAD\x97\xE7\xAC\xA6\xE6\x98\xAF\xE5\x90\xA6\xE6\x98\xAF\xE6\x95\xB0\xE5\xAD\x97\xE7\x9A\x84\xE6\x96\xB9\xE6\xB3\x95)
         * [相似问题返回正负的处理方法](#\xE7\x9B\xB8\xE4\xBC\xBC\xE9\x97\xAE\xE9\xA2\x98\xE8\xBF\x94\xE5\x9B\x9E\xE6\xAD\xA3\xE8\xB4\x9F\xE7\x9A\x84\xE5\xA4\x84\xE7\x90\x86\xE6\x96\xB9\xE6\xB3\x95)
         * [一行新建list的方法](#\xE4\xB8\x80\xE8\xA1\x8C\xE6\x96\xB0\xE5\xBB\xBAlist\xE7\x9A\x84\xE6\x96\xB9\xE6\xB3\x95)

<!-- Added by: weiyizhi, at: 2020年12月12日 星期六 16时19分04秒 CST -->

<!--te-->


## Data Structure

### HashMap

- get()：指定键映射到的值，如果此映射不包含键的映射，则为NULL。
- put()：当存在这个key的时候,会覆盖掉原来的value并返回oldvalue,也就是旧值。

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

- **Arrays.asList()**


```java
res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
```



### 二分查找不要直接用（ low + high）/ 2

- 用这个

  ```java
  int mid = left + (right - left) / 2;
  ```

- 避免溢出

