public class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder res = new StringBuilder();
        Map<Integer, String> map = getMap();
        int billion = num/1000000000;
        if (billion > 0) {
            res.append(map.get(billion));
            res.append(" Billion");
        }
        num -= billion * 1000000000;
        if (num == 0) {
            return res.toString().trim();
        }
        int million = num/1000000;
        if (million > 0) {
            res.append(" ");
            res.append(getHundreds(million, map));
            res.append(" Million");
        }
        num -= million * 1000000;
        if (num == 0) {
            return res.toString().trim();
        }
        int thousand = num/1000;
        if (thousand > 0) {
            res.append(" ");
            res.append(getHundreds(thousand, map));
            res.append(" Thousand");
        }
        num -= thousand * 1000;
        if (num > 0) {
            res.append(" ");
            res.append(getHundreds(num, map));
        }
        return res.toString().trim();
    }
    
    private String getHundreds(int num, Map<Integer, String> map) {
        int hundred = num/100;
        StringBuilder res = new StringBuilder();
        if (hundred > 0) {
            res.append(map.get(hundred));
            res.append(" Hundred");
        }
        num -= hundred*100;
        if (num == 0) {
            return res.toString();
        }
        if (num <= 20) {
            res.append(" ");
            res.append(map.get(num));
        } else {
            int d = num%10;
            int t = num-d;
            res.append(" ");
            res.append(map.get(t));
            if (d > 0) {
                res.append(" ");
                res.append(map.get(d));
            }
        }
        return res.toString().trim();
    }
    
    private Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        return map;
    }
}
