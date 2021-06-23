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
|297|[Serialize and Deserialize Binary Tree](../Solved/297-Serialize-and-Deserialize-Binary-Tree/Serialize-and-Deserialize-Binary-Tree.md)|![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star::star:|
|102|[Binary Tree Level Order Traversal](../Solved/102-Binary-Tree-Level-Order-Traversal/Binary-Tree-Level-Order-Traversal.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|103|[Binary Tree Zigzag Level Order Traversal](../Solved/103-Binary-Tree-Zigzag-Level-Order-Traversal/Binary-Tree-Zigzag-Level-Order-Traversal.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|107|[Binary Tree Level Order Traversal II](../Solved/107-Binary-Tree-Level-Order-Traversal-II/Binary-Tree-Level-Order-Traversal-II.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|513|[Find Bottom Left Tree Value](../Solved/513-Find-Bottom-Left-Tree-Value/Find-Bottom-Left-Tree-Value.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|  Lint-242  |https://www.lintcode.com/problem/242/|  ![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### Topological Sorting（拓扑排序）

拓扑排序：当做一件事情时必须先做某一件事，这样就有了事情实行的先后顺序。比如任务的先后，穿衣服的先后，课程学习的先后等等，为这些先后进行排序就是拓扑排序

BFS实现方法：

- 首先将入度为0的点插入队列中（因为入度为0，没有结点是它的父结点，也就是说没有结点要比它先完成，所以它的顺序一定是第一个）
- 再将队列队头结点取出并出队
- 找到此结点的邻接结点，将这些邻接结点的入度减一
- 如果减一后有结点入度为0，继续插入队列中…….依次往下



| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|  Lint-127  |[Topological Sorting](../Solved/Lint127-Topological-Sorting/Topological-Sorting.md)|  ![](https://img.shields.io/badge/-Medium-%23FFA500.svg)  | :star::star::star::star: |
|  207  | [Course Schedule](../Solved/207-Course-Schedule/Course-Schedule.md) | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |    :star::star::star:    |
|  210  | [Course Schedule II](Solved/210-Course-Schedule-II/Course-Schedule-II.md) | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |    :star::star::star:    |
| 269 | **Subscribe to unlock** | ![](https://img.shields.io/badge/-Hard-red.svg) |    :star::star::star:    |
| 444 | **Subscribe to unlock** | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |       :star::star:       |



### Matrix
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|200|[Number of Islands](../Solved/200-Number-of-Islands/Number-of-Islands.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|490|**Subscribe to unlock**|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|505|**Subscribe to unlock**|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|542|[01 Matrix](../Solved/542-01-Matrix/01-Matrix.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
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

