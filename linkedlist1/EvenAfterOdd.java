package linkedlist1;

public class EvenAfterOdd {
	
	public static Node<Integer> evenAfterOdd(Node<Integer> head){
		
		if(head==null || head.next==null) {
			return head;
		}
		
		
		Node<Integer> evenHead = null, oddHead = null, evenTail = null, oddTail = null;
		
		while(head!=null) {
			
			if(head.data%2==0) {
				
				if(evenHead==null) {
					evenHead=head;
					evenTail=head;
				}
				
				else {
					evenTail.next=head;
					evenTail=evenTail.next;
				}
				
			}
			
			else {
				
				if(oddHead==null) {
					oddHead=head;
					oddTail=head;
				}
				
				else {
					oddTail.next=head;
					oddTail=oddTail.next;
				}
				
			}
			
			head=head.next;
			
		}
		
		if(oddHead==null) {
			return evenHead;
		}
		
		if(evenHead!=null) {
			oddTail.next=evenHead;
			evenTail.next=null;
		}
		
		return oddHead;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
