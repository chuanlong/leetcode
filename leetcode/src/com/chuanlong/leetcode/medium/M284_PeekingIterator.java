package com.chuanlong.leetcode.medium;

import java.util.Iterator;

public class M284_PeekingIterator {

	/**
	 * https://leetcode.com/problems/peeking-iterator/
	 * */
	public static void main(String[] args) {

	}
	
	
	class PeekingIterator implements Iterator<Integer> {

		private Iterator<Integer> iterator;
		private Integer next;
		
		
		public PeekingIterator(Iterator<Integer> iterator) {
			this.iterator = iterator;
			this.next = null;
		    goNext();
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	        return next;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
		    Integer cur = next;
		    goNext();
		    return cur;
		}

		@Override
		public boolean hasNext() {
		    return next != null;
		}
		
		private void goNext(){
			if(iterator != null){
				if(iterator.hasNext()){
					next = iterator.next();
				}else{
					next = null;
				}
			}else{
				next = null;
			}
		}
		
		
	}
	
	

}
