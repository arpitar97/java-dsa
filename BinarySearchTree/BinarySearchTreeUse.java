import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTreeUse {
	
	static class isBSTReturn{
		
		boolean isBST;
		int min;
		int max;
	}
	
	
    static class Pair{
        LinkedListNode<Integer> head;
        LinkedListNode<Integer> tail;
    }
    
    
    static class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
    		this.data = data;
    	}
    }

	
	
	//Time complexity : O(H)
	//Space complexity : O(H) where H is height of BST
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		
		if(root==null) {
			return false;
		}
		
		if(root.data==k) {
			return true;
		}
		
		if(k<root.data) {
			return searchInBST(root.left,k);
		}
		
		return searchInBST(root.right, k);
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		
		if(root==null) {
			return;
		}
		
		if(root.data>=k1 && root.data<=k2) {
			elementsInRangeK1K2(root.left, k1, k2);
			System.out.print(root.data+" ");
			elementsInRangeK1K2(root.right, k1, k2);
			
		}
		
		else if(root.data<k1) {
			elementsInRangeK1K2(root.right, k1, k2);
		}
		
		else {
			elementsInRangeK1K2(root.left, k1, k2);
		}
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	private static boolean isBST(BinaryTreeNode<Integer> root, int min, int max) {
		
		if(root==null) {
			return true;
		}
		
		if(root.data<min || root.data>max) {
			return false;
		}
		
		boolean ls = isBST(root.left, min, root.data-1);
		
		if(!ls) {
			return false;
		}
		
		boolean rs = isBST(root.right, root.data, max);
		
		return ls && rs;
	}
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		
		return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	private static isBSTReturn isBST2Class(BinaryTreeNode<Integer> root) {
		
		if(root == null) {
			
			isBSTReturn output =  new isBSTReturn();
			
			output.isBST = true;
			
			output.min = Integer.MAX_VALUE;
			
			output.max = Integer.MIN_VALUE;
			
		}
		
		isBSTReturn leftOutput = isBST2Class(root.left);
		
		isBSTReturn rightOutput = isBST2Class(root.right);
		
		isBSTReturn output = new isBSTReturn();
		
		int min = Math.min(root.data, Math.min(leftOutput.min, rightOutput.min));
		
		int max = Math.max(root.data, Math.max(leftOutput.max, rightOutput.max));
		
		output.isBST = leftOutput.isBST && rightOutput.isBST && root.data>leftOutput.max && root.data<=rightOutput.min;
		
		output.max = max;
		
		output.min = min;
		
		return output;
		
	}
	
	public static boolean isBST2(BinaryTreeNode<Integer> root) {
		
		return isBST2Class(root).isBST;
	}
	
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
		
		if(n==0) {
			return null;
		}
		
		return SortedArrayToBST(arr, 0, n-1);
	}
		

	//Time complexity : O(N)
	//Space complexity : O(logN)
	private static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int sI, int eI) {
		
		if(sI>eI) {
			return null;
		}
		
		int middle = (sI+eI)/2;
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[middle]);
		
		root.left = SortedArrayToBST(arr, sI, middle-1);
		
		root.right = SortedArrayToBST(arr, middle+1, eI);
		
		return root;
		
	}
	
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {

		 if(root==null){
	            return null;
	        }
	        
	     return constructLinkedListHelper(root).head;
	     
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	private static Pair constructLinkedListHelper(BinaryTreeNode<Integer> root) {
		
		
		if(root==null) {
			Pair p = new Pair();
			return p;
		}
		
		Pair ls = constructLinkedListHelper(root.left);
		
		Pair rs = constructLinkedListHelper(root.right);
		
		Pair ans = new Pair();
		
		LinkedListNode<Integer> node = new LinkedListNode<>(root.data);
		
		if(ls.head!=null) {
			ans.head=ls.head;
			ls.tail.next=node;
		}
		
		else {
			ans.head=node;
		}
		
		node.next=rs.head;
		
		if(rs.tail!=null) {
			ans.tail=rs.tail;
		}
		
		else {
			ans.tail=node;
		}
		
		return ans;
		
	}
	
	//Time complexity : O(H)
	//Space complexity : O(H)
	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		
		if(root==null) {
			return null;
		}
		
		if(root.data==data) {
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(root.data);
			return ans;
		}
		
		else if(data<root.data) {
			ArrayList<Integer> ls = getPath(root.left,data);
			if(!ls.isEmpty()) {
				ls.add(root.data);
				return ls;
			}
		}
		
		ArrayList<Integer> rs = getPath(root.right,data);
		
		if(!rs.isEmpty()) {
			rs.add(root.data);
		}
		
		return rs;
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(H)
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return;
		}
		
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
		
		BinaryTreeNode<Integer> temp = root.left;
		
		root.left = newNode;
		
		newNode.left = temp;
		
		insertDuplicateNode(root.left);
		
		insertDuplicateNode(root.right);
	}
	
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		
		BinaryTreeNode<Integer> ans = getLCAHelper(root,a,b);
		
		if(ans == null) {
			return -1;
		}
		
		return ans.data;
		
	}
		   

	//Time complexity : O(N)
	//Space complexity : O(H)
	private static BinaryTreeNode<Integer> getLCAHelper(BinaryTreeNode<Integer> root, int a, int b) {
		
		if(root==null) {
			return null;
		}
		
		
		if(root.data==a || root.data==b) {
			return root;
		}
		
		BinaryTreeNode<Integer> ls = getLCAHelper(root,a,b);
		
		BinaryTreeNode<Integer> rs = getLCAHelper(root,a,b);
		
		if(ls!=null && rs!=null) {
			return root;
		}
		
		
		if(ls!=null) {
			return ls;
		}
		
		
		return rs;
		
	}
	
	public static int getLCABST(BinaryTreeNode<Integer> root, int a, int b) {
		
        BinaryTreeNode<Integer> ans = getLCAUtil(root,a,b);
        
        if(ans==null){
            return -1;
        }
        
        return ans.data;
	}
	

	//Time complexity : O(H)
	//Space complexity : O(H)
	private static BinaryTreeNode<Integer> getLCAUtil(BinaryTreeNode<Integer> root, int a, int b) {
		
		if(root==null) {
			return null;
		}
		
		if(root.data==a || root.data==b) {
			return root;
		}
		
		if(a>root.data && b>root.data) {
			return getLCAUtil(root.right, a, b);
		}
		
		else if(a<root.data && b<root.data) {
			return getLCAUtil(root.left, a, b);
		}
		
		else {
			
			BinaryTreeNode<Integer> ls = getLCAUtil(root.left,a,b);
			
			BinaryTreeNode<Integer> rs = getLCAUtil(root.right,a,b);
			
			if(ls!=null && rs!=null) {
				return root;
			}
			
			else if(ls!=null) {
				return ls;
			}
			
			return rs;
		}
	}
	
	
	//Time complexity : NlogN (Sorting)
	//Space complexity: O(N)  (new Array)
	public static void pairSum(BinaryTreeNode<Integer> root, int sum) {
		
		if(root==null) {
			return;
		}
		
		
		ArrayList<Integer> treeArray = new ArrayList<>();
		
		convertToArray(root,treeArray);
		
		Collections.sort(treeArray);
		
		int i=0, j=treeArray.size()-1;
		
		while(i<j) {
			
			if(treeArray.get(i)+treeArray.get(j)==sum) {
				System.out.println(treeArray.get(i)+" "+treeArray.get(j));
				i++;
				j--;
			}
			
			else if(treeArray.get(i)+treeArray.get(j)>sum) {
				j--;
			}
			
			else {
				i++;
			}
		}
	}

	private static void convertToArray(BinaryTreeNode<Integer> root, ArrayList<Integer> treeArray) {
		
		if(root==null) {
			return;
		}
		
		treeArray.add(root.data);
		
		convertToArray(root.left, treeArray);
		
		convertToArray(root.right,treeArray);
		
	}
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		
		if(root==null) {
			return;
		}
		
		rootToLeafPathsSumToK(root, k, "");
	}

	//Time complexity : O(N)
	//Space complexity : O(H)
	private static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String toBePrinted) {
		
		if(root==null) {
			return;
		}
		
		toBePrinted=toBePrinted+root.data+" ";
		
		if(root.left==null && root.right==null) {
			
			if(root.data==k) {
				System.out.println(toBePrinted);
			}
		}
		
		rootToLeafPathsSumToK(root.left, k-root.data, toBePrinted);
		
		rootToLeafPathsSumToK(root.right, k-root.data, toBePrinted);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
