package Graphs1;

import java.util.ArrayList;

public class ConnectedIslands {
	
	public static int numConnected(int[][] edges, int n) {

        boolean[] visited = new boolean[edges.length];
        
		ArrayList<ArrayList<Integer>> ans = countGroups(edges,visited);
        
        return ans.size();
	}
    
    public static ArrayList<ArrayList<Integer>> countGroups(int[][] edges, boolean[] visited){
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<edges.length; i++){
            
            if(!visited[i]){
            ArrayList<Integer> arr = new ArrayList<>();
            checkConnection(edges,visited,i,arr);
            ans.add(arr);
            }
           
        }
        
        return ans;
    }
    
    public static void checkConnection(int[][] edges, boolean[] visited, int sv, ArrayList<Integer>
                                                     arr){
        
        visited[sv]=true;
        	
        arr.add(sv);
        
        for(int i=0; i<edges.length; i++){
            
            if(edges[sv][i]==1 && !visited[i]){
                checkConnection(edges,visited,i,arr);
            }
        }
    }

}
