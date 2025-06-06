package trees;



public class MaxSumNodeUsingPairClass {
	
	
	//Time complexity : O(N)
	//Space complexity : O(H) where H = height of tree
	static class MaxNodePair<T>{
		int sum;
		TreeNode<T> node;
	}
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		
		if(root==null) {
			return null;
		}
		
		return maxSuMNodeHelper(root).node;
	}
	
	
	public static MaxNodePair<Integer> maxSuMNodeHelper(TreeNode<Integer> root){
		
		if(root==null) {
			MaxNodePair<Integer> ans = new MaxNodePair<>();
			ans.node=null;
			ans.sum=Integer.MIN_VALUE;
			return ans;
		}
		
		int sum = root.data;
		
		MaxNodePair<Integer> ans = new MaxNodePair<>();
		
		for(TreeNode<Integer> child : root.children) {
			sum+=child.data;
		}
		
		ans.node=root;
		ans.sum=sum;
		
		for(TreeNode<Integer> child : root.children) {
			
			MaxNodePair<Integer> childAns =  maxSuMNodeHelper(child);
			
			if(childAns.sum>ans.sum) {
				ans=childAns;
			}
			
		}
		
		return ans;
		
	}

}
