package trees;

import java.util.Scanner;

import pack1.QueueEmptyException;
import pack1.QueueUsingLL;

public class TreeUse {

	
	Scanner s = new Scanner(System.in);
	
	private static TreeNode<Integer> takeInput(Scanner s) {
        	
		int n;
		
		System.out.println("Enter next node data");
		
		n=s.nextInt();
		
		TreeNode<Integer> root = new TreeNode<>(n);
		
		System.out.println("Enter number of children for " + n);
		
		int childCount = s.nextInt();
		
		for(int i=0; i<childCount; i++) {
			
			TreeNode<Integer> child = takeInput(s);
			
			root.children.add(child);
			
		}
		
		return root;
	}
	
	private static void print(TreeNode<Integer> root) {
		
		String s = root.data + ":";
		
		for(int i=0; i<root.children.size(); i++) {
			
			s=s+root.children.get(i).data + ",";
		}
		
		System.out.println(s);
		
		for(int i=0; i<root.children.size(); i++) {
			print(root.children.get(i));
		}
		
	}
	
	private static TreeNode<Integer> takeInputLevelWise() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter root node data:");
		
		int rootData=s.nextInt();
		
		TreeNode<Integer> root = new TreeNode<>(rootData);
		
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				
				System.out.println("Enter no of children of node:" + frontNode.data);
				
				int numChildren=s.nextInt();
				
				for(int i=0; i<numChildren; i++) {
					
					System.out.println("Enter " + (i+1) + "th child of:" + frontNode.data);
					
					int child=s.nextInt();
					
					TreeNode<Integer> childNode = new TreeNode<>(child);
					
					pendingNodes.enqueue(childNode);
					
					frontNode.children.add(childNode);
					
				}	
					
				
				
			} catch (QueueEmptyException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
		
		
		return root;
	}
	
	
	
	private static void printLevelWise(TreeNode<Integer> root) {
		
		QueueUsingLL<TreeNode<Integer>> p1 = new QueueUsingLL<>();
		
		p1.enqueue(root);
		
		while(!p1.isEmpty()) {
			
			try {
				TreeNode<Integer> frontNode = p1.dequeue();
				
				String s = frontNode.data + ":" ;
				
				for(int i=0; i<frontNode.children.size();i++) {
					
					s=s+frontNode.children.get(i).data+",";
					
					p1.enqueue(frontNode.children.get(i));
					
				}
				
				System.out.println(s);
				
			} catch (QueueEmptyException e) {
			
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public static void printTreeLevelWiseBetter(TreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		QueueUsingLL<TreeNode<Integer>> q = new QueueUsingLL<>();
		
		q.enqueue(root);
		
		q.enqueue(null);
		
		System.out.println(root.data);
		
		while(q.getSize()!=1) {
			
			TreeNode<Integer> temp = null;
			
			try {
			    temp=q.dequeue();
			} catch (QueueEmptyException e) {
				
				e.printStackTrace();
			}
			
			if(temp==null) {
				
				q.enqueue(null);
				System.out.println();
				continue;
			}
			
			for(int i=0; i<temp.children.size(); i++) {
				System.out.print(temp.children.get(i).data + " ");
				q.enqueue(temp.children.get(i));
			}
			
		}
		
		
	}



	public static void main(String[] args) {
		
		
		
//		TreeNode<Integer> root = takeInput(s);
		
		TreeNode<Integer> root = takeInputLevelWise();
		
		printTreeLevelWiseBetter(root);
		
//		print(root);
		

		
		
		
		
//		TreeNode<Integer> root = new TreeNode<>(4);
//		
//		TreeNode<Integer> node1 = new TreeNode<>(2);
//
//		TreeNode<Integer> node2 = new TreeNode<>(3);
//
//		TreeNode<Integer> node3 = new TreeNode<>(5);
//
//		TreeNode<Integer> node4 = new TreeNode<>(6);
//		
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		
//		node2.children.add(node4);
//		
//		
//		System.out.print(root);
		



	}

	



	


}
