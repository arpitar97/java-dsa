package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueUsingLL<Integer> q = new QueueUsingLL<>();
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1; i<=5; i++) {
			q.enqueue(i);
		}
		
		while(!q.isEmpty()) {
			try {
				System.out.println(q.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
