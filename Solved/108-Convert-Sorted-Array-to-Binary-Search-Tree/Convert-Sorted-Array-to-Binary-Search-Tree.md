

# 108. Convert Sorted Array to Binary Search Tree

### 题目

链接：https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/



这里有点纠结中点的取法，是想上取整还是向下取整。可以参考题目给出的possible answer：按照这道题的输出，在偶数的时候，我们取二分之后的靠右的那个元素是最合理的。



### 思路1 - Recursive

#### 步骤

- 直接看代码就好啦
- 递归生成mid




#### 复杂度

时间：` O(N)`

空间：` O(N)` 



#### 代码

##### Java

```java
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode head = build(nums, 0, nums.length - 1);
        return head;
    }
    
    private TreeNode build(int[] nums, int left, int right) {
        if(left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);
        return node;
    }


```



##### Python

```python
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if not num:
            return None
        mid = len(nums) // 2
        node = TreeNode(nums[mid])
        node.left = self.sortedArrayToBST(nums[:mid])
        node.right = self.sortedArrayToBST(nums[mid + 1:])
        return node
```



### 思路2 - Iterative

#### 步骤

- 参考这个：https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/35218/Java-Iterative-Solution
- 有点麻烦，有空补




#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java

```



##### Python

```python

```

