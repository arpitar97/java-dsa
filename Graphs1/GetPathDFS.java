package Graphs1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class GetPathDFS {

     public static boolean getPathHelper(int[][] edges, int sv,int ev, boolean[] visited) {
	         
	        if(sv>edges.length-1 || ev>edges.length-1){
	                 return false;
	        }
	         
	        if(sv==ev){
	            System.out.print(sv+" ");
                return true;
	        }
			
			visited[sv]=true;
	         
	    	int n=edges.length;
	         
			for(int i=0; i<n; i++) {
				if(edges[sv][i]==1 && !visited[i]) {
	
	                 if(getPathHelper(edges,i,ev,visited)){
                        System.out.print(sv+" ");
                        return true;
                    }
                } 
			}
         
              return false;
	}
    

		private static boolean getPath(int[][] edges, int s, int e) {
			
			boolean[] visited = new boolean[edges.length];
	            return getPathHelper(edges,s,e,visited);
		}

		public static void main(String[] args) throws NumberFormatException, IOException {

			int n;
			int e;

			Scanner s = new Scanner(System.in);

			n = s.nextInt();
			e = s.nextInt();

			int[][] edges = new int[n][n];

			for(int i=0; i<e; i++) {

				int fv = s.nextInt();
				int sv = s.nextInt();

				edges[fv][sv]=1;
				edges[sv][fv]=1;

			}
	        
	        int v1 = s.nextInt();
	        int v2 = s.nextInt();
	        
	        getPath(edges,v1,v2);
		}
}
