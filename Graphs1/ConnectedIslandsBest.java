package Graphs1;

public class ConnectedIslandsBest {
	
  public static int numConnected(int[][] edges, int n) {
        
        boolean[] visited = new boolean[edges.length];
        
		int ans = countGroups(edges,visited);
        
        return ans;
	}
    
    public static int countGroups(int[][] edges, boolean[] visited){
        
       int count=0;
        
        for(int i=0; i<edges.length; i++){
            
            if(!visited[i]){
            count++;
            checkConnection(edges,visited,i);
            }
           
        }
        
        return count;
    }
    
    public static void checkConnection(int[][] edges, boolean[] visited, int sv ){
        
        visited[sv]=true;
        
        for(int i=0; i<edges.length; i++){
            
            if(edges[sv][i]==1 && !visited[i]){
                checkConnection(edges,visited,i);
            }
        }
    }

}
