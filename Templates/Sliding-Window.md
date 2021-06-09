# Sliding Window



Source：[LeetCode大佬的post](https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems)



### Contents

<!--ts-->
   * [Sliding Window](#sliding-window)
         * [Contents](#contents)
      * [Template](#template)
         * [思路](#\xE6\x80\x9D\xE8\xB7\xAF)
         * [Code](#code)
      * [Combination Sum](#combination-sum)
         * [Solved](#solved)
         * [Code](#code-1)
      * [Combination Sum II](#combination-sum-ii)
      * [Palindrome Partitioning](#palindrome-partitioning)
      * [Permutations](#permutations)
      * [Permutations II](#permutations-ii)
      * [Subsets](#subsets)
      * [Subsets II](#subsets-ii)

<!-- Added by: weiyizhi, at: 2021年 5月13日 星期四 17时58分07秒 CST -->

<!--te-->

## Template

### 思路

- 用i, j表示滑动窗口的左边界和右边界，通过改变i, j来扩展和收缩滑动窗口，可以想象成一个窗口在字符串上游走，当这个窗口包含的元素满足条件，即包含字符串T的所有元素，记录下这个滑动窗口的长度j-i+1，这些长度中的最小值就是要求的结果。
  - 不断增加j使滑动窗口增大，直到窗口包含了T的所有元素
  - 不断增加i使滑动窗口缩小，因为是要求最小字串，所以将不必要的元素排除在外，使长度减小，直到碰到一个必须包含的元素，这个时候不能再扔了，再扔就不满足条件了，记录此时滑动窗口的长度，并保存最小值
  - 让i再增加一个位置，这个时候滑动窗口肯定不满足条件了，那么继续从步骤一开始执行，寻找新的满足条件的滑动窗口，如此反复，直到j超出了字符串S范围。




### Code

```java
class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];        
        int left = 0, right = 0, valid = 0; // check whether the substring is valid
      //two pointers, one point to tail and one  head
        
        for(char c : t.toCharArray()) {
          /* initialize the hash map here */ 
        }
        
        //return value
        int end = s.length() + 1;
        int start = 0;
        
        while(right < s.length()) {
            int r = s.charAt(right) - 'A';
            right++;
            if(need[r] != 0) {
                /* modify counter here */ 
            }
            while(/* counter condition */) { 
                /* update d here if finding minimum*/

                //increase begin to make it invalid/valid again
              
                if(need[l] != 0) {
                    /*modify counter here*/
                }
                left++;
            }
           /* update d here if finding maximum*/
        }
        return custom;
    }
}
```


