package trees;

public class LargestData {
	
	//Time complexity : O(N)
	//Space complexity: O(N)
	public static int largest(TreeNode<Integer> root) {
		
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		
		int ans = root.data;
		
		for(int i=0; i<root.children.size(); i++) {
			
			int childLargest = largest(root.children.get(i));
			
			if(childLargest>ans) {
				ans=childLargest;
			}
			
		}
		
		return ans;
		
	}

}
