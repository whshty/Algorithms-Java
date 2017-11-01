/*
Overflow explanation: Integer.MAX_VALUE = 2147483647 and Integer.MIN_VALUE = -2147483648 is the largest/smallest value that an int primitive can contain.

Let's simplify this problem. 
Suppose str1 = " -a649b ", st2 = " a652b ", max = 647, min = -648. 
So if atoi(str) > 647 || atoi(str) < -648 atoi will overflow. 
In other words, when we've parsed num == 64 and the next char is also digit, 
max / min can directly be returned if the next digit >= 8; or we've parsed num > 64, 
directly return too.
*/


public class Solution {
    //“+0 123” return:0
    // “-123a2” return:-123
    //“+—123 ” return:0
    
    public int myAtoi(String str) {
        final int maxDiv10 = Integer.MAX_VALUE / 10;
    	int i = 0 , len = str.length();
    	while (i < len && Character.isWhitespace(str.charAt(i))) i++;
    	int sign = 1;
    	if ( i < len && str.charAt(i) == '+' ) i++;
		else if ( i < len && str.charAt(i) == '-'){
			sign = -1;
			i++;
		}
		int num = 0;
		while (i < len && Character.isDigit(str.charAt(i))){
			int value = Character.getNumericValue(str.charAt(i));
			if ( num > maxDiv10 || num == maxDiv10 && value >=8 ){
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + value;
			i++;
		}
		return sign*num;
    }
}