package trees;

public class SecondLargestNode {

	static class Pair<T>{
		T first;
		T second;
		Pair(T first, T second){
			this.first=first;
			this.second=second;
		}
	}

	//Time complexity : O(N)
	//Space complexity : O(H)
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){

		if(root==null) {
			return null;
		}

		return findSecondLargestHelper(root).second;

	}

	private static Pair<TreeNode<Integer>> findSecondLargestHelper(TreeNode<Integer> root) {


		if(root==null) {
			Pair<TreeNode<Integer>> p = new Pair<>(null,null);
			return p;
		}

		Pair<TreeNode<Integer>> ans = new Pair<>(root,null);

		for(TreeNode<Integer> child : root.children) {

			Pair<TreeNode<Integer>> childAns = findSecondLargestHelper(child);

			if(childAns.first.data>ans.first.data) {
				if(childAns.second==null || childAns.second.data<ans.first.data) {
					ans.second=ans.first;
					ans.first=childAns.first;
				}
				else {
					ans=childAns;
				}
			}

			else if(ans.first.data.equals(childAns.first.data) && childAns.second!=null) {
				if(ans.second==null || childAns.second.data>ans.second.data) {
					ans.second=childAns.second;
				}
			}

			else if(ans.first.data!=childAns.first.data && (ans.second==null || ans.second.data<childAns.first.data)) {
				ans.second=childAns.first;
			}
		}

		return ans;
	}


}
