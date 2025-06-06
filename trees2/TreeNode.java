package trees;

import java.util.ArrayList;

public class TreeNode<T> {

	public T data;
	
	public ArrayList<TreeNode<T>> children;
	
	public TreeNode( T data ) {
	
		this.data=data;
		
		children = new ArrayList<>();
		
		

		
	}
	
	
	 public static class Pair{
	       
       public TreeNode<Integer> largest;
       public TreeNode<Integer> secondlarge;
	}
	
	public static void main(String[] args) {
		
		
		Pair p =new Pair();
		
		
		
		
	}
	
	
}
