public class Solution{
    public static void main(String[] args) {
        int[] input = new int[]{7,6,4,3,1,8};
        Solution sol = new Solution();
        System.out.println(sol.isMonoArray(input));

    }

    public boolean isMonoArray(int[] input){
        if( input == null || input.length == 0 ) return false;
        if( input.length == 1 ) return true;
        if( input[0] < input[1]){
            for( int i = 1 ; i < input.length -1 ; i++ ){
                if( input[i] > input[i+1] ) return false;
            }
            return true;
        }

        if( input[0] > input[1]){
            for( int i = 1 ; i < input.length -1 ; i++ ){
                if( input[i] < input[i+1] ) return false;
            }
            return true;
        }
        return false;
    }
}