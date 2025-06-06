package linkedlist1;

public class MidPointOfLinkedList {
	
	public static Node<Integer> midPoint(Node<Integer> head){
		
		if(head==null || head.next==null) {
			return head;
		}
		
		Node<Integer> slow = head;
		
		Node<Integer> fast = head;
		
		
		while(fast.next!=null && fast.next.next!=null) {
			
			slow=slow.next;
			
			fast=fast.next.next;
			
		}
		
		return slow;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
