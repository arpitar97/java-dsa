package trees;

public class SumOfNodes {
	
	public static int sumNodes(TreeNode<Integer> root) {
		
		if(root==null) {
			return 0;
		}
		
		int sum=0;
		
		for(int i=0; i<root.children.size(); i++) {
			sum+=sumNodes(root.children.get(i));
		}
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
