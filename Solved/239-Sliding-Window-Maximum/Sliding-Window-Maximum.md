# 239. Sliding Window Maximum

### 题目

- 链接：https://leetcode.com/problems/sliding-window-maximum
- 给定一个数组nums和一个固定长度的滑窗k，这个滑窗每次以一个元素为步长向右滑动，每滑动一次，返回当前滑窗内元素的最大值；最终返回一个最大值的数组



### 思路 - 双端队列

**参考Post：**https://zhuanlan.zhihu.com/p/80228831

#### 步骤

- 用双端队列保存数字的下标，遍历整个数组
- 如果此时队列的首元素是 i-k 的话，表示此时窗口向右移了一步，则移除队首元素
  - 判断当前元素的索引位置 i 减去队列中最左边元素 index 是否 >= k
  - 如果是，那么说明随着滑窗滑动，当前滑窗内的最大值从左边滑出了，已经不在这个滑窗内了，那么就需要在队列中把最左边的元素弹出
- 比较队尾元素和将要进来的值，如果小的话就都移除，然后此时我们把队首元素加入结果中即可
  - 将当前元素与队列中最右边的元素（注意队列中的元素是索引）进行比较
    - 若队列对应的元素 <= 当前元素，那么弹出队列最右边的元素，直到队列元素 > 当前元素，此时把当前元素对应的索引加到window中
    - 做完上述操作后，window最左边的元素肯定是当前滑窗中最大值对应的索引





#### 复杂度

时间： `O(n)`

空间：` O(k)`



#### 代码

##### Java

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int right = 0;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < nums.length; i++) {
            while(!q.isEmpty() && q.peek() < i - k + 1) {
              q.poll();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
              q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
              res[right++] = nums[q.peek()];
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if not nums:
            return []
        res = []
        window = deque()
        for i in range(0, len(nums)):
            while window and window[0] < i - k + 1:
                window.popleft()
            while window and nums[window[-1]] <= nums[i]:
                window.pop()
            window.append(i)
            if i >= k - 1:
                res.append(nums[window[0]])
        return res
```

