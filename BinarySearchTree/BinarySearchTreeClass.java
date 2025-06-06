
public class BinarySearchTreeClass {
	
	private BinaryTreeNode<Integer> root;
	
	public void insert(int data) {
		//Implement the insert() function
		root = insert(root,data);
	}
	
	//Time complexity : O(H)
	//Space complexity : O(H)
	private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
		
		if(root==null) {
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
			return newNode;
		}
		
		if(data<=root.data) {
			root.left = insert(root.left,data);
		}
		
		else {
			root.right = insert(root.right,data);
		}
		
		return root;
	}

	public void remove(int data) {
		//Implement the remove() function
		root = remove(root,data);
	}
	
	//Time complexity : O(H)
	//Space complexity : O(H)
	private BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root2, int data) {
		
		if(root==null) {
			return null;
		}
		
		if(data==root.data) {
			
			if(root.left==null && root.right==null) {
				return null;
			}
			
			else if(root.left==null) {
				return root.right;
			}
			
			else if(root.right==null) {
				return root.left;
			}
			
			else {
				BinaryTreeNode<Integer> minNode = root.right;
				while(minNode.left!=null) {
					minNode=minNode.left;
				}
				root.data=minNode.data;
				root.right = remove(root.right,minNode.data);
			}
			
		}
		
		else if(data<root.data) {
			root.left = remove(root.left,data);
		}
		
		else {
			root.right = remove(root.right,data);
		}
		
		return root;
	}

	public void printTree() {
		//Implement the printTree() function
		printTree(root);
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	private void printTree(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		System.out.print(root.data + ":"); 
		
		if (root.left != null) { 
			
			System.out.print("L:" + root.left.data + ","); 
			
		} 
		
		if (root.right != null) { 
			
			System.out.print("R:" + root.right.data); 
			
		} 
		
		System.out.println(); 
		
		printTree(root.left); 
		
		printTree(root.right);
		
	}

	public boolean search(int data) {
		//Implement the search() function
		return search(root,data);
	}

	//Time complexity : O(H)
	//Space complexity : O(H)
	private boolean search(BinaryTreeNode<Integer> root, int data) {
		
		if(root==null) {
			return false;
		}
		
		if(root.data==data) {
			return true;
		}
		
		if(data<root.data) {
			return search(root.left,data);
		}
		
		else {
			return search(root.right,data);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
