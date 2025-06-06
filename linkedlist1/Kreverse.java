package linkedlist1;

public class Kreverse {
	
	//Time Complexity : O(N)
	//Space Complexity : O(N/k)
	
	public static Node<Integer> kReverse(Node<Integer> head, int k) {
		
	       if(k==0 || k==1){
	           return head;
	       }
	        
	       Node<Integer> curr = head;
	       Node<Integer> prev = null;
	       Node<Integer> fwd = null;
	        
	       int count=0;
	        
	       while(count<k && curr!=null){
	           fwd=curr.next;
	           curr.next=prev;
	           prev=curr;
	           curr=fwd;
	           count++;
	       }
	        
	       if(fwd!=null){
	          head.next=kReverse(fwd,k);
	       } 
	       return prev; 
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
