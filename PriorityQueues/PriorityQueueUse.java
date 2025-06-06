package priorityQueue;

public class PriorityQueueUse {

	public static void main(String[] args) throws PriorityQueueException {
		// TODO Auto-generated method stub
		
		int[] arr = {2,8,0,6,3,7,1};
		
		Priority_Queue pq = new Priority_Queue();
		
		for(int i : arr) {
			pq.insert(i);
		}
		
		while(!pq.isEmpty()) {
			System.out.print(pq.removeMin()+" ");
		}

	}

}
