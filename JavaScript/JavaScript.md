# Notes for JavaScript

刷lc时查的内容 & 知识点记录



## Contents

<!--ts-->
   * [Notes for JavaScript](#notes-for-javascript)
      * [Contents](#contents)
      * [Data Structure](#data-structure)
      * [Others](#others)
         * [slice()](#slice)
         * [splice()](#splice)

<!-- Added by: weiyizhi, at: 2021年 4月10日 星期六 16时52分31秒 CST -->

<!--te-->


## Data Structure







## Others

### slice()

slice(start, end)：方法可从已有数组中返回选定的元素，返回一个新数组，包含从start到end（不包含该元素）的数组元素。

- start参数：必须，规定从何处开始选取，如果为负数，规定从数组尾部算起的位置，-1是指最后一个元素。
- end参数：可选（如果该参数没有指定，那么切分的数组包含从start倒数组结束的所有元素，如果这个参数为负数，那么规定是从数组尾部开始算起的元素）。

- ```javascript
  var arr = [1,2,3,4,5];
  console.log(arr.slice(1));//[2,3,4,5]  选择序列号从1到最后的所有元素组成的新数组。
  console.log(arr.slice(1,3))//[2,3]  不包含end，序列号为3的元素
  ```




### splice()

splice(index, howmany, item1, ... itemX)：该方法向或者从数组中添加或者删除项目，返回被删除的项目。（该方法会改变原数组）

- index参数：必须，整数，规定添加或者删除的位置，使用负数，从数组尾部规定位置。
- howmany参数：必须，要删除的数量，如果为0，则不删除项目。
- tem1, ...itemX参数：可选，向数组添加的新项目。

```javascript
var arr = [1,2,3,4,5];
console.log(arr.splice(2,1,"hello"));//[3]  返回的新数组
console.log(arr);//[1, 2, "hello", 4, 5]  改变了原数组
```

