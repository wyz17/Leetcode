# Sliding Window



Source：[LeetCode大佬的post](https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems)



### Contents

<!--ts-->
   * [Backtracking](#backtracking)
         * [Contents](#contents)
      * [Combination Sum](#combination-sum)
         * [Solved](#solved)
         * [Code](#code)
      * [Combination Sum II](#combination-sum-ii)
      * [Palindrome Partitioning](#palindrome-partitioning)
      * [Permutations](#permutations)
      * [Permutations II](#permutations-ii)
      * [Subsets](#subsets)
      * [Subsets II](#subsets-ii)

<!-- Added by: weiyizhi, at: 2020年12月22日 星期二 19时57分06秒 CST -->

<!--te-->

## Template

### 思路



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




## Combination Sum

### Solved

[Combination Sum](../Solved/39-Combination-Sum/Combination-Sum.md)



### Code



## Combination Sum II



## Palindrome Partitioning



## Permutations



## Permutations II



## Subsets



## Subsets II

