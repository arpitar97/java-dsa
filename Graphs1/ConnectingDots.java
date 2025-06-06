package Graphs1;

public class ConnectingDots {
	
static int[][] used;
    
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static boolean validPoint(int x, int y, int n){
       
        return (x>=0 && x<n && y>=0 && y<n) ;
   
    }
    
    public static int dfsHelper(String[] edge, int x, int y, int n){
        
        used[x][y]=1;
        
        int count=1;
        
        for(int i=0; i<4; i++){
         
            int newX = x+dir[i][0];
            int newY = y+dir[i][1];
            
            if(validPoint(newX,newY,n) && edge[newX].charAt(newY)=='1' && used[newX][newY]==0){
                  
                count+=dfsHelper(edge,newX,newY,n);
            }
            
        }
        
        return count;
    }
    
    
	public static int dfs(String[] edge, int n) {
		
        used = new int[n][n];
        
        int ans = 0;
        
        for(int i=0; i<n; i++){
            
            for(int j=0; j<n ;j++){
                
                if(edge[i].charAt(j)=='1' && used[i][j]==0){
                 
                    ans=Math.max(ans,dfsHelper(edge,i,j,n));
                    
                }
            
            }
        }
        
        return ans;
    }

}
