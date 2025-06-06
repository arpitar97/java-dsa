package trees;

public class NumberOfNodes {
	
	//Time Complexity: O(N)
	//Space Complexity: O(N)
	public static int numNode(TreeNode<Integer> root) {
		
		if(root==null) {
			return 0;
		}
		
		int count=1;
		
		for(int i=0; i<root.children.size(); i++) {
			count+=numNode(root.children.get(i));
		}
		
		return count;
	}

}
