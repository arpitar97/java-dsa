package trees;

public class CheckIfContainsX {
	
	//Time complexity : O(N)
	//Space complexity : O(H) where H = height of tree
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x) {
		
		if(root==null) {
			return false;
		}
		
		if(root.data==x) {
			return true;
		}
		
		for(TreeNode<Integer> child : root.children) {
			
			if(checkIfContainsX(child, x)) {
				return true;
			}
			
		}
		
		return false;
	}

}
