package binarySearchTree;

import binaryTrees.BinaryTreeNode;

public class BinarySearchTree {
	
private BinaryTreeNode<Integer> root;
    
	public void insert(int data) {
		//Implement the insert() function
       root=insertHelper(root,data);
        
	}
    
    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data){
        
        if(root == null){
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
            return node;
        }
       
        if(data>root.data){
            BinaryTreeNode<Integer> rs = insertHelper(root.right,data);
            root.right=rs;
            return root;
        }
        

         BinaryTreeNode<Integer> ls = insertHelper(root.left,data);
            root.left=ls;
            return root;
        
    }
	
	public void remove(int data) {
		//Implement the remove() function
       root=remove(root,data);
        
	}
    
    private static int minimum(BinaryTreeNode<Integer> root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        
        return Math.min(root.data,minimum(root.left));
    }
    
    private static BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root, int data){
        
        if(root == null){
            return null;
        }
        
        
        if(data<root.data){
            BinaryTreeNode<Integer> ls = remove(root.left,data);
            root.left=ls;
            return root;
        }
        
        else if(data>root.data){
            BinaryTreeNode<Integer> rs = remove(root.right,data);
            root.right=rs;
            return root;
        }
        
        
        else{
            
            if(root.left==null && root.right==null){
                return null;
            }
            
            else if(root.right==null){
                return root.left;
            }
            
            else if(root.left==null){
                return root.right;
            }
            
            else{
                int d = minimum(root.right);
                root.right = remove(root.right,d);
                root.data=d;
                return root;
                
//                The below code is alternative for finding minimum of right tree and  is a great approach
                
//                 BinaryTreeNode<Integer> minNode = root.right;

//                 while (minNode.left != null) {

//                     minNode = minNode.left;

//                 }

//                 root.data = minNode.data;

//                 root.right = remove(root.right,minNode.data);

//                 return root;
  
            }
            
        }
  
    }
	
	public void printTree() {
		//Implement the printTree() function
      printTreeHelper(root);
 
	}
    
    private static void printTreeHelper(BinaryTreeNode<Integer> root){
        
        if(root==null){
            return;
        }
    
        String s = root.data+":";
        
        if(root.left!=null){
            s=s+"L:"+root.left.data+",";
        }
        
        if(root.right!=null){
            s=s+"R:"+root.right.data;
        }
        
        System.out.println(s);

        printTreeHelper(root.left);
        
        printTreeHelper(root.right);
    }
	
	public boolean search(int data) {
		//Implement the search() function
      return search(root,data);
	}
    
    private boolean search(BinaryTreeNode<Integer> root, int data){
        
        if(root==null){
            return false;
        }
        
        if(root.data==data){
            return true;
        }
        
        else if(data<root.data){
            return search(root.left,data);
        }
        
        else{
            return search(root.right,data);
        }
        
    }

}
