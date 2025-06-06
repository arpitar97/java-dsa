package binaryTrees;

import java.util.ArrayList;
import java.util.Scanner;

import pack1.QueueEmptyException;
import pack1.QueueUsingLL;

public class BinaryTreeUse {
	
	public static BinaryTreeNode<Integer> takeInput(Scanner s){
		
		int rootData;
		
		System.out.println("Enter root data");
		
		rootData=s.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		root.left=takeInput(s);
		
		root.right=takeInput(s);
		
		return root;
		
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter root data");
		
		int rootData = s.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			
			BinaryTreeNode<Integer> front;
			
			try {
				
				front = pendingNodes.dequeue();
				
			} catch (QueueEmptyException e) {
				
				return null;
				
			}
			
			System.out.println("Enter left child of " + front.data);
			
			int leftChild=s.nextInt();
			
			if(leftChild!=-1) {
				
				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
				
				pendingNodes.enqueue(child);
				
				front.left=child;
				
			}
			
			
	        System.out.println("Enter right child of " + front.data);
			
			int rightChild=s.nextInt();
			
			if(rightChild!=-1) {
				
				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);
				
				pendingNodes.enqueue(child);
				
				front.right=child;
				
			}
			
			
		}
		
		return root;
		
		
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			
			BinaryTreeNode<Integer> front ;
			
			try {
				
				front = pendingNodes.dequeue();
				
			} catch (QueueEmptyException e) {
				
				return;
			}
			
			String toBePrinted = front.data+":";
			
			if(front.left!=null) {
				
				toBePrinted+="L:"+front.left.data+",";
				pendingNodes.enqueue(front.left);
				
			}
			
			else {
				toBePrinted+="L:"+ -1 +",";
			}
			
            if(front.right!=null) {
				
				toBePrinted+="R:"+front.right.data;
				pendingNodes.enqueue(front.right);
				
			}
			
			else {
				toBePrinted+="R:"+ -1 ;
			}
            
            System.out.println(toBePrinted);
			
			
		}
		
		
		
	}
	
	public static void printTree(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		String toBePrinted = root.data + ": ";
		
		if(root.left!=null) {
			
			toBePrinted+="L:" + root.left.data + ",";
			
		}
		
        if(root.right!=null) {
			
			toBePrinted+="R:" + root.right.data;
			
		}
        
        System.out.println(toBePrinted);
        
        printTree(root.left);
        
        printTree(root.right);
		
		
		
	}
	
	public static int countNodes(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return 0;
		}
		
		int ans=1;
		
		ans+=countNodes(root.left);
		
		ans+=countNodes(root.right);
		
		return ans;
		
		
	}
	
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    //Your code goes here
        
        if(root == null){
            return false;
        }
        
        if(root.data==x){
            return true;
        }
        
        boolean ans;
        
        ans=isNodePresent(root.left,x);
        
        if(ans){
            return true;
        }
        
        ans=isNodePresent(root.right,x);
        
        return ans;
        
	}
	
public static int height(BinaryTreeNode<Integer> root) {
	
        
        if(root == null){
            return 0;
        }
        
        
        int count = 0;
        
        int a =height(root.left);
        
        int b=height(root.right);
        
        if(a>b){
            count=a;
        }
        
        else{
            count=b;
        }
        
        return count+1;
        
	}

public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
	//Your code goes here
    
    if(root == null){
        return;
    }
    
    if(root.left==null && root.right==null){
        return;
    }
    
    BinaryTreeNode<Integer> temp=root.left;
    
    root.left=root.right;
    
    root.right=temp;
    
    mirrorBinaryTree(root.left);
    
    mirrorBinaryTree(root.right);
    
}

public static Pair<Integer,Integer> heightDiameter(BinaryTreeNode<Integer> root){
	
	if(root == null) {
		
		Pair<Integer,Integer> output = new Pair<>();
		output.first=0;
		output.second=0;
		return output;
		
	}
	
	Pair<Integer,Integer> lo = heightDiameter(root.left);
	
	Pair<Integer,Integer> ro = heightDiameter(root.right);
	
	int height=1+Math.max(lo.first, ro.first);
	
	int option1 = lo.first+ro.first;
	
	int option2 = lo.second;
	
	int option3 = ro.second;
	
	int diameter = Math.max(option1, Math.max(option2, option3));
	
	Pair<Integer,Integer> ans = new Pair<>();
	
	ans.first=height;
	
	ans.second=diameter;
	
	return ans;
	
	
	
}
	
public static void inorderPrint(BinaryTreeNode<Integer> root) {
	
	if(root == null) {
		return;
	}
	
	
	inorderPrint(root.left);
	
	System.out.print(root.data + " ");
	
	inorderPrint(root.right);
	
}

public static void levelOrderTraversal(BinaryTreeNode<Integer> root) {
	
	if(root==null) {
		return;
	}
	
	QueueUsingLL<BinaryTreeNode<Integer>> q = new QueueUsingLL<>();

	q.enqueue(root);
	
	q.enqueue(null);
	
	while(!q.isEmpty()) {
		
		BinaryTreeNode<Integer> front = null;
		
		try {
			front=q.dequeue();
		} catch (QueueEmptyException e) {
			
			e.printStackTrace();
		}
		
		if(front==null) {
			System.out.println();
			
			if(!q.isEmpty()) {
				q.enqueue(null);
			}
		}
		
		else {
			
			System.out.print(front.data + " ");
			
			if(front.left!=null) {
				q.enqueue(front.left);
			}
			
			
			if(front.right!=null) {
				q.enqueue(front.right);
			}
			
			
		}
		
		
	}
	
	
}

public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
	
    if(root == null){
        return null;
    }
    
    
	return null;
    
}
	
	
	

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		
//		printLevelWise(root);
		
		levelOrderTraversal(root);
		
//		System.out.println(countNodes(root));
		
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//
//		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
//
//		root.left=node1;
//		
//		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
//
//		root.right=node2;
		
	}

}
