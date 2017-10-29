import java.util.Comparator;

public class Solution implements Comparator<String> {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.compare("abc9", "abc123");
        System.out.print(res);
    }

    public int compare(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            char ch1 = str1.charAt(index1);
            char ch2 = str2.charAt(index2);
            // both are char and equals
            if (ch1 == ch2 && !Character.isDigit(ch2)) {
                index1++;
                index2++;
            }
            //both are number
            else if (Character.isDigit(ch1) && Character.isDigit(ch2)) {
                int number1 = 0;
                int number2 = 0;
                while (index1 < str1.length() && Character.isDigit(str1.charAt(index1))) {
                    number1 = number1 * 10 + str1.charAt(index1) - '0';
                    index1++;
                }
                while (index2 < str2.length() && Character.isDigit(str2.charAt(index2))) {
                    number2 = number2 * 10 + str2.charAt(index2) - '0';
                    index2++;
                }
                if (number1 > number2) {
                    return 1;
                } else if (number1 < number2) {
                    return -1;
                }
            }
            // not equals or one is number
            else {
                if (Character.isDigit(ch2)) {
                    return 1;
                } else if (Character.isDigit(ch1)) {
                    return -1;
                }
                if (ch1 > ch2) {
                    return 1;
                }
                return -1;
            }
        }
        if (index1 == str1.length() && index2 == str2.length()) { //check all the char already
            return 0;
        } else if (index1 < str1.length()) {
            return 1;
        }
        return -1;
    }
}