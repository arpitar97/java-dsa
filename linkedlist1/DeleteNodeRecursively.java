package linkedlist1;

public class DeleteNodeRecursively {
	
	public static Node<Integer> deleteRec(Node<Integer> head, int pos){
		
		if(head==null) {
			return head;
		}
		
		if(pos==0) {
			return head.next;
		}
		
		head.next = deleteRec(head.next, pos-1);
		
		return head;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
