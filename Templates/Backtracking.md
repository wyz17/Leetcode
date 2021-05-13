# Backtracking



Source：[LeetCode大佬的post](https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning))



### Contents

<!--ts-->
   * [Backtracking](#backtracking)
         * [Contents](#contents)
      * [Code](#code)
      * [Complexity](#complexity)
      * [Problems](#problems)
         * [Combination Sum](#combination-sum)
         * [Combination Sum II](#combination-sum-ii)
         * [Palindrome Partitioning](#palindrome-partitioning)
         * [Permutations](#permutations)
         * [Permutations II](#permutations-ii)
         * [Subsets](#subsets)
         * [Subsets II](#subsets-ii)
      * [DFS &amp; Backtracking](#dfs--backtracking)

<!-- Added by: weiyizhi, at: 2021年 5月13日 星期四 17时58分07秒 CST -->

<!--te-->



## Code

## Complexity

## Problems

### Combination Sum

[Combination Sum](../Solved/39-Combination-Sum/Combination-Sum.md)



### Combination Sum II



### Palindrome Partitioning



### Permutations



### Permutations II



### Subsets



### Subsets II



## DFS & Backtracking

| -                | DFS                                                          | Backtracking                                                 |
| ---------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Target Structure | Actual Tree/Graph Structure                                  | Any type of structure where portions of the domain can be eliminated (Chess Board, matrix, implicit tree) |
| Definition       | A specific form of backtracking related to searching tree/graph structures | Traverse from the end and prune unacceptable cases           |
| Start-At Point   | Root of the Tree                                             | End of the Goal                                              |
| Moving Direction | From the root to each branch                                 | From the end moving backwards                                |