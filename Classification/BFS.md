# Breath First Search

## Contents

<!--ts-->
   * [Breath First Search](#breath-first-search)
      * [Contents](#contents)
      * [Key Concepts](#key-concepts)
      * [Breath First Search Problems](#breath-first-search-problems)
         * [Binary Tree](#binary-tree)
         * [拓扑排序](#\xE6\x8B\x93\xE6\x89\x91\xE6\x8E\x92\xE5\xBA\x8F)
         * [Matrix](#matrix)
         * [Graph](#graph)

<!-- Added by: weiyizhi, at: 2021年 5月13日 星期四 17时57分59秒 CST -->

<!--te-->

## Key Concepts

基本问题：

1. 如果复杂程度类似， 面试中尽量优先使用BFS
2. BFS主要几种场景： 层级遍历，拓扑排序，图上搜索（包括二叉树，矩阵）
3. Queue的使用技巧，BFS的终止条件？
4. 什么时候使用分层？什么时候不需要？实现的时候的区别在哪里？
5. 拓扑排序的概念？如何判断是否存在拓扑排序？是否存在唯一的拓扑排序？找到所有拓扑排序？
6. 什么时候需要使用set记录访问过的节点？（为什么二叉树上的BFS往往不需要set？）什么时候需要map记录到达过的节点距离？
7. 如何在矩阵中遍历下一步的所有节点？如果每次可能走不止一步怎么办（Maze II）？
8. 为什么BFS解决的基本都是简单图（边长为1）问题？如果边长不为1，该怎么办？
9. BFS的时空复杂度估算？
10. 如何使用双向BFS进行优化？



## Breath First Search Problems

### Binary Tree

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|297||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|102|[Binary Tree Level Order Traversal](Solved/102-Binary-Tree-Level-Order-Traversal/Binary-Tree-Level-Order-Traversal.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|103|[Binary Tree Zigzag Level Order Traversal](Solved/103-Binary-Tree-Zigzag-Level-Order-Traversal/Binary-Tree-Zigzag-Level-Order-Traversal.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|107|[Binary Tree Level Order Traversal II](Solved/107-Binary-Tree-Level-Order-Traversal-II/Binary-Tree-Level-Order-Traversal-II.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|513||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|



### 拓扑排序

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|  Lint-127  |https://www.lintcode.com/problem/topological-sorting/description|  ![](https://img.shields.io/badge/-Easy-%235cb85c.svg)  | :star::star::star::star: |
|  207  |           | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |    :star::star::star:    |
|  210  |           | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |    :star::star::star:    |
| 269 |           | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |    :star::star::star:    |
| 444 |           | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |       :star::star:       |



### Matrix
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|200||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|490||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|505||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|542||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|733||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|994||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|305||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|773||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|



### Graph

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|133||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|127||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|261||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|841||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|323||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|1306||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
