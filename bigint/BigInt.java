class BigInt{
    String number;

    public static void main(String[] agrs){
        String number = "193";
        String add = "8";
        BigInt sol = new BigInt(number);
        String answer = sol.addBigInt(add);
        System.out.println(answer);
    }

    public BigInt(String number){
        this.number = number;
    }
    public String addBigInt(String toAdd){
        int len1  = number.length() -1;
        int len2 = toAdd.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while( len1 >= 0 || len2 >= 0 ){
            int res = 0 ;
            if(len1 >= 0 ) res += number.charAt(len1--) - '0';
            if(len2 >= 0 ) res += toAdd.charAt(len2--) - '0';
            res += carry;
            int pos = res % 10;
            sb.append(pos);
            carry = res / 10;
        }
        if(carry != 0 ) sb.append(carry);
        return sb.reverse().toString();
    }
}