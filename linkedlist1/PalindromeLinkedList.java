package linkedlist1;

public class PalindromeLinkedList {
	
	
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
	
	public static boolean isPalindrome(Node<Integer> head) {
		
		if(head==null || head.next==null) {
			return true;
		}
		
		
		Node<Integer> slow = head;
		
		Node<Integer> fast = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			
			slow=slow.next;
			fast=fast.next.next;
			
		}
		
		Node<Integer> head2 = slow.next;
		
		Node<Integer> head1 = head;
		
		slow.next=null;
		
		Node<Integer> reverseHead = reverseLL(head2);
		
		Node<Integer> temp1 = head1;
		
		Node<Integer> temp2 = reverseHead;
		
		
		while(temp2!=null) {
			
			if(temp1.data!=temp2.data) {
				return false;
			}
			
			temp1=temp1.next;
			
			temp2=temp2.next;
		}
		
		Node<Integer> reverseAg = reverseLL(reverseHead);
		
		slow.next = reverseAg;
		
		return true;
	}

	public static void main(String[] args) {
		
		Node<Integer> n1 = new Node<>(1);
		
		Node<Integer> n2 = new Node<>(2);
		
		Node<Integer> n3 = new Node<>(3);
		
		Node<Integer> n4 = new Node<>(2);
		
		Node<Integer> n5 = new Node<>(1);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		
		System.out.println(isPalindrome(n1));

	}

}
