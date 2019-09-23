package com.prabhat.data.structure;

public class PriorityQueue {
	
	private PriorityElement[] pq;
	private int size=0;
	
	public PriorityQueue(int n) {
		this.pq = new PriorityElement[n+1];
	}
	
	public void insert(int value,int priority) {
			PriorityElement item = new PriorityElement(value, priority);
			pq[0] = new PriorityElement(Integer.MIN_VALUE, Integer.MAX_VALUE);
			pq[this.size+1] = item; 
			this.size++;
			heapifyUp(pq,this.size);
	}

	public void delete(int value,int priority) {
		int index = 1;
		for(int i=index ; i<=this.size ; i++) {
			if(pq[i] != null) {
				if(pq[i].getValue() == value && pq[i].getKey()==priority) {
					pq[i].setKey(pq[this.size].getKey());
					pq[i].setValue(pq[this.size].getValue());
					pq[this.size] = null;
					this.size--;
					break;
				}
			}
		}
		System.out.println(index);
		heapifyDown(pq,index);
	}
	private void heapifyUp(PriorityElement[] pq, int index) {
		int parentIndex = 0;
		if(index > 0) {
			parentIndex = this.size/2;
	        if(pq[parentIndex] != null) {
	        	if(pq[parentIndex].getKey()>pq[index].getKey()){
	        		pq[0].setKey(pq[parentIndex].getKey());
	        		pq[0].setValue(pq[parentIndex].getValue());
	        		pq[parentIndex].setKey(pq[index].getKey());
	        		pq[parentIndex].setValue(pq[index].getValue());
	        		pq[index].setKey(pq[0].getKey());
	        		pq[index].setValue(pq[0].getValue());
	        		//pq[0] = null;
	        		heapifyUp(pq, parentIndex);
	        	}
	        }
		}
	}
	
	private int peek() {
		return pq[1].getValue();
	}
	
	private void heapifyDown(PriorityElement[] pq, int index) {
		int childIndex = 0;
		if(2*index > this.size) {
			return;
		}
		else if(2*index == this.size) {
			childIndex = this.size;
		}
		else if (2*index < this.size) {
			int leftIndex = 2*index;
			int rightIndex = 2*index+1;
			if(pq[leftIndex].getKey()<pq[rightIndex].getKey()) {
				childIndex = leftIndex;
			}else {
				childIndex = rightIndex;
			}
		}
		System.out.println("childIndex::"+pq[childIndex]+"Index::"+pq[index]);
		if(pq[childIndex].getKey() < pq[index].getKey()) {
			pq[0].setKey(pq[childIndex].getKey());
    		pq[0].setValue(pq[childIndex].getValue());
    		pq[childIndex].setKey(pq[index].getKey());
    		pq[childIndex].setValue(pq[index].getValue());
    		pq[index].setKey(pq[0].getKey());
    		pq[index].setValue(pq[0].getValue());
    		heapifyDown(pq, childIndex);
			
		}
	}
	
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(10);
		pq.insert(10, 2);
		pq.insert(24, 1);
		pq.insert(13, 3);
		pq.insert(12, 4);
		pq.insert(11, 5);
		pq.insert(57, 1);
		System.out.println(pq.peek());
		pq.delete(24, 1);
		System.out.println(pq.peek());
		
	}

}
