// brute force
// dividend - divisor util divident < 0 
// 32 ~ 3*10 = 3*[1*(2^3) + 0*(2^2) + 1*(2^1) + 0*(2^0)]
// time (logn)^2
// space o(1)
public class Solution {
    public int divide(int dividend, int divisor) {
    	if( divisor == 0 || (divisor == -1 && dividend == Integer.MIN_VALUE)){
    		return Integer.MAX_VALUE;
    	}
    	if(dividend == 0) return 0;
    	if(divisor == 1) return dividend;
    	// save the sign : + or -
    	int sign = ( dividend > 0 && divisor > 0 ) || (dividend < 0 && divisor < 0 ) ? 1: -1;
        // use long to avoid overflow
        // when do left sheft , each time dvs * 2 
    	long dvd = Math.abs((long)dividend), dvs = Math.abs((long)divisor);
    	if( dvd < dvs ) return 0;
    	int res =0 ;
    	while(dvd >= dvs){
    	    long temp = dvs;
    	    int count = 1;
    	    while((temp << 1) <= dvd){
    	        temp <<= 1;
    	        count <<= 1;
    	    }
    	    res += count;
    	    dvd -=temp;
    	}
    	return res * sign;
    }
}