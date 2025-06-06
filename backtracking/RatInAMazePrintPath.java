package backtracking;

public class RatInAMazePrintPath {
	
	 public static boolean solveMaze(int[][] maze, int i, int j, int[][] path){
	        
	        int n = maze.length;
	        
	        if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1){
	            return false;
	        }
	        
	        path[i][j]=1;
	        
	        if(i==n-1 && j==n-1){
	        	System.out.println( (i) + " " + (j) );
	            return true;
	        }
	        
	        boolean hasPath=false;
	      
         //Top
	        if(solveMaze(maze,i-1,j,path)){
	        	System.out.println( (i) + " " + (j) );
	            hasPath=true;
	        }
	        //Right
	        else if(solveMaze(maze,i,j+1,path)){
	        	System.out.println( (i) + " " + (j) );
	            hasPath=true;
	        }
	        //Down
	        else if(solveMaze(maze,i+1,j,path)){
	           System.out.println( (i) + " " + (j) );
	           hasPath=true;
	        }
	        //Left
	        else if(solveMaze(maze,i,j-1,path)){
	        	System.out.println( (i) + " " + (j) );
	            hasPath=true;
	        }
	        

			return hasPath;
	        
	    }

		public static boolean ratInAMaze(int maze[][]){
	        int i =0;
	        int j=0;
	        int[][] path = new int[maze.length][maze.length];
	        return solveMaze(maze,i,j,path);
	    }

}
