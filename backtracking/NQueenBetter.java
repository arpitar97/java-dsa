package backtracking;

public class NQueenBetter {
	
	public static void placeNQueens(int n){
		
	    int[][] board = new int[n][n];
	    boolean[] cols = new boolean[n];
	    boolean[] ndiag = new boolean[2*n -1];
	    boolean[] rdiag = new boolean[2*n -1];
	    
	    solve(board,n,cols,ndiag,rdiag,0);

		}
	    
	    public static void solve(int[][] board, int n, boolean[] cols, boolean[] ndiag, boolean[] rdiag,
	                              int row){
	        
	        if(row==n){
	            for(int r=0; r<n; r++){
	                for(int c=0; c<n; c++){
	                    System.out.print(board[r][c]+" ");
	                }
	            }
	            System.out.println();
	            return;
	        }
	        
	        for(int col=0; col<n; col++){
	            
	            if(board[row][col]==0 && cols[col]==false && ndiag[row+col]==false && rdiag[row-col+n-1]==false){
	                
	                cols[col]=true;
	                ndiag[row+col]=true;
	                rdiag[row-col+n-1]=true;
	                board[row][col]=1;
	                
	                solve(board,n,cols,ndiag,rdiag,row+1);
	                
	                cols[col]=false;
	                ndiag[row+col]=false;
	                rdiag[row-col+n-1]=false;
	                board[row][col]=0;
	            }
	        }
	    }

}
