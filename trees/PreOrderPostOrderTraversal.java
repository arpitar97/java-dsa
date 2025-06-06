package trees;

public class PreOrderPostOrderTraversal {
	
	//Time complexity : O(N)
	//Space complexity : O(H)  H = height/depth of tree
	
	public static void printPreOrder(TreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		System.out.print(root.data+" ");
		
		for(int i=0; i<root.children.size(); i++) {
			printPreOrder(root.children.get(i));
		}
		
	}
	
	public static void printPostOrder(TreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		for(int i=0; i<root.children.size(); i++) {
			printPostOrder(root.children.get(i));
		}
		
		System.out.println(root.data + " ");
		
	}

}
