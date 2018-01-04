class Solution {
    public int compress(char[] chars) {
        int pre = 0, index = 0 , count = 0;
        while ( index < chars.length ){
            count++;
            if( index == chars.length - 1 || chars[index] != chars[index+1]){
                chars[pre] = chars[index];
                pre++;
                if( count != 1 ) {
                    char[] arr = String.valueOf(count).toCharArray();
                    for ( int i = 0 ; i < arr.length ; i++ , pre++ ){
                        chars[pre] = arr[i];
                    }
                }
                count = 0;
            }
            index++;
        }
        return pre;
    }
}