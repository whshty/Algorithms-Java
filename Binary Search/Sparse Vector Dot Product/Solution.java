// Brute Force
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
//Sparse Vector
class Solution {
    public int dotProduct(List<int[]> listA, List<int[]> listB){
        int res = 0;

        int len1 = listA.size();
        int len2 = listB.size();

        int i = 0 , j = 0;
        while( i < len1 && j < len2 ){
            int[] indexA = listA.get(i);
            int[] indexB = listB.get(j);
            if(indexA[0] == indexB[0]){
                res +=  indexA[1] * indexB[1];
                i++;
                j++;
            }
            else if(indexA[0] > indexB[0]) j++;
            else  i++;
        }
        return res;
    }
}

//If input B is too long