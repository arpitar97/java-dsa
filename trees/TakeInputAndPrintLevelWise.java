package trees;

import java.util.Scanner;

import queue.QueueEmptyException;

public class TakeInputAndPrintLevelWise {
	
	//Time Complexity : 0(N)
	//Space Complexity : 0(N)
	public static TreeNode<Integer> takeInputLevelWise(){
		
		Scanner s = new Scanner(System.in);
		
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		
		System.out.println("Enter root node data: ");
		
		int rootData = s.nextInt();
		
		TreeNode<Integer> root = new TreeNode<>(rootData);
		
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			
			try {
				
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				
				System.out.println("Enter number of children of node " + frontNode.data);
				
				int numChildren = s.nextInt();
				
				for(int i=0; i<numChildren; i++) {
					
					System.out.println("Enter "+(i+1)+"th child of "+frontNode.data);
					
					int child = s.nextInt();
					
					TreeNode<Integer> childNode = new TreeNode<>(child);
					
					frontNode.children.add(childNode);
					
					pendingNodes.enqueue(childNode);
					
				}
				
			} catch (QueueEmptyException e) {
				
				// Will never reach here in this exception
				
				return null;
			}
			
		}
		
		return root;
	}
	
	//Time complexity : O(N)
	//Space Complexity: O(N)
	public static void printLevelWise(TreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		
		pendingNodes.enqueue(root);
		
		pendingNodes.enqueue(null);
		
		System.out.println(root.data);
		
		while(pendingNodes.size()!=1) {
			
			TreeNode<Integer> frontNode = null;
			
			try {
				frontNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(frontNode==null) {
				pendingNodes.enqueue(null);
				System.out.println();
				continue;
			}
			
			int numChildren = frontNode.children.size();
			
			for(int i=0; i<numChildren; i++) {
				System.out.print(frontNode.children.get(i).data+" ");
				pendingNodes.enqueue(frontNode.children.get(i));
			}
			
		}
	}
	
	public static void print(TreeNode<Integer> root) {
		
	}
	
	public static void main(String[] args) {
		
		TreeNode<Integer> root = takeInputLevelWise();
		printLevelWise(root);
		System.out.println(NumberOfNodes.numNode(root));
	}
	
	
	
	
	
	
}
