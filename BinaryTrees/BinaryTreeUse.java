import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Pair<T,V>{
	T first;
	V second;
}

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}


public class BinaryTreeUse {
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static BinaryTreeNode<Integer> takeInput(Scanner s) {
		
		int rootData;
		
		System.out.println("Enter root data:");
		
		rootData = s.nextInt();
		
		if(rootData==-1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		root.left = takeInput(s);
		
		root.right = takeInput(s);
		
		return root;
	}
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter root data:");
		
		int rootData = s.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			
			BinaryTreeNode<Integer> front;
			
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			
			System.out.println("Enter left child of "+front.data);
			
			int leftChild = s.nextInt();
			
			if(leftChild!=-1) {
				
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
				
				front.left = child;
				
				pendingNodes.enqueue(child);
			}
			
			
			System.out.println("Enter right child of "+front.data);
			
			int rightChild = s.nextInt();
			
			if(rightChild!=-1) {
				
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				
				front.right = child;
				
				pendingNodes.enqueue(child);
			}
			
		}
		
		return root;
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static void printTree(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		String toBePrinted = root.data+":";
		
		if(root.left!=null) {
			toBePrinted+="L:"+root.left.data+", ";
		}
		
		if(root.right!=null) {
			toBePrinted+="R:"+root.right.data;
		}
		
		System.out.println(toBePrinted);
		
		printTree(root.left);
		
		printTree(root.right);
		
	}
	
	//Time complexity : O(N)
		//Space complexity : O(N)
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		
		pendingNodes.enqueue(root);
		
		String toBePrinted = "";
		
		while(!pendingNodes.isEmpty()) {
			
			toBePrinted="";
			
			BinaryTreeNode<Integer> front;
			
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return;
			}
			
			toBePrinted+=front.data+":";
			
			if(front.left!=null) {
				toBePrinted+="L:"+front.left.data+",";
				pendingNodes.enqueue(front.left);
			}
			
			else {
				toBePrinted+="L:-1,";
			}
			
			
			if(front.right!=null) {
				toBePrinted+="R:"+front.right.data;
				pendingNodes.enqueue(front.right);
			}
			
			else {
				toBePrinted+="R:-1";
			}
			
