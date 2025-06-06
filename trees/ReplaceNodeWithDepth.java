package trees;

public class ReplaceNodeWithDepth {
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static void replaceWithDepthValue(TreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		replaceWithDepthValue(root,0);
	}

	private static void replaceWithDepthValue(TreeNode<Integer> root, int depth) {
		
		root.data=depth;
		
		for(TreeNode<Integer> child : root.children) {
			
			replaceWithDepthValue(child, depth+1);
			
		}
		
	}
	
	

}
