package Graphs1;

public class CodingNinjas {
	
	  int[][] a = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	  
	    String pattern = "CODINGNINJA";
	    int[][] used;
	    
	   int validPoint(int x, int y, int N, int M){
	        if(x>=0 && x<N && y>=0 && y<M){
	            return 1;
	        }
	        
	        return 0;
	    }
	    
	   int dfs(String[] graph, int x, int y, int index, int N, int M){
	        
	        if(index==11){
	            return 1;
	        }

	        int found=0;
	        
	        used[x][y]=1;
	        
	        for(int i=0; i<8; i++){
	            
	            int newX = x+a[i][0];
	            int newY = y+a[i][1];
	            
	            if(validPoint(newX,newY,N,M)==1 && graph[newX].charAt(newY)==pattern.charAt(index) && used[newX][newY]==0){
	                
	                found =  dfs(graph,newX,newY,index+1,N,M);
	                
	                if(found==1){
	                    break;
	                }

	            }
	            
	        }
	        
	        used[x][y]=0;
	        return found;
	        
	    }
		
		int solve(String[] Graph , int N, int M){
	        
	        int i,j,found=0;
	        used=new int[N][M];
			
	        for(i=0; i<N; i++){
	            
	            for(j=0, found=0; j<M; j++){
	                if(Graph[i].charAt(j)=='C'){
	                    found=dfs(Graph,i,j,1,N,M);
	                    if(found==1){
	                    break;
	                    }
	                      
	                }
	            }
	            
	            if(found==1){
	                    break;
	            }
	        }
	        
	        return found;
		}

	public static void main(String[] args) {
		
		
	}

}
