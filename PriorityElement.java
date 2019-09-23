package com.prabhat.data.structure;

public class PriorityElement {
   private int value;
   private int key;

   
   public PriorityElement(int value, int key) {
	super();
	this.value = value;
	this.key = key;
}


public int getValue() {
	return value;
}


public void setValue(int value) {
	this.value = value;
}


public int getKey() {
	return key;
}


public void setKey(int key) {
	this.key = key;
}
   
   
}
