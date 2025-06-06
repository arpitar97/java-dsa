package linkedlist1;

public class SwapTwoNodes {

	public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {

		if(head==null || head.next==null || i==j) {
			return head;
		}
		
		Node<Integer> firstNodePrev=null, firstNode=null, secondNodePrev=null, secondNode=null;
		
		Node<Integer> currentNode=head, prev=null;
		
		int pos=0;
		
		while(currentNode!=null) {
			
			if(pos==i) {
				firstNodePrev=prev;
				firstNode=currentNode;
			}
			
			else if(pos==j) {
				secondNodePrev=prev;
				secondNode=currentNode;
			}
			
			prev=currentNode;
			currentNode=currentNode.next;
			pos++;
		}
		
		if(firstNodePrev!=null) {
			firstNodePrev.next=secondNode;
		}
		
		else {
			head=secondNode;
		}
		
		if(secondNodePrev!=null) {
			secondNodePrev.next=firstNode;
		}
		
		else {
			head=firstNode;
		}
		
		Node<Integer> temp = secondNode.next; //Stores the reference after second node so it doesn't get lost
		
		secondNode.next = firstNode.next;
		
		firstNode.next = temp;
		
		return head;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
