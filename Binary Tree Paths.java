/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (root == null) {
            return new ArrayList<String>();
        }
        result = findPathHelper(root);
        return parseResult(result);
    }
    
    private List<List<String>> findPathHelper(TreeNode root) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (root.left == null && root.right == null) {
            List<String> r = new ArrayList<String>();
            r.add(String.valueOf(root.val));
            result.add(r);
            return result;
        }
        if (root.left != null) {
            List<List<String>> next = findPathHelper(root.left);
            for(List<String> l : next) {
                l.add(String.valueOf(root.val));
                result.add(l);
            }
        }
        if (root.right != null) {
            List<List<String>> next = findPathHelper(root.right);
            for(List<String> l : next) {
                l.add(String.valueOf(root.val));
                result.add(l);
            }
        }
        return result;
    }
    
    private List<String> parseResult(List<List<String>> list) {
        List<String> result = new ArrayList<String>();
        for(List<String> l : list) {
            StringBuilder tmp = new StringBuilder();
            for(int i = l.size()-1; i>=0; i--) {
                if (tmp.length() == 0) {
                    tmp.append(l.get(i));    
                } else {
                    tmp.append("->");
                    tmp.append(l.get(i));
                }
            }
            result.add(tmp.toString());
        }
        return result;
    }
}
