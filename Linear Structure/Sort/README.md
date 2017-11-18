# Sorting
## 1.Quick Sort
* [Link](http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html)
* Pick Medium as pivot

```
          5 3 6 8 1
          5 3 1 8 6 
      5 3 1 8     8 6 
      1 3 5 8     6 8  

```

```java
class Solution {
    private static void quickSort(int[] arr, int low , int high){
        int i = low , j = high;
        int pivot = arr[( low + high ) >>> 1];
        while( i < j ){
            while ( arr[i] < pivot ) i++;
            while ( arr[j] > pivot ) j--;
            if ( i <= j ){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        if( low < j ){
            quickSort(arr,low,j);
        }

        if( i < high ){
            quickSort(arr,i,high);
        }   
    }
    
    private static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

```

## 2.Merge Sort

## 3.Insertion Sort

## 4.Cycle Sort
```
Cycle sort的思想与计数排序相似
圈排序与计数排序的区别在于圈排序只给那些需要计数的数字计数

圈排序，根据排完序之后数组索引，进行交换。首先确定第一个元素，最终的位置，而该位置旧的元素，最终应该在的位置，。。。
遍历一次数组，找到所有相关联的元素。一圈又一圈。
如果某一圈，只有一个元素，说明该元素不需要交换，即其位置就是最终位置。

实现：如何知道排完序后数组的索引呢？
例如：6 2 4 1 5 9
	1.将6取出来,计算出有4个数字比6小,将6放入索引4,同时原索引4位置的数字5出列
	2.当前数字5,计算出有3个数字比5小,将5放入索引3,同时原索引3位置的数字1出列
	3.当前数字1,计算出有0个数字比1小,将1放入索引0,索引0处为空,这圈完毕
	4.取出下一个数字2,计算出有1个数字比2小,将2放入索引1处,发现它本来就在索引1处
```

```java

class Solution {
    public static void main (String[] args) throws java.lang.Exception {
        int[] test = {20,14,17,21,3,6,2,1,4,20};
        Solution sol = new Solution();
        sol.cycleSort(test);
        for( int i = 0 ; i < test.length ; i++ ){
            System.out.print(test[i] + ", ");
        }
    }
    public void cycleSort(int[] array){
        int pos;
        int cur;
        for(int i = 0 ; i < array.length - 1 ; i++){
            cur = array[i];
            pos = i;
            for( int j = i + 1 ; j < array.length ; j++ ){
                if( array[j] < cur ) pos++;
            }
            if( pos == i ) continue;
            while( cur == array[pos]) pos++;
            if( cur != array[pos]){
                int temp = array[pos];
                array[pos] = cur;
                cur = temp;
            }

            while( pos != i ){
                pos = i;
                for( int k = i + 1 ; k < array.length ; k++){
                    if( array[k] < cur ) pos++;
                }
                while( cur == array[pos] ) pos++;
                if( cur != array[pos]){
                    int temp = array[pos];
                    array[pos] = cur;
                    cur = temp;
                }
            }
        }
    }
}

```


