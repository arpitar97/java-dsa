package linkedlist1;

public class BubbleSortLinkedList {
	
	//Time Complexity : O(N^2)
	//Space Complexity : O(1)
	
	public static int length(Node<Integer> head) {
		
		int count=0;
		
		while(head!=null) {
			head=head.next;
			count++;
		}
		
		return count;
		
	}
	
	
	public static Node<Integer> bubbleSort(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		
		int n = length(head);
		
		for(int i=0; i<n-1; i++) {
			Node<Integer> curr = head;
			Node<Integer> prev = null;
			
			for(int j=0; j<n-1-i; j++) {
				
				if(curr.data<=curr.next.data) {
					prev=curr;
					curr=curr.next;
				}
				
				else {
					if(prev==null) {
						Node<Integer> fwd = curr.next;
						head=head.next;
						curr.next=fwd.next;
						fwd.next=curr;
						prev=fwd;
					}
					
					else {
						Node<Integer> fwd = curr.next;
						curr.next = fwd.next;
						fwd.next = curr;
						prev.next = fwd;
						prev = fwd;
					}
				}
			}
		}
		
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
