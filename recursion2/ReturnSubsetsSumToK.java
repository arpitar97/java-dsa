package recursion2;

public class ReturnSubsetsSumToK {
	
	//Time Complexity : O(2^N)
	
	public static int[][] subsetsSumK(int input[], int k) {
		return subsetsSumK(input,k,0);
    }
    
    public static int[][] subsetsSumK(int[] input, int k , int sI){
        
        if(sI==input.length){
            if(k==0){
            int[][] smallAns = new int[1][0];
            return smallAns;    
            }
            
            else{
                int[][] smallAns = new int[0][0];
                return smallAns;
            }
        }
        
        int[][] smallAns = subsetsSumK(input,k-input[sI],sI+1);
        
        int[][] arr = subsetsSumK(input,k,sI+1);
        
        int[][] ans = new int[arr.length+smallAns.length][];
        
        int m=0;
        
        for(int i=0; i<arr.length; i++){
            ans[m]=arr[i];
            m++;
        }
        
        for(int i=0; i<smallAns.length; i++){
            ans[m]= new int[smallAns[i].length+1];
            
            for(int j=0; j<smallAns[i].length; j++){
                ans[m][j+1]=smallAns[i][j];
            }
            ans[m][0]=input[sI];
            m++;
        }
        
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