			System.out.println(toBePrinted);
			
		}
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static int countNodes(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return 0;
		}
		
		int ans = 1;
		
		ans += countNodes(root.left);
		
		ans += countNodes(root.right);
		
		return ans;
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static int height(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return 0;
		}
		
		return 1+Math.max(height(root.left), height(root.right));
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		BinaryTreeNode<Integer> temp = root.left;
		
		root.left = root.right;
		
		root.right = temp;
		
		mirrorBinaryTree(root.left);
		
		mirrorBinaryTree(root.right);
		
	}
	
	//Time complexity : O(N*Height) = O(N*logN) || O(N^2) depending upon structure of tree
	//Space complexity : O(H)
	public static int diameter(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return 0;
		}
		
		int opt1 = height(root.left) + height(root.right);
		
		int opt2 = diameter(root.left);
		
		int opt3 = diameter(root.right);
		
		return Math.max(opt1, Math.max(opt2, opt3));
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static Pair<Integer,Integer> heightDiameter(BinaryTreeNode<Integer> root){
		
		if(root == null) {
			
			Pair<Integer,Integer> output = new Pair<>();
			
			output.first=0;
			
			output.second=0;
			
			return output;
		}
		
		Pair<Integer,Integer> lo = heightDiameter(root.left);
		
		Pair<Integer,Integer> ro = heightDiameter(root.right);
		
		Pair<Integer,Integer> output = new Pair<>();
		
		int height = 1 + Math.max(lo.first, ro.first);
		
		int opt1 = lo.first + ro.first;
		
		int opt2 = lo.second;
		
		int opt3 = ro.second;
		
		int diameter = Math.max(opt1, Math.max(opt2, opt3));
		
		output.first = height;
		
		output.second = diameter;
		
		return output;
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
		
		if(root == null) {
			return false;
		}
		
		if(root.data == x) {
			return true;
		}
    
        if(isNodePresent(root.left,x)){
            return true;
        }
        
        return isNodePresent(root.right,x);
		
	}

	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static void inOrder(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		
		System.out.print(root.data+" ");
		
		inOrder(root.right);
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static void preOrder(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		System.out.print(root.data+" ");
		
		preOrder(root.left);
		
		preOrder(root.right);
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static void postOrder(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		
		postOrder(root.right);
		
		System.out.print(root.data+" ");
		
	}
	
	//Time complexity : O(N*H)
	//Space complexity : O(H)
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		
		int n = preOrder.length;
		
		int preStart = 0;
		
		int preEnd = n-1;
		
		int inStart = 0;
		
		int inEnd = n-1;
		
		
		return buildTreeHelper(preOrder, preStart, preEnd, inOrder, inStart, inEnd);
		
	}
	
	private static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int preStart, int preEnd,  int[] inOrder, int inStart, int inEnd) {
		
		if(preStart > preEnd || inStart > inEnd) {
			
			return null;
			
		}
		
		int rootData = preOrder[preStart];
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		
		int index = -1;
		
		for(int i=inStart; i<=inEnd; i++) {
			
			if(inOrder[i]==rootData) {
				
				index=i;
				
				break;
				
			}
		}
		
		int length = index - inStart;
		
		root.left = buildTreeHelper(preOrder, preStart+1, preStart+length, inOrder, inStart, index-1);
		
		root.right = buildTreeHelper(preOrder, preStart+length+1, preEnd ,inOrder, index+1, inEnd);
		
		return root;
		
	}
	
	//Time complexity : O(N*H)
	//Space complexity : O(H)
    public static BinaryTreeNode<Integer> buildTreeTwo(int[] postOrder, int[] inOrder) {
		
		int n = postOrder.length;
		
		int postStart = 0;
		
		int postEnd = n-1;
		
		int inStart = 0;
		
		int inEnd = n-1;
		
		return buildTreeHelperTwo(postOrder, postStart, postEnd, inOrder, inStart, inEnd);
		
	}
	
	private static BinaryTreeNode<Integer> buildTreeHelperTwo(int[] postOrder, int postStart, int postEnd,  int[] inOrder, int inStart, int inEnd) {
		
		if(postStart > postEnd || inStart > inEnd) {
			
			return null;
			
		}
		
		int rootData = postOrder[postEnd];
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		
		int index = -1;
		
		for(int i=inStart; i<=inEnd; i++) {
			
			if(inOrder[i]==rootData) {
				
				index=i;
				
				break;
				
			}
		}
		
		int length = index - inStart;
		
		root.left = buildTreeHelperTwo(postOrder, postStart, postStart+length-1, inOrder, inStart, index-1);
		
		root.right = buildTreeHelperTwo(postOrder, postStart+length, postEnd-1 ,inOrder, index+1, inEnd);
		
		return root;
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static int getSum(BinaryTreeNode<Integer> root) {
		 
        if(root == null){
            return 0;
        }
        
        int ans = root.data;
        
        ans+=getSum(root.left);
        
        ans+=getSum(root.right);
        
        return ans;
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static boolean checkBalancedBetter(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			return true;
		}
		
		return checkBalancedBetterHelper(root).first;
		
	}
	
    public static Pair<Boolean,Integer> checkBalancedBetterHelper(BinaryTreeNode<Integer> root) {
		
    	if(root == null) {
    		
    		Pair<Boolean,Integer> ans = new Pair<>();
    		
    		ans.first=true;
    		
    		ans.second=0;
    		
    		return ans;
    	}
    	
    	Pair<Boolean,Integer> ls = checkBalancedBetterHelper(root.left);
    	
    	Pair<Boolean,Integer> rs = checkBalancedBetterHelper(root.right);
    	
    	Pair<Boolean,Integer> output = new Pair<>();
    	
    	output.second = 1 + Math.max(ls.second, rs.second);
    	
    	output.first = ls.first && rs.first && ls.second-rs.second>=-1 && ls.second-rs.second<=1;
    	
    	return output;
    	
	}
	
	//Time complexity : O(N*H)
	//Space complexity : O(H)
	public static boolean checkBalanced(BinaryTreeNode<Integer> root) {
		
        if(root==null){
            return true;
        }
        
        int lh = height(root.left);
        
        int rh = height(root.right);
        
        if(lh-rh>1 || lh-rh<-1){
            return false;
        }
        
        return checkBalanced(root.left) && checkBalanced(root.right);
	}
	

	//Time complexity : O(N)
	//Space complexity : O(N)
	public static void printLevel(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		
		pendingNodes.add(root);
		
		pendingNodes.add(null);
		
		while(!pendingNodes.isEmpty()) {
			
			BinaryTreeNode<Integer> frontNode  = pendingNodes.poll();
			
			if(frontNode == null) {
				
				System.out.println();
				
				if(!pendingNodes.isEmpty()) {
					
					pendingNodes.add(null);
					
				}
			}
			
			else {
				
				System.out.print(frontNode.data+" ");
				
				if(frontNode.left!=null) {
					pendingNodes.add(frontNode.left);
				}
				
				if(frontNode.right!=null) {
					pendingNodes.add(frontNode.right);
				}
				
			}
		}
		
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root){
		
		if(root == null) {
			return null;
		}
		
		if(root.left==null && root.right==null) {
			return null;
		}
		
		root.left = removeAllLeaves(root.left);
		
		root.right = removeAllLeaves(root.right);
		
		return root;
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		if(root.left==null && root.right!=null) {
			System.out.print(root.right.data+" ");
		}
		
		else if(root.left!=null && root.right==null) {
			System.out.println(root.left.data+" ");
		}
		
		printNodesWithoutSibling(root.left);
		
		printNodesWithoutSibling(root.right);
		
		
	}

	//Time complexity : O(N)
	//Space complexity : O(N)
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		// Write your code here
        
        
        if(root==null){
            return null;
        }
        
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        
        pendingNodes.enqueue(root);
        
        pendingNodes.enqueue(null);
        
        LinkedListNode<Integer> head = null;
        
        LinkedListNode<Integer> tail = null;
        
        ArrayList<LinkedListNode<Integer>> ans = new ArrayList<>();
        
        while(!pendingNodes.isEmpty()){
            
            BinaryTreeNode<Integer> frontNode = null;
            
            try{
                frontNode = pendingNodes.dequeue();
            }
            
            catch(QueueEmptyException e){
                return null;
            }
            
            if(frontNode == null){
                
                if(!pendingNodes.isEmpty()){
                    pendingNodes.enqueue(null);
                    head=null;
                    tail=null;
                }
                continue;
            }
            
            if(frontNode.left!=null){
                pendingNodes.enqueue(frontNode.left);
            }
            
            
            if(frontNode.right!=null){
                pendingNodes.enqueue(frontNode.right);
            }
            
            LinkedListNode<Integer> node = new LinkedListNode<>(frontNode.data);
            
            if(head==null){
                head=node;
                tail=node;
                ans.add(head);
            }
            
            else{
                tail.next=node;
                tail=tail.next;
            }
            
        }
        
        return ans;
	}
	
	//Time complexity : O(N)
    //Space complexity : O(N)
	public static void printZigZag(BinaryTreeNode<Integer> root){

        Stack<BinaryTreeNode<Integer>> st = new Stack<>();
        
        QueueUsingLL<BinaryTreeNode<Integer>> q = new QueueUsingLL<>();
        
        int level = 1;
        
        q.enqueue(root);
        
        while(!q.isEmpty()){
            
            BinaryTreeNode<Integer> frontNode = null;
            
            try{
                frontNode = q.dequeue();
            }
            
            catch(QueueEmptyException e){
                return;
            }
            
            System.out.print(frontNode.data+" ");
            
            if(level%2==0){
                
                if(frontNode.right!=null){
                    st.push(frontNode.right);
                }
                
                if(frontNode.left!=null){
                    st.push(frontNode.left);
                }
                
            }
            
            else{
               
                 if(frontNode.left!=null){
                    st.push(frontNode.left);
                 }
                
                 if(frontNode.right!=null){
                    st.push(frontNode.right);
                }
                
            }
            
            if(q.isEmpty()){
                
                while(!st.isEmpty()){
                    
                    q.enqueue(st.pop());
                    
                }
                
                System.out.println();
                
                level++;

            }
    
        }
	}
	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
//		
//		BinaryTreeNode<Integer> root = takeInputLevelWise();
//		
//		s.close();
//		
//		printTree(root);
		
		BinaryTreeNode<Integer> r = new BinaryTreeNode<Integer>(1);

		BinaryTreeNode<Integer> a = new BinaryTreeNode<Integer>(2);

		BinaryTreeNode<Integer> g = new BinaryTreeNode<Integer>(13);

		BinaryTreeNode<Integer> c = new BinaryTreeNode<Integer>(4);

		BinaryTreeNode<Integer> f = new BinaryTreeNode<Integer>(5);
		
		List<BinaryTreeNode<Integer>> lll = new ArrayList<>();
		
		lll.add(f);
		lll.add(c);
		lll.add(a);
		lll.add(r);
		
		for(BinaryTreeNode<Integer> aaa : lll) {
			printZigZag(aaa);
			System.out.println(aaa);
		}
		
		

		
	}

}
