package Graphs1;


import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class GetPathDFSArrayList {

     public static ArrayList<Integer> getPathHelper(int[][] edges, int sv,int ev, boolean[] visited) {
	         
	        if(sv>edges.length-1 || ev>edges.length-1){
	            return null;
	        }
	         
	        if(sv==ev){
	          ArrayList<Integer> ans = new ArrayList<>();
              ans.add(sv);
              return ans;
	        }
			
			visited[sv]=true;
	         
	    	int n=edges.length;
	         
			for(int i=0; i<n; i++) {
				if(edges[sv][i]==1 && !visited[i]) {
	               ArrayList<Integer> ans = getPathHelper(edges,i,ev,visited);
                    if(ans!=null){
                       ans.add(sv);
                       return ans;
                    }
                } 
			}
         
              return null;
	}
    

		private static ArrayList<Integer> getPath(int[][] edges, int s, int e) {
			
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
	        
	        ArrayList<Integer> ans = getPath(edges,v1,v2);
            
            if(ans!=null){
                
                for(int arr : ans){
                    System.out.print(arr+" ");
                }
                
            }
            
            
		}
}