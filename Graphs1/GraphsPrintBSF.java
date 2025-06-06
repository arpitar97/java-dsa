package Graphs1;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;
import java.util.Scanner;

public class GraphsPrintBSF {


	public static void printHelper(int[][] edges, boolean[] visited, Queue<Integer> q) {

		int n=edges.length;

		while(!q.isEmpty()){

			int out = q.poll();

			System.out.print(out+" ");

			for(int i=0; i<n; i++) {

				if(edges[out][i]==1 && !visited[i]) {
					q.add(i);
					visited[i]=true;
				}

			}

		}

	}



	private static void print(int[][] edges, Queue<Integer> q) {

		boolean[] visited = new boolean[edges.length];

		for(int i=0; i<visited.length; i++) {

			if(!visited[i]) {
				q.add(i);
				visited[i]=true;
				printHelper(edges,visited, q);
			}

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		
		int n;
		int e;

		Queue<Integer> q = new LinkedList<>();

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

		print(edges,q);
	}

}


