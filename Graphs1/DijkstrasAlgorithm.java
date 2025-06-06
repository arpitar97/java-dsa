package Graphs1;
import java.util.Scanner;

public class DijkstrasAlgorithm {
	
	
	private static int findMinDistance(int[] distance, boolean[] visited) {
		
		int minDistance = -1;
		
		for(int i=0; i<distance.length; i++) {
			
			if(!visited[i] && ( minDistance==-1 || distance[i]<distance[minDistance]) ) {
				minDistance=i;
			}
		}
		
		return minDistance;
	}
	
	private static void dijkstras(int[][] adjacencyMatrix) {
		
		int V = adjacencyMatrix.length;
		
		boolean[] visited = new boolean[V];
		
		int[] distance = new int[V];
		
		distance[0]=0;
		
		for(int i=1; i<V; i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0; i<V; i++) {
			//Find vertex with minimun distance
			int minDistance = findMinDistance(distance,visited);
			
			visited[minDistance]=true;
			//Explore the neighbors
			for(int j=0; j<V; j++) {
				
				if(adjacencyMatrix[minDistance][j]!=0 && !visited[j] ) {
					
					int newDistance = adjacencyMatrix[minDistance][j]+distance[minDistance];
					if(newDistance<distance[j]) {
						distance[j] = newDistance;
					}
				}
			}
		}
		for(int i=0; i<distance.length; i++) {
			System.out.println(i+" "+distance[i]);
		}
		
		
		
		
	}

	

	public static void main(String[] args) {
		

		Scanner s = new Scanner(System.in);

		int v = s.nextInt();
		int e = s.nextInt();

		int[][] adjacencyMatrix= new int[v][v];

		for(int i=0; i<e ; i++) {

			int v1 = s.nextInt();
			int v2 =s.nextInt();
			int weight = s.nextInt();

			adjacencyMatrix[v1][v2]=weight;
			adjacencyMatrix[v2][v1]=weight;

		}

		dijkstras(adjacencyMatrix);
	}



}
