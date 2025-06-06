package Graphs1;


import java.io.IOException;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class IsConnectedBFS {
    
    
    public static void printHelper(int[][] edges, int sv, boolean[] visited){
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(sv);
        
        while(!q.isEmpty()){
            
            int front = q.poll();
            
            visited[front]=true;
            
           for(int i=0; i<edges.length; i++){
               if(edges[front][i]==1 && !visited[i]){
                  q.add(i);
              }
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
        
          
        if(edges.length==0){
            System.out.println("true");
            return;
        }
        
          System.out.println(isConnected(edges));
        

	}

}


