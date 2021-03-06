## 1.Convert Every Three Digits from End 
* 107 = One Hundred Seven
* 1,234,567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
* In Java, the integer is also 32 bits, but ranges from -2,147,483,648 to +2,147,483,647. ( 2^31 − 1)
* res.trim()  "One Hundred Twenty Three  " ->  "One Hundred Twenty Three"

```java
public class Solution {
    private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if( num == 0 ) return "Zero";
        int index = 0;
        
        String res = "";
        while( num > 0 ){
            if(num % 1000 != 0){
                // if num = 123456789, num % 1000 = 789 then 456 then 123 
                res = helper(num%1000) + thousands[index] + " " + res;
            }
            num /= 1000;
            index++;
        }
        return res.trim();
    }
    private String helper(int num){
        if( num == 0) return "";
        else if ( num < 20 ) return lessThan20[num] + " ";
        else if ( num < 100 ) return tens[num / 10] + " " + helper(num % 10);
        else  return lessThan20[num / 100] + " Hundred " + helper(num % 100);
    }
}

```

## 2.If Input Can Be Negative

```java
public class Solution {
    private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", 
                                         "Six", "Seven", "Eight", "Nine", "Ten",                                                                                          "Eleven", "Twelve", "Thirteen", "Fourteen", 
                                         "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if( num == 0 ) return "Zero";
        int index = 0;
        
        boolean isPostive = true;
        if( num < 0 ) isPostive = false;
        
        num = Math.abs(num);
        
        String res = "";
        while( num > 0 ){
            if(num % 1000 != 0){
                res = helper(num%1000) + thousands[index] + " " + res;
            }
            num /= 1000;
            index++;
        }
        if(isPostive) return res.trim();
        else return "Negative " + res.trim();
    }
    private String helper(int num){
        if( num == 0) return "";
        else if ( num < 20 ) return lessThan20[num] + " ";
        else if ( num < 100 ) return tens[num / 10] + " " + helper(num % 10);
        else  return lessThan20[num / 100] + " Hundred " + helper(num % 100);
    }
}

```