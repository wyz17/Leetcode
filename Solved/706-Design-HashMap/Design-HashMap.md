

# 706. Design HashMap

### 题目

链接：https://leetcode.com/problems/design-hashmap/





### 思路1 - LinkedList

#### 步骤

- 利用链表存储



#### 复杂度

时间： `O(1)`

空间：` O(n)`



#### 代码

##### Java

```java
class MyHashMap {
    private class ListNode {
        public int key, val;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    
    ListNode[] nodes = new ListNode[10000];
        
    public MyHashMap() {
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(-1,-1);
        }
    }
    
    public void put(int key, int value) {
        int index = Integer.hashCode(key) % nodes.length;
		ListNode prev = find(index, key);
		
		if (prev.next == null)
			prev.next = new ListNode(key, value);
		else 
			prev.next.val = value;
    }
    
    public int get(int key) {
        int index = Integer.hashCode(key) % nodes.length;
		ListNode prev = find(index, key);
		return prev.next == null ? -1 : prev.next.val;
    }
    
    public void remove(int key) {
        int index = Integer.hashCode(key) % nodes.length;
        ListNode prev = find(index, key);
        if(prev.next != null) prev.next = prev.next.next;
    }
    
    private ListNode find(int index, int key) {
		if(nodes[index] == null)
			return nodes[index] = new ListNode(-1, -1);
        ListNode prev = nodes[index];
		while(prev.next != null && prev.next.key != key) {
			prev = prev.next;
		}
		return prev;
	}
}
```



##### Python

```python

```





### 思路2 - Array

#### 步骤

- 利用array存储index

m

#### 复杂度

时间： `O(1)`

空间：` O(n)`



#### 代码

##### Java

```java
class MyHashMap {
    
    int[] map;
    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map,-1);
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
    }
}
```



##### Python

```python
class MyHashMap:
    m = []
    def __init__(self):
        self.m = [-1] * 1000001
        

    def put(self, key: int, value: int) -> None:
        self.m[key] = value
           

    def get(self, key: int) -> int:
        return self.m[key]
        

    def remove(self, key: int) -> None:
        self.m[key] = -1
```

