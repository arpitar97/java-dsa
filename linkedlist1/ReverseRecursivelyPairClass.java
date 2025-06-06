package linkedlist1;

public class ReverseRecursivelyPairClass {
	
	
	public static Pair reverseRecursively(Node<Integer> head) {
		
		if(head==null || head.next==null) {
			Pair p = new Pair();
			p.head=head;
			p.tail=head;
			return p;
		}
		
		Pair smallAns = reverseRecursively(head.next);
		
		smallAns.tail.next=head;
		
		head.next=null;
		
		smallAns.tail=head;
		
		return smallAns;
		
	}
	
	public static void print(Node<Integer> head) {
		
		Node<Integer> temp = head;
		
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		
        Node<Integer> n1 = new Node<>(1);
		
		Node<Integer> n2 = new Node<>(2);
		
		Node<Integer> n3 = new Node<>(3);
		
		Node<Integer> n4 = new Node<>(4);
		
		Node<Integer> n5 = new Node<>(5);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		
		Pair p = reverseRecursively(n1);
		
		print(p.head);

	}

}


class Pair{
	
	Node<Integer> head;
	
	Node<Integer> tail;
	
}
