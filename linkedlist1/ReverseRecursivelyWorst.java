package linkedlist1;

public class ReverseRecursivelyWorst {
	
	
	public static Node<Integer> reverseRecursively(Node<Integer> head){
		
		if(head==null || head.next==null) {
			return head;
		}
		
		Node<Integer> smallAns = reverseRecursively(head.next);
		
		Node<Integer> temp = smallAns;
		
		while(temp.next!=null) {
			temp=temp.next;
		}
		
		temp.next=head;
		
		head.next=null;
		
		return smallAns;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
