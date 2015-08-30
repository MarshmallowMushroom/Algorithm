//look one operator ahead of time, 
//if it is + or -, apply the tmp to the result;
//if it is * or /, apply current to the tmp

public class Solution {
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            }
        }
        int start = 0;
        List<String> processed = new ArrayList<String>();
        for (int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if (!Character.isDigit(c)) {
                processed.add(sb.substring(start, i));
                processed.add(String.valueOf(c));
                start = i+1;
            }
        }
        processed.add(sb.substring(start));
        int res = 0;
        int tmp = 0;
        char func = '+';
        for (int i=0; i<processed.size(); i++) {
            if (processed.get(i).equals("+") || processed.get(i).equals("-")) {
                res = cal(func, res, tmp);
                func = processed.get(i).charAt(0);
            } else if (processed.get(i).equals("*") || processed.get(i).equals("/")) {
                tmp = cal(processed.get(i).charAt(0), tmp, Integer.parseInt(processed.get(i+1)));
                i++;
            } else {
                tmp = Integer.parseInt(processed.get(i));
            }
        }
        return cal(func, res, tmp);
    }
    
    private int cal(char func, int a, int b) {
        switch (func) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
}
