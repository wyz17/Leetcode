

# 345. Reverse Vowels of a String

### 题目

链接：https://leetcode.com/problems/reverse-vowels-of-a-string/



### 思路 - Two Pointer

#### 步骤

- 只翻转vowels：可以写个方法判断是不是元音



#### 复杂度

时间： `O(n)`

空间：` O(n)`

#### 代码

##### Java

```java
class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(!isVowel(chars[left]) && !isVowel(chars[right])) {
                left++;
                right--;
            } else if(!isVowel(chars[left])) {
                left++;
            } else if(!isVowel(chars[right])) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
        
    }
    
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
```



##### Python

```python
class Solution:
    def reverseVowels(self, s: str) -> str:
        s = list(s)
        vows = "aeiouAEIOU"
        l, r = 0, len(s) - 1
        while l <= r:
            while l <= r and s[l] not in vows: l += 1
            while l <= r and s[r] not in vows: r -= 1
            if l > r: break
            s[l], s[r] = s[r], s[l]
            l, r = l + 1, r - 1
        return ''.join(s)
```

