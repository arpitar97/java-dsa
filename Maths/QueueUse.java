package pack1;

public class QueueUse {

	public static void main(String[] args) {
		
//		QueueUsingArray queue = new QueueUsingArray(3);
//		
//		for (int i=1; i<=10 ; i++){
//			
//			try {
//				queue.enqueue(i);
//			} catch (QueueFullException e) {
//				
//				e.printStackTrace();
//			}
//			
//			
//		}
//		
//		
//		while(!queue.isEmpyt()) {
//			
//			
//			try {
//				System.out.println(queue.dequeue());
//			} catch (QueueEmptyException e) {
//				
//				e.printStackTrace();
//			}
//			
//			
//			
//			
//		}
		
		QueueUsingLL<Integer> q1 = new QueueUsingLL<>();
		
		for(Integer i=1; i<=10; i++) {
			
			q1.enqueue(i);
			
		}
		
		Integer a = 0;
		
		q1.enqueue(a);
		
		
		while(!q1.isEmpty()) {
			
			
			try {
				
				System.out.println(q1.dequeue());
				
			} catch (QueueEmptyException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	   q1.enqueue(993);
	   try {
		System.out.println(q1.front());
	} catch (QueueEmptyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
		

	}

}
