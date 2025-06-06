package trees;

public class NextlargerElement {

	//Time complexity : O(N)
	//Space complexity : O(H)
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		
		if(root==null) {
			return null;
		}
		
		TreeNode<Integer> ans = null;
		
		if(root.data>n) {
			ans=root;
		}
		
		for(TreeNode<Integer> child : root.children) {
			TreeNode<Integer> childAns = findNextLargerNode(child, n);
			
			if(childAns!=null) {
				
				if(ans==null || childAns.data<ans.data){
					ans=childAns;
				}
			}
		}
		return ans;
	}
}
