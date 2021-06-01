# Multi-Pointer

## Contents

<!--ts-->
   * [Multi-Pointer](#multi-pointer)
      * [Contents](#contents)
      * [Key Concepts](#key-concepts)
      * [Multi-Pointer Problems](#multi-pointer-problems)
         * [Array](#array)
         * [LinkedList](#linkedlist)
         * [Intervals 区间](#intervals-\xE5\x8C\xBA\xE9\x97\xB4)
         * [Palindrome 回文串](#palindrome-\xE5\x9B\x9E\xE6\x96\x87\xE4\xB8\xB2)
         * [滑动窗口](#\xE6\xBB\x91\xE5\x8A\xA8\xE7\xAA\x97\xE5\x8F\xA3)
         * [Stream 流](#stream-\xE6\xB5\x81)
         * [前项和](#\xE5\x89\x8D\xE9\xA1\xB9\xE5\x92\x8C)
         * [Sum](#sum)

<!-- Added by: weiyizhi, at: 2021年 5月13日 星期四 17时57分57秒 CST -->

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
|328||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|142||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|287|[Find the Duplicate Number](../Solved/287-Find-the-Duplicate-Number/Find-the-Duplicate-Number.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|876||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### Intervals 区间
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|Lint-391|[Number of Airplanes in the Sky](https://www.lintcode.com/problem ... the-sky/description)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|56|[Merge Intervals](../Solved/56-Merge-Intervals/Merge-Intervals.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|57|[Insert Intervals](../Solved/57-Insert-Intervals/Insert-Intervals.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|252||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|253||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|986||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|



### Palindrome 回文串
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|5|[Longest Palindromic Substring](../Solved/5-Longest-Palindromic-Substring/Longest-Palindromic-Substring.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|345|[Reverse Vowels of a String](../Solved/345-Reverse-Vowels-of-a-String/Reverse-Vowels-of-a-String.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|680||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|125|[Valid Palindrome](../Solved/125-Valid-Palindrome/Valid-Palindrome.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### 滑动窗口

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|3||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|11|[Container With Most Water](../Solved/11-Container-With-Most-Water/Container-With-Most-Water.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|76|[Minimum Window Substring](../Solved/76-Minimum-Window-Substring/Minimum-Window-Substring.md)|![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|209||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|239||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|713||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|395||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|480||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|567||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|727||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### Stream 流

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|295||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|346||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|352||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|703||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|



### 前项和

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|53|[Maximum Subarray](Solved/53-Maximum-Subarray/Maximum-Subarray.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|238||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|303||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|325||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|528||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|560||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|



### Sum
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|1|[Two Sum](Solved/1-Two-Sum/Two-Sum.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|15|[3 Sum](Solved/15-3Sum/3Sum.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|18|[4 Sum](Solved/18-4Sum/4Sum.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|167||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|170||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|653||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|1099||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|259||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|