package priorityQueues;

import java.util.ArrayList;

class Pair{
    int index;
    int value;
    
    Pair(int i , int v){
        index=i;
        value=v;
    }
}

public class Priority_Queue_Diff {
	
private ArrayList<Pair> heap;
	
	public Priority_Queue_Diff() {
		heap=new ArrayList<>();
	}
	
	public boolean isEmpty() {
		return heap.size()==0;
	}
	
	public int size() {
		return heap.size();
	}
	
	public Pair getMax() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	
	public void insert(Pair element) {
		heap.add(element);
		
		int childIndex=heap.size()-1;
		int parentIndex=(childIndex-1)/2;
		
		while(childIndex>0) {
			
			if(heap.get(childIndex).value>heap.get(parentIndex).value) {
				Pair swap=heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, swap);
				childIndex=parentIndex;
				parentIndex=(parentIndex-1)/2;
			}
			
			else {
				return;
			}
		}
		
	}
	
	public Pair removeMax() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		
		Pair value = heap.get(0);
		
		heap.set(0, heap.get(heap.size()-1));
		
		heap.remove(heap.size()-1);
		
		int index=0;
		int maxIndex=index;
		int leftChildIndex=1;
		int rightChildIndex=2;
		
		while(leftChildIndex<heap.size()) {
			
			if(rightChildIndex<heap.size() && heap.get(rightChildIndex).value>heap.get(maxIndex).value) {
				maxIndex=rightChildIndex;
			}
			
			if(heap.get(leftChildIndex).value>heap.get(maxIndex).value) {
				maxIndex=leftChildIndex;
			}
			
			if(maxIndex==index) {
				break;
			}
			
			Pair swap = heap.get(index);
			heap.set(index, heap.get(maxIndex));
			heap.set(maxIndex, swap);
			index=maxIndex;
			leftChildIndex=index*2+1;
			rightChildIndex=index*2+2;
			
		}
			
		
		return value;
	}

	
	public static int buyTicket(int input[], int k) throws PriorityQueueException {

        int a = 1;
//        
//        MaxComparator compare = new MaxComparator();
//        
//        PriorityQueue<Pair> pq = new PriorityQueue<>(compare);
        
        Priority_Queue_Diff pq = new Priority_Queue_Diff();
        
        for(int i=0; i<input.length; i++){
            
            Pair current = new Pair(i,input[i]);
            pq.insert(current);
            
        }
        
        while(!pq.isEmpty()){
            
          if(input[k]==pq.getMax().value && pq.getMax().index==k){
              break;
          }  
          
          pq.removeMax();
          
          a++;
        }
    
        return a;
        
        
	}
	public static void main(String[] args) throws PriorityQueueException {
		
		int[] arr = {2,3,4,6,7,2,2};
		
		int a = buyTicket(arr,6);
		
		System.out.println(a);
		
		
		

	}

}
