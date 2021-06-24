# Multi-Pointer

## Contents

<!--ts-->
   * [Multi-Pointer](#multi-pointer)
      * [Contents](#contents)
      * [Key Concepts](#key-concepts)
      * [Multi-Pointer Problems](#multi-pointer-problems)
         * [Array](#array)
         * [LinkedList](#linkedlist)
         * [Intervals](#intervals)
         * [Palindrome](#palindrome)
         * [Sliding Window](#sliding-window)
         * [Stream](#stream)
         * [前项和](#前项和)
         * [Sum](#sum)

<!-- Added by: weiyizhi, at: Thu Jun 24 20:27:24 CST 2021 -->

<!--te-->

## Key Concepts

基本问题：

1. 多指针是一个非常广泛的概念，并不是一个固定的算法。但基本上是通过一些变量的控制与循环把问题的复杂度控制在一两层for循环之内。可以用在数组、链表、区间、滑动窗口、流、回文串、和差问题等多个场景（前项和其实并不完全是指针问题，但也归并在这里）

2. Quick Sort和Merge Sort的基本原理与实现，排序的稳定性问题

   - Quick Sort

     - 基本原理：It picks an element as pivot and partitions the given array around the picked pivot. 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据比另一部分的所有数据要小，再按这种方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，使整个数据变成有序序列
   - 代码：[Sort an Array](../Solved/912-Sort-an-Array/Sort-an-Array.md)
   - Merge Sort
   
3. Quick Select的实现与复杂度

4. 同向指针与相向指针的使用场景

5. 不同场景下循环终止条件？

6. 两数之和，之差，特定条件下（大小于某值等）的计数问题

7. 三数或三数以上之和的通用写法（两数之和+搜索）

8. 数组有没有排序？是否需要排序？

9. 数组有没有去重？是否需要去重？

10. 离线数据（内存中，有限长）还是在线数据（无法放入内存，长度未知）？

11. 链表操作中dummy node与previous node的使用技巧

12. 链表的中点，判断是否有环，寻找环的交叉点



## Multi-Pointer Problems

### Array

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|912|[Sort an Array](../Solved/912-Sort-an-Array/Sort-an-Array.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|  75  |[Sort Colors](../Solved/75-Sort-Colors/Sort-Colors.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|26|[Remove Duplicates from Sorted Array](../Solved/26-Remove-Duplicates-from-Sorted-Array/Remove-Duplicates-from-Sorted-Array.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|80|[Remove Duplicates from Sorted Array II](../Solved/80-Remove-Duplicates-from-Sorted-Array-II/Remove-Duplicates-from-Sorted-Array-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|88|[Merge Sorted Array](../Solved/88-Merge-Sorted-Array/Merge-Sorted-Array.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|283|[Move Zeroes](../Solved/283-Move-Zeroes/Move-Zeroes.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|215|[Kth Largest Element in an Array](../Solved/215-Kth-Largest-Element-in-an-Array/Kth-Largest-Element-in-an-Array.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|347||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|349||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|350||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|845||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|42||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|43|[Multiply Strings](../Solved/43-Multiply-Strings/Multiply-Strings.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|969||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|



### LinkedList

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|21|[Merge Two Sorted Lists](../Solved/21-Merge-Two-Sorted-Lists/Merge-Two-Sorted-Lists.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|86|[Partition List](../Solved/86-Partition-List/Partition-List.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|141|[Linked List Cycle](../Solved/141-Linked-List-Cycle/Linked-List-Cycle.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|160|[Intersection of Two Linked Lists](../Solved/160-Intersection-of-Two-Linked-Lists/Intersection-of-Two-Linked-Lists.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|234|[Palindrome Linked List](../Solved/234-Palindrome-Linked-List/Palindrome-Linked-List.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|328|[Odd Even Linked List](../Solved/328-Odd-Even-Linked-List/Odd-Even-Linked-List.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|142|[Linked List Cycle II](../Solved/142-Linked-List-Cycle-II/Linked-List-Cycle-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|287|[Find the Duplicate Number](../Solved/287-Find-the-Duplicate-Number/Find-the-Duplicate-Number.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|876|[Middle of the Linked List](../Solved/876-Middle-of-the-Linked-List/Middle-of-the-Linked-List.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### Intervals
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|Lint-391|[Number of Airplanes in the Sky](https://www.lintcode.com/problem ... the-sky/description)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|56|[Merge Intervals](../Solved/56-Merge-Intervals/Merge-Intervals.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|57|[Insert Intervals](../Solved/57-Insert-Intervals/Insert-Intervals.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|252|**Subscribe to unlock**|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|253|**Subscribe to unlock**|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|986||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|



### Palindrome
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|5|[Longest Palindromic Substring](../Solved/5-Longest-Palindromic-Substring/Longest-Palindromic-Substring.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|345|[Reverse Vowels of a String](../Solved/345-Reverse-Vowels-of-a-String/Reverse-Vowels-of-a-String.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|680|[Valid Palindrome II](../Solved/680-Valid-Palindrome-II/Valid-Palindrome-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|125|[Valid Palindrome](../Solved/125-Valid-Palindrome/Valid-Palindrome.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### Sliding Window

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|3|[Longest Substring Without Repeating Characters](../Solved/3-Longest-Substring-Without-Repeating-Characters/Longest-Substring-Without-Repeating-Characters.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|11|[Container With Most Water](../Solved/11-Container-With-Most-Water/Container-With-Most-Water.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|76|[Minimum Window Substring](../Solved/76-Minimum-Window-Substring/Minimum-Window-Substring.md)|![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|209|[Minimum Size Subarray Sum](../Solved/209-Minimum-Size-Subarray-Sum/Minimum-Size-Subarray-Sum.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|239|[Sliding Window Maximum](../Solved/239-Sliding-Window-Maximum/Sliding-Window-Maximum.md)|![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|713|[Subarray Product Less Than K](../Solved/713-Subarray-Product-Less-Than-K/Subarray-Product-Less-Than-K.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|395|[Longest Substring with At Least K Repeating Characters](../Solved/395-Longest-Substring-with-At-Least-K-Repeating-Characters/Longest-Substring-with-At-Least-K-Repeating-Characters.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|480||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|567|[Permutation in String](../Solved/567-Permutation-in-String/Permutation-in-String.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|727|**Subscribe to unlock**|![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|



### Stream

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|295||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|346|**Subscribe to unlock**|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|352||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|703|[Kth Largest Element in a Stream](../Solved/703-Kth-Largest-Element-in-a-Stream/Kth-Largest-Element-in-a-Stream.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### 前项和

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|53|[Maximum Subarray](../Solved/53-Maximum-Subarray/Maximum-Subarray.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|238|[Product of Array Except Self](../Solved/238-Product-of-Array-Except-Self/Product-of-Array-Except-Self.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|303|[Range Sum Query - Immutable](../Solved/303-Range-Sum-Query-Immutable/Range-Sum-Query-Immutable.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|325|**Subscribe to unlock**|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|528|[Random Pick with Weight](../Solved/528-Random-Pick-with-Weight/Random-Pick-with-Weight.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|560|[Subarray Sum Equals K](../Solved/560-Subarray-Sum-Equals-K/Subarray-Sum-Equals-K.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|



### Sum
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|1|[Two Sum](Solved/1-Two-Sum/Two-Sum.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|15|[3 Sum](Solved/15-3Sum/3Sum.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|18|[4 Sum](Solved/18-4Sum/4Sum.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|167|[Two Sum II - Input array is sorted](../Solved/167-Two-Sum-II-Input-array-is-sorted/Two-Sum-II-Input-array-is-sorted.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|170|**Subscribe to unlock**|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|653|[Two Sum IV - Input is a BST](../Solved/653-Two-Sum-IV-Input-is-a-BST/Two-Sum-IV-Input-is-a-BST.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|1099|**Subscribe to unlock**|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|259|**Subscribe to unlock**|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|