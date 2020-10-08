# 2. Add Two Numbers

### 题目

链接：https://leetcode.com/problems/add-two-numbers/



### 思路

- 同时遍历两个链表，将表头的值相加，赋值给第三个链表
- 考虑情况
  - 二个链表长度不一定相等 -> 遍历最长的链表，短的链表后面的部分赋值为0
  - 二者相加 > 10：下一个结点++
  - 二者相加 > 10 且是最后一个结点：链表末尾加一个1



### 复杂度

时间：```O(max⁡(m,n))```，链表ab之间最长的那一个

空间：```O(max(m,n))```，新链表可能的最大长度为m,n中最大+1