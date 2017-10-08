class Solution {
    public boolean validUtf8(int[] data) {
        if(data==null || data.length==0) return false;
        for(int i = 0 ; i < data.length ; i++) {
            // 1 after 8th digit, 100000000
            if(data[i]>255) return false; 
		    int byteCount = 0;
            // 0xxxxxxx, 1 byte, 128(10000000)
		    if((data[i] & 128) == 0) { 
			    byteCount = 1;
		    } 
            // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
            else if((data[i] & 224) == 192) {
			    byteCount = 2;
	    	} 
            // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
            else if((data[i] & 240) == 224) { 
			    byteCount = 3;
		    } 
            // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
            else if((data[i] & 248) == 240) { 
			    byteCount = 4;
		    } 
            else return false; 
            // check that the next n bytes start with 10xxxxxx
		    for(int j = 1 ; j < byteCount ; j++) { 
			    if( i + j >= data.length ) return false;
			    if((data[i+j] & 192) != 128) return false; // 192(11000000), 128(10000000)
		    }
		    i = i + byteCount - 1;
	    }
	    return true;
    }
}