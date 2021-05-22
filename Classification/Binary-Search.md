# Binary Search

## Contents

<!--ts-->

   * [Binary Search](#binary-search)
      * [Contents](#contents)
      * [Key Concepts](#key-concepts)
      * [Binary Search Problems](#binary-search-problems)
         * [朴素二分法](#朴素二分法)
         * [条件二分法](#条件二分法)
         * [答案二分法](#答案二分法)

<!-- Added by: weiyizhi, at: 2021年 5月13日 星期四 17时57分56秒 CST -->

<!--te-->

## Key Concepts

基本问题：

1. 基本思想？

   - 有序的数据，每次通过判断逻辑排除掉一部分的答案，直到触发终止条件

2. 二分法实现模板

   - 递归

   - 迭代

     - ``` python
         while l <= r:
         	m = (l + r) // 2
           if nums[m] > target: r = m - 1
           else if nums[m] < target: l = r + 1
           else return m
         ```
   
3. 移动两个指针（start与end）的含义？移动条件是什么（筛选掉一部分数据的依据）？循环的截止条件？

4. 数据中是否有重复数字？对结果有什么影响？

   - 没有重复元素
     - 问题：查找某个元素target在序列中是否出现，如果出现则返回出现的序号，如果不出现，则返回-1。
     - 确定一个区间 [x, x]，target就是x位置的元素，如果没有target，那么确定出来的区间是[x+1, x]，左边界大于右边界，也就是区间中不存在元素。
   - 有重复元素
     - 问题：确定第一个大于等于target的元素序号，和第一个大于target的元素序号，两个子问题。
     - 要求：等价于确定一个区间 [x, y)，这个区间里面的元素都等于target。如果没有target，那么确定出来的区间应该是 [x, x)，也就是闭区间中不存在元素。

5. 为什么你选择的模板中使用start < end 或者 start <= end 或者 start + 1 < end 作为终止条件？这样写是如何避免死循环的？不这么写在什么情况下会出现死循环？

   -  start <= end：**左闭右闭区间** √
   -  start < end：**左闭右开区间**，使用这个对于算法没有特别的好处并且容易出错，所以不使用。而且[x, x]两者相等的情况会被忽略不被检索。

6. 在处理逻辑中，当前结果>, <, = 目标值时分别如何处理？移动指针的依据是什么？

7. 循环退出后是否需要额外处理？

8. 如果遇到corner case根本没进主循环，你的代码是否能正常工作？

9. 为什么Java需要写 mid = start + (end - start) / 2 而 Python可以直接写 mid = (start + end) // 2 ？

   - java中 start + end 可能存在整型溢出的情况；python中整型可以无限大，所以不受这个限制

10. 如何理解从基本的朴素二分，到相对复杂的条件二分，到更加抽象的答案二分？

    - 朴素二分：在一个显性有序数组中一次砍掉一部分
    - 条件二分：在一组有规律的数据上利用判断条件逐步缩小范围
    - 答案二分：在一个有序的抽象模型里，利用不断的"猜测+检验"逐步逼近最终结果

11. 一些技巧

    - if语句中不要出现 else，而是把所有情况用 else if 写清楚，这样可以清楚地展现所有细节
    - **<=** 和 **<** 对应的情况
      - **<=** ：对应 + 1 与 - 1
      - **<**： 对应 +1 与 m 或者 -1 与 m



一些不错的Binary Search FAQ：https://blog.csdn.net/xiao_jj_jj/article/details/106018702



## Binary Search Problems

### 朴素二分法

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|704|[Binary Search](../Solved/704-Binary-Search/Binary-Search.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|34|[Find First and Last Position of Element in Sorted Array](../Solved/34-Find-First-and-Last-Position-of-Element-in-Sorted-Array/Find-First-and-Last-Position-of-Element-in-Sorted-Array.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|702|**Subscribe to unlock**|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|153|[Find Minimum in Rotated Sorted Array](../Solved/153-Find-Minimum-in-Rotated-Sorted-Array/Find-Minimum-in-Rotated-Sorted-Array.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|154|[Find Minimum in Rotated Sorted Array II](../Solved/154-Find-Minimum-in-Rotated-Sorted-Array-II/Find-Minimum-in-Rotated-Sorted-Array-II.md)|![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|278|[First Bad Version](../Solved/278-First-Bad-Version/First-Bad-Version.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|658|[Find K Closest Elements](../Solved/658-Find-K-Closest-Elements/Find-K-Closest-Elements.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|



### 条件二分法

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|  33  |[Search in Rotated Sorted Array](../Solved/32-Search-in-Rotated-Sorted-Array/Search-in-Rotated-Sorted-Array.md)|  ![](https://img.shields.io/badge/-Medium-%23FFA500.svg)  | :star::star::star::star: |
|  4   | [Median of Two Sorted Arrays](../Solved/4-Median-of-Two-Sorted-Arrays/Median-of-Two-Sorted-Arrays.md) | ![](https://img.shields.io/badge/-Hard-red.svg) |    :star::star::star:    |
|  74  | [Search a 2D Matrix](../Solved/74-Search-a-2D-Matrix/Search-a-2D-Matrix.md) | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |    :star::star::star:    |
| 162  | [Find Peak Element](../Solved/162-Find-Peak-Element/Find-Peak-Element.md) | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |    :star::star::star:    |
| 302  | **Subscribe to unlock** | ![](https://img.shields.io/badge/-Hard-red.svg) |       :star::star:       |
| 852  | [Peak Index in a Mountain Array](../Solved/852-Peak Index-in-a-Mountain-Array/Peak Index-in-a-Mountain-Array.md) | ![](https://img.shields.io/badge/-Easy-%235cb85c.svg) |       :star::star:       |



### 答案二分法

**Quotes**：

1. 左边指针选择为最小的可以等于的数字，右边指针的选择为题目给出的数组中最大数字

2. 都是另写一个方法获取一个值，从而帮助判断左右区间的移动


| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|875|[Koko Eating Bananas](../Solved/875-Koko-Eating-Bananas/Koko-Eating-Bananas.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|1283|[Find the Smallest Divisor Given a Threshold](../Solved/1283-Find-the-Smallest-Divisor-Given-a-Threshold/Find-the-Smallest-Divisor-Given-a-Threshold.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|69|[Sqrt(x)](../Solved/69-Sqrtx/Sqrtx.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|

