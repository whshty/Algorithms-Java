public class Solution {
    public String intToRoman(int num) {
        String A[] = {"", "M", "MM", "MMM"};
        String B[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String C[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String D[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder sb = new StringBuilder();
        return sb.append(A[num/1000]).append(B[(num%1000)/100]).append(C[(num%100)/10]).append(D[num%10]).toString();
    }
}