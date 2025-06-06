package Graphs1;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	int source;
	int dest;
	int weight;
	
	@Override
	
	public int compareTo(Edge o) {
		
		return this.weight-o.weight;
		
	}
}

public class KruskalsAlgorithm {
	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int V = s.nextInt();
		int E = s.nextInt();
		
		Edge[] input = new Edge[E];
		
		for(int i=0; i<E; i++) {
			
			input[i] = new Edge();
			input[i].source=s.nextInt();
			input[i].dest=s.nextInt();
			input[i].weight=s.nextInt();
			
		}
		
		kruskals(input,V);
		
		
	}

	private static void kruskals(Edge[] input, int V) {
		
		Edge[] output = new Edge[V-1];
		
		int count=0;
		
		Arrays.sort(input);
		
		int index=0;
		
		int[] parent = new int[V];
		
		for(int j=0; j<V; j++) {
			parent[j]=j;
		}
		
		while(count!=V-1) {
			
			Edge currentEdge = input[index];
			
			int sourceParent = findParent(parent,currentEdge.source);
			
			int destParent = findParent(parent,currentEdge.dest);
			
			if(sourceParent!=destParent) {
				output[count]=input[index];
				parent[sourceParent]=destParent;
				count++;
			}
			
			index++;
			
		}
		
		for(int b=0; b<output.length; b++) {
			
			if(output[b].source<output[b].dest) {
				System.out.println(output[b].source+" "+output[b].dest+" "+output[b].weight);
			}
			
			else {
				System.out.println(output[b].dest+" "+output[b].source+" "+output[b].weight);
			}
		}
	}

	private static int findParent(int[] parent, int v) {
	
		if(parent[v]==v) {
			return v;
		}
		
		return findParent(parent,parent[v]);
	}

}
