package linkedlist1;

public class ReverseLLIteratively {
	
	public static Node<Integer> reverseLL(Node<Integer> head){
		
		if(head==null || head.next==null) {
			return head;
		}
		
		Node<Integer> current = head;
		
		Node<Integer> prev = null;
		
		Node<Integer> fwd = null;
		
		
		while(current!=null) {
			
			fwd=current.next;
			
			current.next=prev;
			
			prev=current;
			
			current=fwd;
			
		}
		
		return prev;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
