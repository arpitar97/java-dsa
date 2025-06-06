package maps;

import java.util.ArrayList;

public class Map<K,V> {
	
	ArrayList<MapNode<K,V>> buckets;
	int size;
	int numBuckets;
	
	public Map() {
		numBuckets=5;
		buckets=new ArrayList<>();
		for(int i=0; i<numBuckets; i++) {
			buckets.add(null);
		}
	}
	
	private int getBucketIndex(K key) {
		int hashCode=key.hashCode();
		return hashCode % numBuckets;
	}
	
	public int size() {
		return size;
	}
	
	public double loadFactor() {
		return (1.0*size)/numBuckets;
	}
	
	public V removeKey(K key) {
		
		int bucketIndex = getBucketIndex(key);
		
		MapNode<K,V> head = buckets.get(bucketIndex);
		MapNode<K,V> prev = null;
		
		
		while(head!=null) {
			
			if(head.key.equals(key)) {
			    size--;
				V value = head.value;
				if(prev==null) {
					buckets.set(bucketIndex, prev);
				}
				else {
					prev.next=head.next;
				}
				return value;
			}
			prev=head;
			head=head.next;
		}
		return null;
	}
	
	public V getVaue(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		
		while(head!=null) {
			
			if(head.key.equals(key)) {
				V value = head.value;
				return value;
			}
			
			head=head.next;
		}
		return null;
	}
	
	
	public void insert(K key, V value) {
		
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		
		while(head!=null) {
			
			if(head.key.equals(key)) {
				head.value=value;
				return;
			}
			
			head=head.next;
		}
		
		head=buckets.get(bucketIndex);
		MapNode<K,V> newElementNode = new MapNode<K,V>(key,value);
		size++;
		newElementNode.next=head;;
		buckets.set(bucketIndex, newElementNode);
		
		double loadFactor=(1.0*size)/numBuckets;
		
		if(loadFactor>0.7) {
			rehash();
		}
		
	}

	private void rehash() {
		
		System.out.println("Rehashing:buckets:"+numBuckets+" size:"+size);
		
		ArrayList<MapNode<K,V>> temp=buckets;
		
		buckets=new ArrayList<>();
		
		numBuckets=numBuckets*2;
		
		size=0;
		
		for(int i=0; i<numBuckets; i++) {
			buckets.add(null);
		}
		
		for(int i=0; i<temp.size(); i++) {
			MapNode<K,V> head=temp.get(i);
			while(head!=null) {
				K key=head.key;
				V value=head.value;
				insert(key,value);
				head=head.next;
			}
		}
	}

}
