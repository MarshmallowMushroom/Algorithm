/*
Use this brilliant idea to store extra mappings of int to roman
*/

public class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int [] base = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        while(num > 0) {
            //find first base that is smaller than the num
            for (int i = 0; i < base.length; i++) {
                if (base[i] <= num) {
                    num -= base[i];
                    result.append(roman[i]);
                    break;
                }
            }
        }
        return new String(result);
    }
}
