class Solution {
    public int binaryGap(int N) {
        int max = 0;
        int right = 0;
        int leftZero = -1;
        int index = 0;
        while (N > 0) {
            right = N & 1;
            N = N >> 1;

            if (1 == right) {
                if(leftZero != -1){
                    max = Math.max(index-leftZero,max);
                }
                leftZero = index;
            }
            index++;
        }
        return max;
    }
}
