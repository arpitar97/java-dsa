package dynamicProgramming;

public class MinCostPathRec {
	
	
   public static int minCostPath(int[][] input, int i, int j) {
        
        int m=input.length-1;
        int n=input[0].length-1;
        
        if(i==m && j==n){
            return input[i][j];
        }
        
        if(i>m || j>n){
            return Integer.MAX_VALUE;
        }
        
        int path1 = minCostPath(input,i,j+1);
        int path2 = minCostPath(input,i+1,j);
        int path3 = minCostPath(input,i+1,j+1);
        
        return input[i][j] + Math.min(path1,Math.min(path2,path3));
	
	}

	public static int minCostPath(int[][] input) {
        
        return minCostPath(input,0,0);
	
	}

	public static void main(String[] args) {
		
		int[][] arr = {{3,4,1,2},{2,1,8,9},{4,7,8,1}};
		
		System.out.println(minCostPath(arr));
	
	}

}
