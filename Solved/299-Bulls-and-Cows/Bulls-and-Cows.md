

# 299. Bulls and Cows

### 题目

链接：https://leetcode.com/problems/bulls-and-cows/



### 思路

#### 步骤

- 题目中Bulls代表 secret和guess中 位置 & 数字都一样的数
- 题目中Cows代表 secret和guess中 位置不一样 & 数字一样的数
- Bulls判断：遍历guess和secret判断是否相等就好了
- Cows判断
  - 这里采用一个常量数组来记录数字的次数
  - 如果secret中出现了，对应的index就++；如果guess中出现了，对应的index就--
  - 当在判断secret之前，数组对应值小于0时，说明guess中出现了这个数，cows++	
  - 当在判断guess之前，数组对应值大于0时，说明secret中出现了这个数，cows++
  - 最后返回字符串



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (nums[secret.charAt(i) - '0']++ < 0) cows++;
                if (nums[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
```



##### Python

```python
class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        bulls = cows = 0
        nums = [0] * 10
        for i in range(0, len(secret)):
            if secret[i] == guess[i]:
                bulls += 1
            else:
                nums[int(secret[i])] += 1
                if nums[int(secret[i])] <= 0:
                    cows += 1
                nums[int(guess[i])] -= 1
                if nums[int(guess[i])] >= 0:
                    cows += 1
        return str(bulls) + 'A' + str(cows) + 'B'
```


