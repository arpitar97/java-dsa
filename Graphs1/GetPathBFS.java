package Graphs1;

import java.util.ArrayList;
import java.io.IOException;
import java.util.HashMap;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class GetPathBFS {

     public static ArrayList<Integer> getPathHelper(int[][] edges, int sv,int ev, boolean[] visited) {
         
         
          if(sv>=edges.length || ev>=edges.length){
             return null;
          }
         
            HashMap<Integer,Integer> hm = new HashMap<>();
            Queue<Integer> q = new LinkedList<>();
            int n=edges.length;
            ArrayList<Integer> ans = new ArrayList<>();
         
           if(sv==ev){
	          ans.add(sv);
              return ans;
	        }
         
           if(edges[sv][ev]==1){
             ans.add(ev);
             ans.add(sv);
             return ans;
           }
         
            int loop = Integer.MIN_VALUE;
         
            q.add(sv);
         
            while(!q.isEmpty()){
               
                int front = q.poll();
                for(int i=0; i<n; i++) {
				   if(edges[front][i]==1 && !visited[i]) {
                         q.add(i);
                         visited[i]=true;
                         hm.put(i,front);
                         if(i==ev){
                             loop=i;
                             ans.add(loop);
                             while(loop!=sv){
                              loop = hm.remove(loop);
                              ans.add(loop);
                             }
                             
                            return ans;
                         }
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


