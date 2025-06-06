package dynamicProgramming;

public class MinCostPathDP {
	
public static int minCostPath(int[][] input, int i, int j,int[][] storage) {
        
        int m=input.length-1;
        int n=input[0].length-1;
       
        storage[m][n]=input[m][n];
        
        for(int a=m; a>=0; a--) {
        	
        	for(int b=n; b>=0; b--) {
        		
        		if(storage[a][b]!=0) {
        			continue;
        		}
        		
        		int path1 = Integer.MAX_VALUE;
        		int path2 = Integer.MAX_VALUE;
        		int path3 = Integer.MAX_VALUE;
        		
        		if(a<=m && b+1<=n) {
        			path1 = storage[a][b+1];
        		}
        		
        		if(a+1<=m && b<=n) {
        			path2 = storage[a+1][b];
        		}
        		
        		if(a+1<=m && b+1<=n) {
        			path3 = storage[a+1][b+1];
        		}
        		
        		int ans =  Math.min(path1, Math.min(path2, path3));
        		
        		storage[a][b]=input[a][b]+ans;
     
        	}
        	
        }
     
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
