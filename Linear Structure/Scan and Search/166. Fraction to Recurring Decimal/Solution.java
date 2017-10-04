class Solution {
    public String fractionToDecimal(int numerator , int denominator) {
        if( numerator == 0 ) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        
        long a = Math.abs((long)numerator);
        long b = Math.abs((long)denominator);
        
        sb.append( a / b);
        a %= b;
        if ( a == 0)  return sb.toString();
        
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(a, sb.length());
        
        while (a != 0) {
            a *= 10;
            sb.append( a / b);
            a %= b;
            if (map.containsKey(a)) {
                int index = map.get(a);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            else {
                map.put(a, sb.length());
            }
        }
        return sb.toString();   
    }
}