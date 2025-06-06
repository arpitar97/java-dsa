package linkedlist1;

public class InsertRecursively {
	
	
	public static Node<Integer> insertRecursively(Node<Integer> head, int pos, int elem){
		
		if(pos==0) {
			Node<Integer> newNode = new Node<>(elem);
			newNode.next=head;
			return newNode;
		}
		
		if(head==null) {
			return head;
		}
		
		
		head.next = insertRecursively(head.next, pos-1, elem);
		return head;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
