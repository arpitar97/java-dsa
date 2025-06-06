package linkedlist1;

public class PrintReverseLinkedList {
	
	public static void printReverseLL(Node<Integer> head) {
		
		if(head==null) {
			return;
		}
		
		printReverseLL(head.next);
		
		System.out.print(head.data+" ");
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
