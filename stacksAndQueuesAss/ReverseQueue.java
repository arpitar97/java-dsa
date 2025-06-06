package stacksAndQueuesAss;

import java.util.Queue;


public class ReverseQueue {

	//Time complexity : O(N)
	//Space complexity : O(N)
	
	public static void reverseQueue(Queue<Integer> input) {

		if(input.size()<=1){
            return;
        }
        
        int temp = input.poll();
        
        reverseQueue(input);
        
        input.add(temp);
	}

}
