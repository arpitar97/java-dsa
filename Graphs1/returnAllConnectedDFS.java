package Graphs1;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class returnAllConnectedDFS  {
    
    public static void allConnectedComponentsHelper(boolean[] visited,int[][] edges,ArrayList<Integer> smallAns,
                                                    int sv){
        
        smallAns.add(sv);
        visited[sv]=true;
        
        for(int i=0; i<edges.length; i++){
            if(edges[sv][i]==1 && !visited[i]){
               allConnectedComponentsHelper(visited,edges,smallAns,i); 
            }
        }
        
    }
    
    
    public static ArrayList<ArrayList<Integer>> allConnectedComponents(int[][]edges){
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        boolean[] visited = new boolean[edges.length];
        
        for(int i=0; i<edges.length; i++){
            if(!visited[i]){
            ArrayList<Integer> smallAns = new ArrayList<>();
            allConnectedComponentsHelper(visited,edges,smallAns,i);
            ans.add(smallAns);                
            }
        }
        
        return ans;
        
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
       
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] edges = new int[n][n];
        
        for(int i=0; i<e; i++){
            
            int sv = s.nextInt();
            int ev = s.nextInt();
            edges[sv][ev]=1;
            edges[ev][sv]=1;
            
        }
        
        ArrayList<ArrayList<Integer>> ans = allConnectedComponents(edges);
        
        for(int i=0; i<ans.size(); i++){
            
            Collections.sort(ans.get(i));
            
            for(int j=0; j<ans.get(i).size(); j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            
            System.out.println();
        }
        
	}

}
