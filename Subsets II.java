public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<Integer> sortedNum = new ArrayList<Integer>();
        for (int i : num) {
            sortedNum.add(i);
        }
        return helper(sortedNum);
    }
    
    public ArrayList<ArrayList<Integer>> helper (ArrayList<Integer> num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> group = new ArrayList<Integer>();
        //base case
        if(num.isEmpty()) {
            result.add(group);
            return result;
        }
        //removing the same element group from the begining of the num
        group.add(num.get(0));
        num.remove(0);
        while(!num.isEmpty() && num.get(0) == group.get(0)) {
            group.add(num.get(0));
            num.remove(0); 
        }
        ArrayList<ArrayList<Integer>> next = helper(num);
        result.addAll(next);
        for(int i = 1; i <= group.size(); i++) {
            for (ArrayList<Integer> list : next) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(list);
                for (int j = 0; j < i; j++){
                    tmp.add(0, group.get(0));
                }
                result.add(tmp);
            }
        }
        return result;
    }
}
