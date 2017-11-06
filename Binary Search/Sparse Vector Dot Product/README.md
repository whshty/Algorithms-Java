## 1.Brute Force
```java
class Solution {
    public int dotProduct(int[] a, int[] b) {
        int len = a.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += a[i] * b[i];
        }
        return res;
    }
}
```

## 2.Sparse Vector
* Int array to store index and value

```java
class Solution {
    public int dotProduct(List<int[]> listA, List<int[]> listB){
        int res = 0;

        int len1 = listA.size();
        int len2 = listB.size();

        int i = 0 , j = 0;
        while( i < len1 || j < len2 ){
            int[] indexA = listA.get(i);
            int[] indexB = listB.get(j);
            if(indexA[0] == indexB[0]){
                res +=  indexA[1] * indexB[1];
                i++;
                j++;
            } else if(indexA[0] > indexB[0]) {
                j++;
            } else  i++;
        }
        return res;
    }
}

```

## 3.Create Vector Class

```java
class Vector{
    int index;
    int value;
    
    Vector( int i, int v){
        index = i;
        value = v;
    }
}

```


### 4.Follow - Up  : If input B is too long
* Find the index of shorter list first
* Binary search index B based on indexA
* Time : O(nlogm) (n = len(A), m =len(B))

