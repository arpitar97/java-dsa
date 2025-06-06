package dynamicProgramming;

public class MinCostPathMemoization {
	
public static int minCostPath(int[][] input, int i, int j,int[][] storage) {
        
        int m=input.length-1;
        int n=input[0].length-1;
        
        if(i==m && j==n){
        	
        	storage[i][j]=input[i][j];
            return storage[i][j];
            
        }
        
        if(i>m || j>n){
            return Integer.MAX_VALUE;
        }
        
        if(storage[i][j]!=0) {
        	return storage[i][j];
        }
        
        int path1 = minCostPath(input,i,j+1,storage);
        int path2 = minCostPath(input,i+1,j,storage);
        int path3 = minCostPath(input,i+1,j+1,storage);
        
        storage[i][j] = input[i][j] + Math.min(path1,Math.min(path2,path3));
	       return storage[i][j];
        
	}

	public static int minCostPath(int[][] input) {
		
		int[][] storage = new int[input.length][input[0].length];
        
        return minCostPath(input,0,0,storage);
	
	}

	public static void main(String[] args) {
		
		int[][] arr = {{3,4,1,2},{2,1,8,9},{4,7,8,1}};
		
		System.out.println(minCostPath(arr));
	
	}

	

}
