package binarySearchTree;

import binaryTrees.BinaryTreeNode;

public class BinarySearchTreeUse {
	
	
	public static boolean isBST1(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return true;
		}
		
		int max = maximum(root.left);
		
		int min = minimum(root.right);
		
		if(root.data<=max || root.data>min) {
			return false;
		}
		
		return isBST1(root.left) && isBST1(root.right);
		

		
	}
	
	private static int minimum(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		
		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}

	private static int maximum(BinaryTreeNode<Integer> root) {
		
		
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
		
		
	}

	public static Pair<Boolean,Pair<Integer,Integer>> ifBST2(BinaryTreeNode<Integer> root){
		
		if(root == null) {
			
			Pair<Boolean,Pair<Integer,Integer>> p = new Pair<>();
			
			p.second = new Pair<>();
			
			p.first=true;
			
			p.second.first = Integer.MAX_VALUE;
			
			p.second.second = Integer.MIN_VALUE;
			
			return p;
		}
		
		Pair<Boolean,Pair<Integer,Integer>> ls = ifBST2(root.left);
		
		Pair<Boolean,Pair<Integer,Integer>> rs = ifBST2(root.right);
		
		int min = Math.min(root.data,Math.min(ls.second.first,rs.second.first));
		
		int max = Math.max(root.data, Math.max(ls.second.second, rs.second.second));
		
		Pair<Boolean,Pair<Integer,Integer>> ans = new Pair<>();
		
		ans.second = new Pair<>();
		
		boolean isBST = ls.first && rs.first && (root.data>ls.second.second) && (root.data<=rs.second.first);
		
		ans.first=isBST;
		
		ans.second.first = min;
		
		ans.second.second = max;
		
		return ans;
	
		
	}
	
	public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max) {
		if(root==null) {
			return true;
		}
		
		if(root.data>max || root.data<min) {
			return false;
		}
		
		boolean ls=isBST3(root.left,min,root.data-1);
		
		boolean rs=isBST3(root.right,root.data,max);
		
		return ls && rs;

		
	}
	
	public static boolean ifBST(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			return true;
		}
		
		return ifBST2(root).first;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree b = new BinarySearchTree();
		
		b.insert(10);
	
		b.insert(20);
		b.insert(5);
		b.insert(15);
		b.insert(3);
		b.insert(7);

		b.printTree();
		
		System.out.println("djnbdj");
		
		b.remove(10);
		
		b.printTree();
		
		

	}

}
