package priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
    int value;
    int index;
    Pair(int value, int index){
        this.value=value;
        this.index=index;
    }
}

class PairComparator implements Comparator<Pair>{
    
    	@Override
	public int compare(Pair o1, Pair o2) {
		
		if(o1.value>o2.value) {
			return -1;
		}
		
		else {
			return 1;
		}
	}
}

public class BuyTheTicket {
	
	//Time complexity : O(NlogN)
	//Space complexity : O(N)
	public static int buyTicket(int input[], int k) {

        PairComparator pp = new PairComparator();
        
        PriorityQueue<Pair> max = new PriorityQueue<>(pp);
        
        for(int i=0; i<input.length; i++){
            Pair p = new Pair(input[i],i);
            max.add(p);
        }
        
        int count=0;
        
        while(!max.isEmpty()){
            count++;
            Pair element = max.remove();
            
            if(element.index==k){
                break;
            }
        }
        
        return count;

	}

}
