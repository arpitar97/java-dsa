package trees;

import java.util.Scanner;

public class TakeInputAndPrintRecursively {
	
	public static Scanner s = new Scanner(System.in);
	
	
	
	//Time Complexity : 0(N)
	//Space Complexity : 0(N)
	public static TreeNode<Integer> takeInput(Scanner s){
		
		System.out.println("Enter next node data");
		
		int n = s.nextInt();
		
		TreeNode<Integer> root = new TreeNode<>(n);
		
		System.out.println("Enter number of children of node " + n);
		
		int childCount = s.nextInt();
		
		for(int i=0; i<childCount; i++) {
			
			TreeNode<Integer> child = takeInput(s);
			
			root.children.add(child);
			
		}
		
		return root;
		
	}
	
	//Time Complexity : 0(N^2)
	//Space Complexity : 0(N)
	public static void print(TreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		String s = root.data+":";
		
		for(int i=0; i<root.children.size(); i++) {
			s=s+root.children.get(i).data+",";
		}
		
		System.out.println(s);
		
		for(int i=0; i<root.children.size(); i++){
			print(root.children.get(i));
		}
		
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = takeInput(s);
		print(root);
		
	}

}
