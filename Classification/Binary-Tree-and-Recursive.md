# Binary Tree and Recursive

## Contents

<!--ts-->
   * [Binary Tree and Recursive](#binary-tree-and-recursive)
      * [Contents](#contents)
      * [Key Concepts](#key-concepts)
      * [Binary Tree and Recursive Problems](#binary-tree-and-recursive-problems)
         * [Binary Tree Traversal](#binary-tree-traversal)
         * [Reconstruct Binary Tree](#reconstruct-binary-tree)
         * [Iterator Problems](#iterator-problems)
         * [判断树的形态](#\xE5\x88\xA4\xE6\x96\xAD\xE6\xA0\x91\xE7\x9A\x84\xE5\xBD\xA2\xE6\x80\x81)
         * [SubTree Problems](#subtree-problems)
         * [Path Problems](#path-problems)
         * [LCA Problems](#lca-problems)
         * [Others](#others)

<!-- Added by: weiyizhi, at: 2021年 5月13日 星期四 17时58分00秒 CST -->

<!--te-->

## Key Concepts

基本问题：

1. 理解二叉树、平衡二叉树、二叉搜索树的关系和概念。
2. 理解递归的概念和方法，递归三要素。
3. 在解决递归问题的时候，有时可以返回多个值（Python），或者用一个额外的class包装多个值（Java）。
4. 熟练掌握用递归和非递归的方式分别前序、中序、后序遍历二叉树的方法。
5. 理解掌握分治和遍历的区别和联系。
6. 理解掌握top-down, buttom-up的思路。
7. 理解掌握二叉树上的Iterator。



## Binary Tree and Recursive Problems

### Binary Tree Traversal

需要熟练掌握非递归方式

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|94|[Binary Tree Inorder Traversal](Solved/94-Binary-Tree-Inorder-Traversal/Binary-Tree-Inorder-Traversal.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|144||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|145||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|



### Reconstruct Binary Tree

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|105|[Construct Binary Tree from Preorder and Inorder Traversal](Solved/105-Construct-Binary-Tree-from-Preorder-and-Inorder-Traversal/Construct-Binary-Tree-from-Preorder-and-Inorder-Traversal.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|106|[Construct Binary Tree from Inorder and Postorder Traversal](Solved/106-Construct-Binary-Tree-from-Inorder-and-Postorder-Traversal/Construct-Binary-Tree-from-Inorder-and-Postorder-Traversal.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|889||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|




### Iterator Problems
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|173||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|230||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|285||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|270||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|272||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|510||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|



### 判断树的形态

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|98|[Validate Binary Search Tree](Solved/98-Validate-Binary-Search-Tree/Validate-Binary-Search-Tree.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|100|[Same Tree](Solved/100-Same-Tree/Same-Tree.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|101|[Symmetric Tree](Solved/101-Symmetric-Tree/Symmetric-Tree.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|110|[Balanced Binary Tree](Solved/110-Balanced-Binary-Tree/Balanced-Binary-Tree.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### SubTree Problems

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|111|[Minimum Depth of Binary Tree](Solved/111-Minimum-Depth-of-Binary-Tree/Minimum-Depth-of-Binary-Tree.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|104|[Maximum Depth of Binary Tree](Solved/104-Maximum-Depth-of-Binary-Tree/Maximum-Depth-of-Binary-Tree.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|333||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
Lint-596. Minimum Subtree
https://www.lintcode.com/problem/minimum-subtree/description
Lint-597. Subtree with Maximum Average
https://www.lintcode.com/problem...average/description



### Path Problems

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|112|[Path Sum](Solved/112-Path-Sum/Path-Sum.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|113|[Path Sum II](Solved/113-Path-Sum-II/Path-Sum-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|124|[Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum)|![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|298||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|549||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|

Lint-475. Binary Tree Maximum Path Sum II
https://www.lintcode.com/problem...-sum-ii/description

Lint-619. Binary Tree Longest Consecutive Sequence III
https://www.lintcode.com/problem...nce-iii/description


### LCA Problems

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|236||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|Lint-474| https://www.lintcode.com/problem/lowest-common-ancestor-ii/description |![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|Lint-578| https://www.lintcode.com/problem/lowest-common-ancestor-iii/solution |![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|


### Others

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|199||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|513||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|331||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|449||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|114|[Flatten Binary Tree to Linked List](Solved/114-Flatten-Binary-Tree-to-Linked-List/Flatten-Binary-Tree-to-Linked-List.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|