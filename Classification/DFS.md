# Depth First Search

## Contents

<!--ts-->
   * [Depth First Search](#depth-first-search)
      * [Contents](#contents)
      * [Key Concepts](#key-concepts)
      * [Depth First Search Problems](#depth-first-search-problems)
         * [Combination](#combination)
         * [Binary Tree](#binary-tree)
         * [Graph](#graph)

<!-- Added by: weiyizhi, at: Thu Jun 24 20:24:45 CST 2021 -->

<!--te-->

## Key Concepts

基本问题：

1. DFS中递归的基本要素
2. 终止条件的选择；回溯；剪枝
3. 什么时候需要排序？
   - 集合中存在**重复元素**的时候需要排序
4. 如何去除重复元素？一个元素允许使用多次的情况？
5. 在图上进行DFS如何避免回到重复节点
6. 识别一个隐式图，并使用DFS
7. 在某些情况下，利用记忆化搜索进行优化



## Depth First Search Problems

### Combination

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|39|[Combination Sum](../Solved/39-Combination-Sum/Combination-Sum.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|40|[Combination Sum II](../Solved/40-Combination-Sum-II/Combination-Sum-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|46|[Permutations](../Solved/46-Permutations/Permutations.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|47|[Permutations II](../Solved/47-Permutations-II/Permutations-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|77|[Combinations](../Solved/77-Combinations/Combinations.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|78|[Subsets](../Solved/78-Subsets/Subsets.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|90|[Subsets II](../Solved/90-Subsets-II/Subsets-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|17| [Letter Combinations of a Phone Number](../Solved/17-Letter-Combinations-of-a-Phone-Number/Letter-Combinations-of-a-Phone-Number.md) |![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |:star::star::star:|
|22| [Generate Parentheses](../Solved/22-Generate-Parentheses/Generate-Parentheses.md) |![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |:star::star::star:|
|51| [N-Queens](../Solved/51-N-Queens/N-Queens.md) |![](https://img.shields.io/badge/-Hard-red.svg) |:star::star::star:|
|254| **Subscribe to unlock** |![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |:star::star::star:|
|301| [Remove Invalid Parentheses](../Solved/301-Remove-Invalid-Parentheses/Remove-Invalid-Parentheses.md) |![](https://img.shields.io/badge/-Hard-red.svg) |:star::star::star:|
|491| [Increasing Subsequences](../Solved/491-Increasing-Subsequences/Increasing-Subsequences.md) |![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |:star::star::star:|
|37|[Sudoku Solver](../Solved/37-Sudoku-Solver/Sudoku-Solver.md)|![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|52|[N-Queens II](Solved/52-N-Queens-II/N-Queens-II.md)|![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|93|[Restore IP Addresses](../Solved/93-Restore-IP-Addresses/Restore-IP-Addresses.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|131|[Palindrome Partitioning](../Solved/131-Palindrome-Partitioning/Palindrome-Partitioning.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|Lint-10||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|Lint-570||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|Lint-680||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|



### Binary Tree

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|113|[Path Sum II](../Solved/113-Path-Sum-II/Path-Sum-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|257|[Binary Tree Paths](../Solved/257-Binary-Tree-Paths/Binary-Tree-Paths.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|Lint-246||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|Lint-376||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|Lint-472||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|



### Graph
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|140||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|494||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|1192||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|126||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|290||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|291||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|



