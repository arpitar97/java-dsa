package backtracking;

public class NQueen {
	
	// Below is the solution where we are checking for diagnol, an =d column by using for loop
	
	  public static void placeNQueens(int n){
			
		    int[][] board = new int[n][n];
			placeNQueensHelper(board,0,n);

			}
		    
		    
		    public static void placeNQueensHelper(int[][] board, int row, int n){
		        
		        if(row==n){
		            for(int r=0; r<n; r++){
		                for(int c=0; c<n; c++){
		                    System.out.print(board[r][c]+" ");
		                }
		            }
		            System.out.println();
		        }
		        
		        for(int col=0; col<n; col++){
		            
		            if(queenSafe(board,row,col,n)){
		                board[row][col]=1;
		                placeNQueensHelper(board,row+1,n);
		                board[row][col]=0;
		            }
		        }
		    }
		    
		    public static boolean queenSafe(int[][] board,int row,int col,int n){
		        
		        for(int i=row-1, j=col; i>=0; i-- ){
		            if(board[i][j]==1){
		                return false;
		            }
		        }
		        
		        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j-- ){
		            if(board[i][j]==1){
		                return false;
		            }
		        }
		        
		        for(int i=row-1, j=col+1; i>=0 && j<n; i--,j++ ){
		            if(board[i][j]==1){
		                return false;
		            }
		        }
		        
		        return true;
		    }

}
