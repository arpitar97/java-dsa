package linkedlist1;

import java.util.Scanner;

public class LinkedListUse {
	
	public static void print(Node<Integer> head) {
		
		Node<Integer> temp = head;
		
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		
		System.out.println();
	}
	
	public static Node<Integer> takeInput(){
		
		Scanner s = new Scanner(System.in);
		
		Node<Integer> head = null;
		
		Node<Integer> tail = null;
		
		int data = s.nextInt();
		
		while(data!=-1) {
			
			Node<Integer> newNode = new Node<>(data);
			
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			
			else {
				tail.next = newNode;
				tail = newNode;
			}
			
			data = s.nextInt();
		}
		
		return head;
		
	}
	
	public static Node<Integer> insertNode(Node<Integer> head, int pos, int data){
		
		Node<Integer> newNode = new Node<>(data);
		
		int index=0;
		
		Node<Integer> temp = head;
		
		if(pos==0) {
			
			newNode.next=temp;
			return newNode;
			
		}
		
		while(temp!=null && index<pos-1) {
			temp=temp.next;
			index++;
		}
		
		newNode.next=temp.next;
		temp.next=newNode;
		
		return head;
		
	}
	
	public static Node<Integer> deleteNode(Node<Integer> head, int pos, int data){
		
        int index=0;
		
		Node<Integer> temp = head;
		
		if(head==null) {
			return head;
		}
		
		if(pos==0) {
			
           return temp.next;
			
		}
		
		while(temp!=null && index<pos-1) {
			temp=temp.next;
			index++;
		}
		
		if(temp==null || temp.next==null) {
			return head;
		}
		
		temp.next=temp.next.next;
		
		return head;
		
	}

	public static void main(String[] args) {

	}

}
