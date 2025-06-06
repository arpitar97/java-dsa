package Graphs1;

import java.io.IOException;
import java.util.Scanner;

public class IsConnectedDFS {
    
    
    public static void printHelper(int[][] edges, int sv, boolean[] visited){
        
        visited[sv]=true;
        
        for(int i=0; i<edges.length; i++){
            
            if(edges[sv][i]==1 && !visited[i]){
                printHelper(edges,i,visited);
            }
        }
        
    }
    
    
    
    public static void print(int[][] edges, boolean[] visited){
        printHelper(edges,0,visited);
    }
    
    public static boolean isConnected(int[][] edges){
        
        if(edges.length==0){
            return true;
        }
             
         boolean[] visited = new boolean[edges.length];
        
          print(edges,visited);
        
          for(int i=0; i<visited.length; i++){
              if(!visited[i]){
                  return false;
              }
          }
        
        return true;
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
        
          System.out.println(isConnected(edges));
        

	}

}

