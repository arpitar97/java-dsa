package recursion2;

public class ReturnSubsetOfAnArray {
	
	//Time complexity : O(N^2)
	
     public static int[][] subsets(int input[], int sI) {
		
        if(sI==input.length){
            int[][] smallAns = new int[1][0];
            return smallAns;
        }
        
        int[][] smallAns = subsets(input,sI+1);
        int[][] ans = new int[smallAns.length*2][];
        int k=0;
        
        for(int i=0; i<smallAns.length; i++){
            ans[k]=smallAns[i];
            k++;
        }
        
        for(int i=0; i<smallAns.length; i++){
            ans[k] = new int[smallAns[i].length+1];
                for(int j=0; j<smallAns[i].length; j++){
                    ans[k][j+1]=smallAns[i][j];
                }
               ans[k][0]=input[sI]; 
                k++;
        }
        
        return ans;

	}
    
    
    public static int[][] subsets(int input[]) {

        return subsets(input,0);

	}

	public static void main(String[] args) {
		
		int[][] smallAns = {{2,4},{3,6,5},{5,4,3,8,7}};
		
		int[][] ans = new int [4][];
		
		ans[0]=smallAns[0];
		
		ans[1]=smallAns[2];
		
		for(int i=0; i<ans[1].length; i++) {
			System.out.println(ans[1][i]);
		}

	}

}
