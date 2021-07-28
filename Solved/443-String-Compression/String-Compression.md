# 443. String Compression

### 题目

- 链接：https://leetcode.com/problems/string-compression/
- 题意
  - 给出字符数组，连续的相同的字符作为一组
  - 返回分组的数组长度
  - 要求在原输入数组中进行修改



### 思路

#### 步骤

- 双指针：一个指针用来记录当前的index；一个指针用来记录需要更新数组的index
- 遍历数组，判断当前字符是否等于后一个字符，并且计算count
  - 等于的话continue，count++
  - 不等于的话就可以更新数组
    - 这里要注意，如果count是一次的话不需要更新数组
    - 如果count > 9的话是按照数组位数去存储，所以这里需要将count转换成字符串去更新



#### 复杂度

时间： `O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int compress(char[] chars) {
        int i = 0, update = 0;
        while(i < chars.length) {
            char cur = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == cur){
                i++;
                count++;
            }
            chars[update++] = cur;
            if(count != 1) {
                for(char c: Integer.toString(count).toCharArray()) {
                    chars[update++] = c;
                }
            }
        }
        return update;
    }
}
```



##### Python

```python
class Solution:
    def compress(self, chars: List[str]) -> int:
        i, update = 0, 0
        while i < len(chars):
            cur = chars[i]
            count = 0
            while i < len(chars) and chars[i] == cur:
                i += 1
                count += 1
            chars[update] = cur
            update += 1
            if count != 1:
                for c in str(count):
                    chars[update] = c   
                    update += 1
        return update
```