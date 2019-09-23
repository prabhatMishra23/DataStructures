package com.prabhat.data.structure;

public class TrieNode {

	private TrieNode[] childrens;
	
	private boolean isWord;

	public TrieNode() {
		childrens = new TrieNode[128];
		isWord = false;
	}

	public void insertWord(TrieNode N,String s) {
		for(int i=0;i<s.length();i++) {
			int j = (int)s.charAt(i);
			if(N.childrens[j] ==null) {
				N.childrens[j] = new TrieNode();
			}
			N = N.childrens[j];
		}
		N.isWord = true;
	}
	
	public boolean getWord(TrieNode N,String s) {
		for(int i=0;i<s.length();i++) {
			if(N.childrens[s.charAt(i)]!=null) {
			     N = N.childrens[s.charAt(i)];
			     if(N.isWord && i==s.length()-1) {
			    	 return true;
			     }
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		TrieNode N  = new TrieNode();
		N.insertWord(N, "shella");
		N.insertWord(N,"she");
		System.out.println(N.getWord(N, "she"));
		System.out.println(N.getWord(N, "shela"));
		
	}
}
