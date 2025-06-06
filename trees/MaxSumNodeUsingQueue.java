package trees;

import queue.QueueEmptyException;

public class MaxSumNodeUsingQueue {
	
	//Time complexity : O(N)
	//Space Complexity : O(N)
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		
		int sum = Integer.MIN_VALUE;
		
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		
		pendingNodes.enqueue(root);
		
		pendingNodes.enqueue(null);
		
		TreeNode<Integer> ansNode = null;
		
		while(pendingNodes.size()!=1) {
			
			TreeNode<Integer> frontNode = null;
			
			try {
				 frontNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				e.printStackTrace();
			}
			
			if(frontNode == null) {
				pendingNodes.enqueue(null);
				continue;
			}
			
			int ans = frontNode.data;
			
			for(int i=0; i<frontNode.children.size(); i++) {
				ans+=frontNode.children.get(i).data;
				pendingNodes.enqueue(frontNode.children.get(i));
			}
			
			if(ans>sum) {
				sum = ans;
				ansNode = frontNode;
			}
			
		}
		
		return ansNode;
	}

}
