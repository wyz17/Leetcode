# 155. Min Stack

### 题目

链接：https://leetcode.com/problems/min-stack/



### 思路

#### 步骤

- 定义一个min值，作为当前栈的最小值
- push：判断存入值val是否小于最小值min，如果更小的话，就先将val存入栈，再存入val（新的min）
- pop：判断弹出的值是否等于min，如果等于的话则说明我们弹出了当前最小值；再往后弹出一个作为新的min（就是前一个min）



#### 复杂度

时间： `O(1)`

空间：` O(1)`



#### 代码

##### Java

```java
class MinStack {
    Stack<Integer> stk;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stk = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(stk.isEmpty()) {
            stk.push(val);
            min = val;
        } else {
            if(val <= min) {
                stk.push(min);
                min = val;
            }
            stk.push(val);
        }
    }
    
    public void pop() {
        if(stk.isEmpty()) return;
        int cur = stk.pop();
        if(cur == min && !stk.isEmpty()) {
            int nextMin = stk.pop();
            min = nextMin;
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min;
    }
}
```



##### Python

```python
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stk = []
        self.m = 0
        

    def push(self, val: int) -> None:
        if not self.stk:
            self.stk.append(val)
            self.m = val
        else:
            if val <= self.m:
                self.stk.append(self.m)
                self.m = val
            self.stk.append(val)
            
    def pop(self) -> None:
        if not self.stk: return
        cur = self.stk.pop()
        if cur == self.m and self.stk:
            new_m = self.stk.pop()
            self.m = new_m
        

    def top(self) -> int:
        return self.stk[-1]

    def getMin(self) -> int:
        return self.m
```



