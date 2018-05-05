class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int len = fronts.length;
        boolean[] candidateNumber = new boolean[2001];
        boolean[] bannedNumber = new boolean[2001];
        
        for( int i = 0 ; i < len ; i++ ){
            int front = fronts[i] , back = backs[i];
            if( front == back){
                bannedNumber[front] = true;
                candidateNumber[back] = false;
            } else {
                if(!bannedNumber[front]) candidateNumber[front] = true;
                if(!bannedNumber[back]) candidateNumber[back] = true;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 2000; i++) res = candidateNumber[i] ? Math.min(i, res) : res; 
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}