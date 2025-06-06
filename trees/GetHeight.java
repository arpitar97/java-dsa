package trees;

public class GetHeight {
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static int getHeight(TreeNode<Integer> root) {
		
		if(root==null) {
			return 0;
		}
		
		int height = 0;
		
		for(int i=0 ; i<root.children.size(); i++) {
			
			int ans = getHeight(root.children.get(i));
			
			if(ans>height) {
				height=ans;
			}
		}
		
		return height+1;
	}

}
