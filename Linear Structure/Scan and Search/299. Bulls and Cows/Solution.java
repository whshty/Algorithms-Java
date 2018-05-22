class Solution {
    public String getHint(String secret, String guess) {
        int countA = 0;
        int countB = 0;
        int[] nums = new int[10];
        for ( int i = 0 ; i < secret.length() ; i ++ ){
            int x = Character.getNumericValue(secret.charAt(i));
            int y = Character.getNumericValue(guess.charAt(i));
            
            if (x == y) countA++;
            else {
                if (nums[x] < 0) countB++;
                if (nums[y] > 0) countB++;
                nums[x]++;
                nums[y]--;
            }
        }
        return countA + "A" + countB +"B";
    }
}