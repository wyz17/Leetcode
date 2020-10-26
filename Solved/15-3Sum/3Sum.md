# 15. 3Sum

### 题目

链接：https://leetcode.com/problems/3sum/



### 思路 - 三指针法

#### 步骤

- 利用三个指针 i，l，r
- 在i循环中l++，r--
- 寻找到三数之和为0的列表添加到结果中，再处理重复值
- 否则根据三数之和判断l++还是r--



#### 复杂度

时间：` O(n^2)`

空间：` O(1)`



#### 代码

##### Java

``` python
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return res;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue; //处理i重复的情况
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l < r && nums[l] == nums[l+1]){l++;} //处理l重复的情况（只需要在相等的时候处理）
                    while(l < r && nums[r] == nums[r-1]){r--;} //处理r重复的情况
                    l++;
                    r--;
                }
                if(sum < 0) l++;
                if(sum > 0) r--;
            }
        }
        return res;
    }
}
```


