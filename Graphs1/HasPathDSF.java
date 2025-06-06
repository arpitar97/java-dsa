package Graphs1;
import java.util.Scanner;
import java.io.IOException;

public class HasPathDSF {


	     public static boolean hasPathHelper(int[][] edges, int sv,int ev, boolean[] visited) {
	         
	        if(sv>edges.length-1 || ev>edges.length-1){
	            return false;
	        }
	         
	        if(sv==ev){
	            return true;
	        }
	         
	        if(edges[sv][ev]==1){
	            return true;
	        }
			
			visited[sv]=true;
	         
	    	int n=edges.length;
	         
			for(int i=0; i<n; i++) {
				if(edges[sv][i]==1 && !visited[i]) {
	                
	                if(i==ev){
	                    return true;
	                }
	                
	                else if(hasPathHelper(edges,i,ev,visited)){
	                     return true;
	                 }
				}
			}
	         
		     return false;
		}
		
		

		private static boolean hasPath(int[][] edges, int s, int e) {
			
			boolean[] visited = new boolean[edges.length];
	            return hasPathHelper(edges,s,e,visited);
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
	        
	        System.out.println(hasPath(edges,v1,v2));
		}

	}


