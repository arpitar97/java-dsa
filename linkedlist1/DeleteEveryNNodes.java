package linkedlist1;

public class DeleteEveryNNodes {
	
	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N){
		
		Node<Integer> currentNode = head; //pointer for iterating
		
		Node<Integer> temp=null; // pointer for final linked list to be returned
		
		while(currentNode!=null) {
			
			int add = 0;
			
			int del = 0;
			
			while(currentNode!=null && add<M) {
				
				if(temp==null) {
					temp=currentNode;
				}
				
				else {
					temp.next=currentNode;
					temp=temp.next;
				}
				
				currentNode=currentNode.next;
				add++;
				
			}
			
			while(currentNode!=null && del<N) {
				
				currentNode=currentNode.next;
				del++;
				
			}
			
			temp.next=null;
			
			return head;
			
		}
		
		
		
		
		return null;
	}

	public static void main(String[] args) {
		

	}

}
