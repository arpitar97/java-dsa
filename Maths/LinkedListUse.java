package pack1;

import java.util.Scanner;

public class LinkedListUse {
	
	
	public static Node<Integer> insert(Node<Integer> head, int data, int pos){
		
		
		Node<Integer> newNode = new Node<>(data);
		
		if(pos==0) {
			
			newNode.next=head;
			return newNode;
			
		}
		

		
		int i=0;
		
		Node<Integer> temp = head;
		
		while(i<pos-1) {
			i++;
			temp=temp.next;
		}
		
		
		newNode.next=temp.next;
		temp.next=newNode;
		
	     return head;
		
	}
	
	
	public static Node<Integer> takeInput(){
		
		Scanner s = new Scanner(System.in);
		
		int data = s.nextInt();
		
		
		Node<Integer> head=null, tail=null;
		
		while(data!=-1) {
			
			Node<Integer> newNode = new Node<>(data);
			
			if(head==null) {
				head=newNode;
				tail=newNode;
			}
			
			else {
				
//				Node<Integer> temp = head;
//				
//				while(temp.next!=null) {
//					temp=temp.next;
//				}
//				
//				temp.next=newNode;
				tail.next=newNode;
				tail=newNode;
				
				
			}
			
			data=s.nextInt();
			
		}
		
		return head;
	}
	
	public static void print(Node<Integer> head) {
		
		while(head!=null) {
	
			System.out.print(head.data + " ");
			
			head=head.next;
			
		}
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> head = takeInput();
		head = insert(head,80,0);
		print(head);

	}

}
