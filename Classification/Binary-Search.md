# Binary Search

## Contents

<!--ts-->
   * [Binary Search](#binary-search)
      * [Contents](#contents)
      * [Key Concepts](#key-concepts)
      * [Binary Search Problems](#binary-search-problems)
         * [朴素二分法](#\xE6\x9C\xB4\xE7\xB4\xA0\xE4\xBA\x8C\xE5\x88\x86\xE6\xB3\x95)
         * [条件二分法](#\xE6\x9D\xA1\xE4\xBB\xB6\xE4\xBA\x8C\xE5\x88\x86\xE6\xB3\x95)
         * [答案二分法](#\xE7\xAD\x94\xE6\xA1\x88\xE4\xBA\x8C\xE5\x88\x86\xE6\xB3\x95)

<!-- Added by: weiyizhi, at: 2021年 5月13日 星期四 17时57分56秒 CST -->

<!--te-->

## Key Concepts

基本问题：

1. 基本思想？（有序的数据，每次通过判断逻辑排除掉一部分的答案，直到触发终止条件）
2. 二分法实现模板（可以递归，可以迭代；一般以迭代为主）
3. 移动两个指针（start与end）的含义？移动条件是什么（筛选掉一部分数据的依据）？循环的截止条件？
4. 数据中是否有重复数字？对结果有什么影响？
5. 为什么你选择的模板中使用start < end 或者 start <= end 或者 start + 1 < end 作为终止条件？这样写是如何避免死循环的？不这么写在什么情况下会出现死循环？
6. 在处理逻辑中，当前结果>, <, = 目标值时分别如何处理？移动指针的依据是什么？
7. 循环退出后是否需要额外处理？
8. 如果遇到corner case根本没进主循环，你的代码是否能正常工作？
9. 为什么Java需要写 mid = start + (end - start) / 2 而 Python可以直接写 mid = (start + end) // 2 ？
10. 如何理解从基本的朴素二分，到相对复杂的条件二分，到更加抽象的答案二分？（在一个显性有序数组中一次砍掉一部分 -->  在一组有规律的数据上利用判断条件逐步缩小范围  -->  在一个有序的抽象模型里，利用不断的"猜测+检验"逐步逼近最终结果）



## Binary Search Problems

### 朴素二分法

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|704||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star::star:|
|  34  ||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|702||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|153||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|154||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|278||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|658||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|



### 条件二分法

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|  33  ||  ![](https://img.shields.io/badge/-Easy-%235cb85c.svg)  | :star::star::star::star: |
|  4   |           | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |    :star::star::star:    |
|  74  |           | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |    :star::star::star:    |
| 162  |           | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |    :star::star::star:    |
| 302  |           | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |       :star::star:       |
| 852  |           | ![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |       :star::star:       |



### 答案二分法
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|875||![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|1283|[Rotate Image](Solved/48-Rotate-Image/Rotate-Image.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|69|[Spiral Matrix](Solved/54-Spiral-Matrix/Spiral-Matrix.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|

