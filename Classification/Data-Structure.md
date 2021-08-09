# Data Structure

## Contents

<!--ts-->
   * [Data Structure](#data-structure)
      * [Contents](#contents)
      * [Key Concepts](#key-concepts)
      * [Data Structure Problems](#data-structure-problems)
         * [Array &amp; Matrix](#array--matrix)
         * [String](#string)
         * [Linked List](#linked-list)
         * [Hash](#hash)
         * [Heap](#heap)
         * [Stack](#stack)
         * [Monotonic Stack](#monotonic-stack)
         * [Trie](#trie)
         * [Union Find](#union-find)
         * [Sweep Line](#sweep-line)
         * [Binary Index Tree &amp; Segment Tree](#binary-index-tree--segment-tree)
         * [Complex Data Structure](#complex-data-structure)

<!-- Added by: weiyizhi, at: Thu Jun 24 20:24:44 CST 2021 -->

<!--te-->

## Key Concepts

1. 本章按照数据结构分类一些问题，和之前按算法分类的题目相比可能会有重复，因为一道题可能有多个标签
2. 对于每种数据结构，需要先学习掌握其基本原理，优缺点，复杂度，和对应语言中的API用法。对于其基本的实现方式也要了解。
3.  Array，Matrix，String，Hash都是一些常用的数据结构，一般在各种题里都会用到，这里主要列举一些没有涉及到其他算法的题目。
4. Linked List往往自成一类，会涉及到一些pointer操作，需要细心。
5. Queue一般用在BFS里面比较多，这里不单独列举了。
6. Heap， Stack往往和其他知识点混用，但自己单独出题也可以。
7. Trie，Union Find， Sweep Line的套路比较明显，需要记住模板。
8. Binary Index Tree 和Segment Tree涉及到的题目有限，需要记住模板。Segment Tree解法一般来说可以覆盖BIT能解决的问题，但是BIT写起来短一些。
9. 复合数据结构里面LRU和LFU相对比较重要。其他的在掌握基本数据结构即复杂度之后，可以随机应变。



## Data Structure Problems

### Array & Matrix

- 题目中要求空间复杂度的都可以在原数组上进行修改
- 一些方法
  - 289 - 多设置状态码：题中只有0/1，新增至0/1/2/3
  - 442 - 将 nums[i] 的值作为新的index去搜索，并且将访问过的 nums[i] 置为负数

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|442|[Find All Duplicates in an Array](../Solved/442-Find-All-Duplicates-in-an-Array/Find-All-Duplicates-in-an-Array.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|48|[Rotate Image](../Solved/48-Rotate-Image/Rotate-Image.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|54|[Spiral Matrix](../Solved/54-Spiral-Matrix/Spiral-Matrix.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|73|[Set Matrix Zeroes](../Solved/73-Set-Matrix-Zeroes/Set-Matrix-Zeroes.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|289|[Game of Life](../Solved/289-Game-of-Life/Game-of-Life.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|



### String

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|6|[ZigZag Conversion](../Solved/6-ZigZag-Conversion/ZigZag-Conversion.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|13|[Roman To Integer](../Solved/13-Roman-To-Integer/Roman-To-Integer.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|14|[Longest Common Prefix](../Solved/14-Longest-Common-Prefix/Longest-Common-Prefix.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|68|                                                              |![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|443| [String Compression](../Solved/443-String-Compression/String-Compression.md) |![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|



### Linked List
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|2|[Add Two Numbers](../Solved/2-Add-Two-Numbers/Add-Two-Numbers.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|21|[Merge Two Sorted Lists](../Solved/21-Merge-Two-Sorted-Lists/Merge-Two-Sorted-Lists.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)   |:star::star::star::star:|
|25||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|82|[Remove Duplicates from Sorted List II](../Solved/82-Remove-Duplicates-from-Sorted-List-II/Remove-Duplicates-from-Sorted-List-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|83|[Remove Duplicates from Sorted List](../Solved/83-Remove-Duplicates-from-Sorted-List/Remove-Duplicates-from-Sorted-List.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|86|[Partition List](../Solved/86-Partition-List/Partition-List.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|92|[Reverse LinkedList II](../Solved/92-Reverse-Linked-List-II/Reverse-Linked-List-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|138|[Copy List with Random Pointer](../Solved/138-Copy-List-with-Random-Pointer/Copy-List-with-Random-Pointer.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|141|[Linked List Cycle](../Solved/141-Linked-List-Cycle/Linked-List-Cycle.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|148||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|160|[Intersection of Two Linked Lists](../Solved/160-Intersection-of-Two-Linked-Lists/Intersection-of-Two-Linked-Lists.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|203|[Remove Linked List Elements](../Solved/203-Remove-Linked-List-Elements/Remove-Linked-List-Elements.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|206|[Reverse Linked List](../Solved/206-Reverse-Linked-List/Reverse-Linked-List.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|234|[Palindrome Linked List](../Solved/234-Palindrome-Linked-List/Palindrome-Linked-List.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|328|[Odd Even Linked List](../Solved/328-Odd-Even-Linked-List/Odd-Even-Linked-List.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|445|[Add Two Numbers II](../Solved/445-Add-Two-Numbers-II/Add-Two-Numbers-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|142|[Linked List Cycle II](../Solved/142-Linked-List-Cycle-II/Linked-List-Cycle-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|876|[Middle of the Linked List](../Solved/876-Middle-of-the-Linked-List/Middle-of-the-Linked-List.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### Hash
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|706|[Design HashMap](../Solved/706-Design-HashMap/Design-HashMap.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|49|[Group Anagrams](Solved/49-Group-Anagrams/Group-Anagrams.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|128||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|560|[Subarray Sum Equals K](../Solved/560-Subarray-Sum-Equals-K/Subarray-Sum-Equals-K.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|953|[Verifying an Alien Dictionary](../Solved/953-Verifying-an-Alien-Dictionary/Verifying-an-Alien-Dictionary.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|290|[Word Pattern](../Solved/290-Word-Pattern/Word-Pattern.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### Heap
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|23||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star::star:|
|295||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|347|[Top K Frequent Elements](../Solved/347-Top-K-Frequent-Elements/Top-K-Frequent-Elements.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|692|[Top K Frequent Words](../Solved/692-Top-K-Frequent-Words/Top-K-Frequent-Words.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|767|[Reorganize String](../Solved/767-Reorganize-String/Reorganize-String.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|973|[K Closest Points to Origin](../Solved/973-K-Closest-Points-to-Origin/K-Closest-Points-to-Origin.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|480||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|703|[Kth Largest Element in a Stream](../Solved/703-Kth-Largest-Element-in-a-Stream/Kth-Largest-Element-in-a-Stream.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### Stack
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|155|[Min Stack](../Solved/155-Min-Stack/Min-Stack.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|20|[Valid Parentheses](Solved/20-Valid-Parentheses/Valid-Parentheses.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|85||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|224|[Basic Calculator](../Solved/224-Basic-Calculator/Basic-Calculator.md)|![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|227|[Basic Calculator II](../Solved/227-Basic-Calculator-II/Basic-Calculator-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|394|[Decode String](../Solved/394-Decode-String/Decode-String.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|1249|[Minimum Remove to Make Valid Parentheses](../Solved/1249-Minimum-Remove-to-Make-Valid-Parentheses/Minimum-Remove-to-Make-Valid-Parentheses.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|



### Monotonic Stack
| No | Solutions | Difficulity | Priority |
| :--: | :-----: | :---------: | :------: |
|300||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|84||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|239||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|1019||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|



### Trie
| No | Solutions | Difficulity | Priority |
| :--: | :-----: | :---------: | :------: |
|208||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|211||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|1032||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|



### Union Find
| No | Solutions | Difficulity | Priority |
| :--: | :-----: | :---------: | :------: |
|200||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|305||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|323||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|



### Sweep Line
| No | Solutions | Difficulity | Priority |
| :--: | :-----: | :---------: | :------: |
|Lint-391| https://www.lintcode.com/problem...the-sky/description |![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|252||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|253||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|



### Binary Index Tree & Segment Tree

| No | Solutions | Difficulity | Priority |
| :--: | :-----: | :---------: | :------: |
|307||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|327||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|715||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|315||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|493||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|



### Complex Data Structure

| No | Solutions | Difficulity | Priority |
| :--: | :-----: | :---------: | :------: |
|146||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|460||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|211||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|380||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|528||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|588||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|981||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|1396||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|