public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean sign = (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0);
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);
        long intPart = num/denom;
        String result = String.valueOf(intPart);
        long rest = num%denom;
        if (rest == 0) {
            if (sign)
                return "-" + result;
            return result;
        }
        Map<Long, Integer> recurring = new HashMap<Long, Integer>();
        StringBuilder decPart = new StringBuilder();
        while(rest > 0) {
            recurring.put(rest, decPart.length());
            rest *= 10;
            long d = rest/denom;
            rest = rest % denom;
            decPart = decPart.append(String.valueOf(d));
            if (recurring.containsKey(rest)) {
                decPart.insert(recurring.get(rest), "(");
                decPart.append(")");
                break;
            }
        }
        if (sign) {
            return "-" + result + "." + decPart.toString();
        }
        return result + "." + decPart.toString();
    }
}
