package trees;

public class NumNodesGreater {
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static int numNodesGreater(TreeNode<Integer> root, int x) {
		
		if(root==null) {
			return 0;
		}
		
		int count=0;
		
		if(root.data>x) {
			count=1;
		}
		
		for(int i=0; i<root.children.size(); i++) {
			count+=numNodesGreater(root.children.get(i),x);
		}
		
		return count;
	}

}
