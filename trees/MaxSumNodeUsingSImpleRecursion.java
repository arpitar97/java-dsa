package trees;

public class MaxSumNodeUsingSImpleRecursion {
	
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		// Write your code here
        
        if(root==null){
            return null;
        }
        
        TreeNode<Integer> ansNode = root;
        int sum = root.data;
        
        for(int i=0; i<root.children.size(); i++){
            sum+=root.children.get(i).data;
        }
        
        for(int i=0; i<root.children.size(); i++){
            TreeNode<Integer> childAns = maxSumNode(root.children.get(i));
            
            int smallAns = childAns.data;
            
            for(int j=0; j<childAns.children.size(); j++){
                smallAns+=childAns.children.get(j).data;
            }
            
            if(smallAns>sum){
                sum=smallAns;
                ansNode=childAns;
            }
        }
        
        return ansNode;
        
	}

}
