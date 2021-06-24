# Dynamic Programming

## Contents

<!--ts-->
   * [Dynamic Programming](#dynamic-programming)
      * [Contents](#contents)
      * [Key Concepts](#key-concepts)
      * [Dynamic Programming Problems](#dynamic-programming-problems)
         * [Backpack](#backpack)
         * [Single Sequence](#single-sequence)
         * [Double Sequences](#double-sequences)
         * [Sections](#sections)
         * [Matrix](#matrix)
         * [Others](#others)
         * [Greedy](#greedy)

<!-- Added by: weiyizhi, at: Thu Jun 24 20:24:46 CST 2021 -->

<!--te-->

## Key Concepts

基本问题：

1. 动态规划更准确的说是一种数学思想，而不是一种算法。学习曲线相对于前面的算法会比较陡峭，如果是有天赋的大佬，可能可以很快领悟。但是对于大部分平均水平的同学，可能需要前后间隔几个礼拜甚至几个月，反复思考两三遍才能顿悟并运用。所以作为初学者，一时半会想不明白没关系，隔几天回来再多看几次就能渐渐理解了。
2. 不过针对目前的面试，除了少数那几家公司之外，动态规划的出现频率其实没有那么高，而且主要也都是中等难度的题目。所以如果准备时间有限，建议优先把时间放在前面的算法上，动态规划可以先看几道中等难度经典题，其他的题目后面有时间再看。
3. 关于一道题是用动态规划还是用贪心法，一般来说时间复杂度类似的时候优先用动态规划，因为通用性、可解释性都比较强。而自己凭空想出来的贪心法，不但不容易解释，而且很容易是错的，面试风险相对比较高。不过有一些题目确实是贪心法最优，作者在后面也列出了几题，如果碰到原题或者类似题，可以参考。
4. 对于新手而言，在学习动态规划的时候，看懂题目在问什么之后就可以在网上找答案了，别自己瞎折腾。网上各种大佬的博客有详细的图文解释，慢慢揣摩理解。
5. 动态规划的一般思路是数学归纳法，就是用递推的方式把大问题（最终问题）分解为小问题（前置问题），然后一路倒推到边界；在边界附近计算出初始状态后，再原路反向往回计算，最后得到所求解。所以对于绝大部分题目，都需要遵循：分解子问题，写出转移方程，描述边界条件，计算出最终解这几个步骤。
6. 有些动态规划问题，可以通过滚动数组的方式优化空间复杂度，一般可以降一个维度。但是要注意运算的方向，需要避免前序的结果在被用到之前就被覆盖掉的情况。
7. 大部分动态规划都是求解“可行性”，“最值”问题，如果有些题目要求输出结果，也可以考虑用“打印路径”的方式。
8. 很多问题，通过细微的改一些条件，就会变成另外一道题，解法思路会产生明显差异，所以审题要小心。比如背包类问题，是否可以重复选同一个物品，是否有重复物品，求解最大重量还是最大价值， 背后的原理可能会产生变化。有时候是组合问题，有时候是排列问题，还叠加了是否可以重复的情况，需要透彻的理解。另外在解法上，比如说，正着走一遍循环和倒着走一遍循环可能代表的是两种不同的思考方式，这些往往需要反复细致的理解才能完善自己的思维体系
9. 有些问题需要求“所有可行解”，这时候往往会使用搜索（DFS，BFS）的方法。但为了进行时空优化，记忆化搜索也会常常被用到。其实DFS记忆化搜索和常规动态规划写法常常是一个思维的两种实现方式，在不同的题目中各有优劣。
10. 在面试动态规划的时候，重点在于能够比较清晰地画图描述并解释清楚所写的动态方程，让面试官理解你的思路，注意初始化以及for循环的起始条件。至于代码本身，往往是for循环为主，一般也不长。



## Dynamic Programming Problems

### Backpack

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|Lint-92||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|Lint-125||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|Lint-440| |![](https://img.shields.io/badge/-Medium-%23FFA500.svg) |:star::star::star:|
|Lint-562||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|Lint-563||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|Lint-564||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|Lint-971||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|474|[Ones and Zeroes](Solved/474-Ones-and-Zeroes/Ones-and-Zeroes.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|



### Single Sequence

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|139||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|121|[Best Time to Buy and Sell Stock](Solved/121-Best-Time-to-Buy-and-Sell-Stock/Best-Time-to-Buy-and-Sell-Stock.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star::star:|
|122|[Best Time to Buy and Sell Stock II](Solved/122-Best-Time-to-Buy-and-Sell-Stock-II/Best-Time-to-Buy-and-Sell-Stock-II.md)|![](https://img.shields.io/badge/-Easy-%235cb85c.svg)|:star::star:|
|123|[Best Time to Buy and Sell Stock III](Solved/123-Best-Time-to-Buy-and-Sell-Stock-III/Best-Time-to-Buy-and-Sell-Stock-III.md)|![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|188||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|256||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|265||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|
|Lint-843||![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star:|



### Double Sequences
| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|10||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|44||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|72||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|97||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|115||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|1143||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|



### Sections

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|312||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|516||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|87||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|



### Matrix

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|62|[Unique Paths](Solved/62-Unique-Paths/Unique-Paths.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|63|[Unique Paths II](Solved/63-Unique-Paths-II/Unique-Paths-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star::star:|
|64|[Minimum Path Sum](Solved/64-Minimum-Path-Sum/Minimum-Path-Sum.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|85||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|221||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|361||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|



### Others

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|91|[Decode Ways](Solved/91-Decode-Ways/Decode-Ways.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|Lint-394||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|
|132||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|279||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|639||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|Lint-395||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|
|Lint-396||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star:|



### Greedy

| No | Solutions | Difficulity | Priority |
| :--: | ------- | :---------: | :------: |
|55|[Jump Game](Solved/55-Jump-Game/Jump-Game.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|45|[Jump Game II](Solved/45-Jump-Game-II/Jump-Game-II.md)|![](https://img.shields.io/badge/-Medium-%23FFA500.svg)|:star::star::star:|
|763||![](https://img.shields.io/badge/-Hard-red.svg)|:star::star::star:|


