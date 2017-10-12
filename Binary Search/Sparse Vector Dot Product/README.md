### Brute Force
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

### Sparse vector
##### Int array to store index and value
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

## Code ( with vector class)

```

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        listA.add(1);
        listA.add(300);
        listA.add(300);

        listB.add(1);
        listB.add(2);
        listB.add(2);

        vector v1 = new vector(listA,listB);
        vector v2 = new vector(listA,listB);

        myCode sol = new myCode();
        int ans = sol.dotProduct(v1,v2);
        System.out.print(ans);

    }
    public int dotProduct(vector v1, vector v2 ){
        int res = 0;

        for( int i = 0 ; i < v1.value.size() ; i++ ){
            int indexA = v1.index.get(i);
            for( int j = 0 ; j < v2.index.size(); j++){
                int indexB =  v2.index.get(i);
                if( indexA == indexB ) res += v1.value.get(i) * v2.value.get(j);
                else if ( indexA > indexB ) continue;
                else break;
            }
        }
        return res;

    }
}

class vector{
    List<Integer> value;
    List<Integer> index;
    vector( List<Integer> v, List<Integer> i){
        value = v;
        index = i;
    }
}

```


# Follow - up  : if input B is too longe

## Idea 
* Find the index of shorter list first
* Binary search index B based on indexA

## Time complexity
* O(nlogm) (n = len(A), m =len(B))

