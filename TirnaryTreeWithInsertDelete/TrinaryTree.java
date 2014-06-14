
/*Question: Implement insert and delete in a tri-nary tree.  Much like a binary-tree but with 3 child nodes for each parent instead of two ¡ª with the left node being values < parent, the right node values > parent, and the middle node values == parent.  For example, if I added the following nodes to the tree in this
order:  5, 4, 9, 5, 7, 2, 2 ¨C  the tree would look like this:

           5 
          / | \             
         4 5 9 
        /    /  
      2    7 
      | 
      2
      */
public class TrinaryTree {
	private TriNode root;
	public TriNode populate(int [] input) {
		if (input.length == 0)
			return null;
		root = new TriNode(input[0]);
		for (int i = 1; i < input.length; i++) {
			insert(root, input[i]);
		}
		return root;
	}
	
	public void insert(TriNode root, int k) {
		if (root == null)
			root = new TriNode(k);
		if (k < root.data) {
			if (root.left == null)
				root.left = new TriNode(k);
			else
				insert(root.left, k);
		}
		else if (k == root.data) {
			if (root.mid == null)
				root.mid = new TriNode(k);
			else
				insert(root.mid, k);
		}
		else {
			if (root.right == null)
				root.right = new TriNode(k);
			else
				insert(root.right, k);
		}
	}
	/*
	 * @return true only if the current root is the one that need to be deleted
	 */
	public boolean delete(TriNode root, int k) {
		if (root == null)
			return false; // k not found
		if (k < root.data) { // if smaller, go to left sub tree
			if (delete(root.left, k))
				root.left = null;
			return false;
		}
		else if ( k > root.data) { // if greater, go to right subtree
			if (delete(root.right, k))
				root.right = null;
			return false;
		}
		else  {//equals
			if (root.mid != null) {
				if (delete(root.mid, k))
					root.mid = null;
				return false;
			}
			else if (root.left == null && root.right == null && root.mid == null) { //only leaf node return true;
				return true;
			}
			else if (root.left != null) {
				root.data = findMax(root.left);
				if (delete(root.left, root.data))
					root.left = null;
				return false;
			}
			else {//if (root.right != null
				root.data = findMin(root.right);
				if (delete(root.right, root.data))
					root.right = null;
				return false;
			}
		}
	}
	
	public int findMin (TriNode root) {
		if (root.left == null)
			return root.data;
		return findMin(root.left);
	}
	
	public int findMax(TriNode root) {
		if (root.right == null)
			return root.data;
		return findMax(root.right);
	}
	
	public static void main(String[] args) {
		int [] q = {5, 4, 9, 5, 7, 2, 2};
		TrinaryTree tt = new TrinaryTree();
		tt.populate(q);
		TriNode root = tt.root;
		tt.delete(root, 5);
		tt.delete(root, 2);
		tt.delete(root, 9);
	}
}
