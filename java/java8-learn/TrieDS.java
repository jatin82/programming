package com.Interview;

import java.util.Map;

public class Dictionary {

	static class trie{
		trie[] nextNodes = new trie[256];//lower case
		String value;
		boolean isTerminal;
		
		trie(String value,boolean isTerminal){
			this.value = value;
			this.isTerminal = isTerminal;
		}
	}
	
	static class TrieDS{
		
		trie root;
		
		public TrieDS() {
			this.root = new trie("",false);
		}
		
		public void add(String key,String value){
			if(key.isEmpty()) return;
			key = key.toLowerCase();
			addUtil(key, value, this.root);
		}
		private void addUtil(String key,String value,trie node){
			if(key.isEmpty()){
				node.isTerminal = true;
				node.value = value;
				return;
			}
			
			char c = key.charAt(0);
			int index = (int)c;
			if(node.nextNodes[index]==null){
				node.nextNodes[index] = new trie(null,false);
			}
			
			String newKey=null;
			if(key.length()==1){
				newKey="";
			}
			else newKey = key.substring(1);
			
			addUtil(newKey,value,node.nextNodes[index]);
		}
		
		public String getMeaning(String key){
			if(key.isEmpty()) return null;
			key = key.toLowerCase();
			return find(this.root,key);
		}
		
		private String find(trie node,String key){
			if(node==null) return null;

			if(key.isEmpty()){
				if(node.isTerminal){
					return node.value;
				}
				else return null;
			}
			
			int index = key.charAt(0);
			trie child = node.nextNodes[index];
			if(child==null){
				return null;
			}
			
			String newKey=null;
			if(key.length()==1){
				newKey="";
			}
			else newKey = key.substring(1);
			return find(child,newKey);
		}
	}
	
	public static void main(String[] args) {
		TrieDS dictionary = new TrieDS();
		dictionary.add("Jatin Sokhal", "He is super coder!!");
		dictionary.add("Jatin Sokhals", "He is super coder!! Jatin Sokhals");
		dictionary.add("Jatin Sokhalsa", "He is super coder!! Jatin Sokhalsa");
		
		System.out.println(dictionary.getMeaning("JatinSokhal"));
		System.out.println(dictionary.getMeaning("Jatindokhal"));
		System.out.println(dictionary.getMeaning("JatinSohal"));
		dictionary.add("Jatin Sohal", "He is Jatin Sohal");
		System.out.println(dictionary.getMeaning("JatinSohal"));
		System.out.println(dictionary.getMeaning("JatinSokhal"));
		System.out.println(dictionary.getMeaning("Jatin Sokhal"));
		System.out.println(dictionary.getMeaning("Jatin Sohal"));
		System.out.println(dictionary.getMeaning("Jatin Sokhals"));
		System.out.println(dictionary.getMeaning("Jatin Sokhalsa"));
	}
}
