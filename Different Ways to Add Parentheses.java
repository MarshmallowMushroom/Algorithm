public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<String> in = new ArrayList<String>();
        StringBuilder tmp = new StringBuilder();
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                in.add(tmp.toString());
                tmp = new StringBuilder();
                in.add(Character.toString(c));
            } else {
                tmp.append(c);
            }
        }
        in.add(tmp.toString());
        return diffWays(0, in.size()-1, in);
    }
    
    private List<Integer> diffWays(int pStart, int pEnd, List<String> input) {
        List<Integer> res = new ArrayList<Integer>();
        if (pEnd < pStart)
            return res;
        if (pStart == pEnd) {
            res.add(Integer.parseInt(input.get(pStart)));
            return res;
        }
        
        for (int i = pStart+1; i<pEnd; i+=2) {
            List<Integer> left = diffWays(pStart, i-1, input);
            List<Integer> right = diffWays(i+1, pEnd, input);
            for(int l : left) {
                for(int r : right) {
                    String op = input.get(i);
                    if (op.equals("+"))
                        res.add(l+r);
                    else if (op.equals("-"))
                        res.add(l-r);
                    else
                        res.add(l*r);
                }
            }
        }
        return res;
    }
}
