package trees;

import java.util.Scanner;

import pack1.QueueEmptyException;
import pack1.QueueUsingLL;

public class TreeUse1 {
	
	public static TreeNode<Integer> takeInputLevelWise(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter tree rote node data");
		
		int n = s.nextInt();
		
		TreeNode<Integer> root = new TreeNode<>(n);
		
		QueueUsingLL<TreeNode<Integer>> pendingNode = new QueueUsingLL<>();
		
		pendingNode.enqueue(root);
		
		while(!pendingNode.isEmpty()) {
			
			
			try {
				
				TreeNode<Integer> frontNode = pendingNode.dequeue();
				
				System.out.println("Enter number of children of " + frontNode.data + " data node" );
				
				int childSize=s.nextInt();
				
				for(int i=0; i<childSize; i++) {
					
					System.out.println("Enter "+(i+1)+ " th child of " + frontNode.data + " node" );
					
					int childNodeData=s.nextInt();
							
					TreeNode<Integer> childNode = new TreeNode<>(childNodeData);
					
					pendingNode.enqueue(childNode);
					
					frontNode.children.add(childNode);
					
					
				}
				
			} catch (QueueEmptyException e) {
				
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		return root;
		
	}
	
	private static void printLevelWise(TreeNode<Integer> root) {
	
		QueueUsingLL<TreeNode<Integer>> q1 = new QueueUsingLL<>();
		
		q1.enqueue(root);
		
		while(!q1.isEmpty()) {
			
			try {
				
				TreeNode<Integer> frontNode=q1.dequeue();
				
				String s = frontNode.data + ":";
				
				for(int i=0; i<frontNode.children.size(); i++) {
					
					s=s+frontNode.children.get(i).data+",";
					
					q1.enqueue(frontNode.children.get(i));
					
					
				}
				
				System.out.println(s);
				
				
			} catch (QueueEmptyException e) {
				
				
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
	}
	
	
	private static void printLevelledNodes(TreeNode<Integer> root) {
		
	}
	
public static int sumOfAllNode(TreeNode<Integer> root){
        
        
        if(root==null){
            return 0;
        }
        
        int count=0;
        
        count=root.data;
        
        for(int i=0; i<root.children.size(); i++){
            
            count+=sumOfAllNode(root.children.get(i));
            
        }
	
        return count;
	}

public static int numOfNodes(TreeNode<Integer> root) {
	
	if(root==null) {
		return 0;
	}
	
	int count=1;
	
	for(int i=0; i<root.children.size(); i++) {
		
		count+=numOfNodes(root.children.get(i));
		
	}
	
	return count;
	
}

public static int largestNodeData(TreeNode<Integer> root) {
	
	if(root==null) {
		return Integer.MIN_VALUE;
	}
	
	int ans = root.data;
	
	for(int i=0; i<root.children.size(); i++) {
		
		int childLargest=largestNodeData(root.children.get(i));
		
		if(childLargest>ans) {
			ans=childLargest;
		}
		
		
	}
	
	return ans;
}

public static int numNodeGreater(TreeNode<Integer> root,int x){

	// Write your code here		
    
    if(root==null){
        return 0;
    }
    
    int count=0;
    
    if(root.data>x){
        count+=1;
    }
    
    for(int i=0; i<root.children.size(); i++){
        
        count+=numNodeGreater(root.children.get(i),x);
    }

    return count;
}

//
//public static int getHeight(TreeNode<Integer> root) {
//	
//}

public static void printAtK(TreeNode<Integer> root, int k) {
	
	if(k<0) {
		return;
	}
	
	if(k==0) {
		System.out.println(root.data);
		return;
	}
	
	for(int i=0; i<root.children.size(); i++) {
		
		printAtK(root.children.get(i),k-1);
		
	}
	
	
}

public static int countLeafNodes(TreeNode<Integer> root) {
	
	if(root==null) {
		return 0;
	}
	
	if(root.children.size()==0) {
		return 1;
	}
	
	int count =0;
	
	for(TreeNode<Integer> child : root.children) {
		count+=countLeafNodes(child);
	}
	
	return count;
	
	
	
	
}

public static void preOrderPrint(TreeNode<Integer> root) {
	
	if(root==null) {
		return;
	}
	
	System.out.print(root.data + " ");
	
	for(TreeNode<Integer> child : root.children) {
		
		preOrderPrint(child);
	}
	
	
//	or for(int i=0; i<root.children.size(); i++) {
//		
//		preOrderPrint(root.children.get(i));
//		
//	}
	
	
	
}


public static void printPostOrder(TreeNode<Integer> root){
	
    
    if(root == null){
        return;
    }
    
    for(TreeNode<Integer> child : root.children){
        
        printPostOrder(child);
        
    }
    
    System.out.print(root.data + " ");
    
}
	

	public static void main(String[] args) {
		
		
		TreeNode<Integer> root = takeInputLevelWise();
		
		printLevelWise(root);
		
//		printLevelledNodes(root);
		
//		System.out.println(numOfNodes(root));
//		
//		System.out.println(sumOfAllNode(root));
//		
//		System.out.println(largestNodeData(root));
		
//		printAtK(root,2);
		
		preOrderPrint(root);
		
		

	}



}
