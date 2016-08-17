package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M347_TopKFrequentElements {

	/**
	 * https://leetcode.com/problems/top-k-frequent-elements/
	 */
	public static void main(String[] args) {
		
		M347_TopKFrequentElements obj = new M347_TopKFrequentElements();
		
//		System.out.println("[1,1,1,2,2,3],2 -> [1,2] -> result:" + obj.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
		System.out.println("[4,1,-1,2,-1,2,3],2 -> [-1,2] -> result:" + obj.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2));
	}
	
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
    	
        if(nums != null && nums.length > 0){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i=0; i<nums.length; i++){
            	int count = 0;
            	if(map.containsKey(nums[i])){
            		count = map.get(nums[i]);
            	}
            	map.put(nums[i], ++count);
            }
            
            MinHeap minHeap = new MinHeap(k);
            for(int key : map.keySet()){
            	Element element = new Element(key, map.get(key));
            	if(!minHeap.isFull() || element.count > minHeap.getMin().count){
            		minHeap.insert(element);
            	}
            }
            
            List<Element> elements = minHeap.getAll();
            for(int i=0; i<elements.size(); i++){
            	list.add(elements.get(i).value);
            }            
        }
        
        return list;
    }
	
    class Element{
    	int value;
    	int count;
    	public Element(int value, int count){
    		this.value = value;
    		this.count = count;
    	}
    }
    
    class MinHeap{
    	private Element[] heap;
    	private int maxSize;
    	private int currentSize;
    	
    	public MinHeap(int size){
    		maxSize = size;
    		currentSize = 0;
    		heap = new Element[maxSize];
    	}
    	
    	/**
    	 * insert the element into heap
    	 * true means insert the element is done
    	 * false means the heap is full and the element is smaller than the minimum element of heap
    	 * */
    	public boolean insert(Element element){
    		if(isFull()){
    			if(getMin().count >= element.count){
    				return false;
    			}else{
    				heap[0] = element;
    				sinkHeap();
    				return true;
    			}
    		}else{
    			heap[currentSize++] = element;
    			swimHeap();
    			return true;
    		}
    	}
    	
    	/**
    	 * remove the minimum element, heap[0]
    	 * true, means remove the minimum element is done
    	 * false, means the heap is empty, do nothing
    	 * */
    	public boolean removeMin(){
    		if(isEmpty()){
    			return false;
    		}else{
    			heap[0] = heap[currentSize-1];
    			currentSize--;
    			sinkHeap();
    			return true;
    		}
    	}
    	
    	public boolean isEmpty(){
    		return currentSize <= 0;
    	}
    	
    	public boolean isFull(){
    		return currentSize >= maxSize;
    	}
    	
    	public Element getMin(){
    		if(isEmpty()){
    			return null;
    		}
    		return heap[0];
    	}
    	
    	public List<Element> getAll(){
    		List<Element> list = new ArrayList<Element>();
    		for(int i=0; i<currentSize; i++){
    			list.add(heap[i]);
    		}
    		return list;
    	}
    	
    	/**
    	 * heap[0] is new, adjust heap from up to down
    	 * */
    	private void sinkHeap(){
    		int i = 0;		// root
    		int j = i*2+1;  // left
    		
    		while(j < currentSize){
    			if(j+1 < currentSize && heap[j+1].count < heap[j].count){
    				j = j+1; // right
    			}
    			if(heap[i].count <= heap[j].count){
    				break;
    			}else{
    				// do sink
    				Element temp = heap[i];
    				heap[i] = heap[j];
    				heap[j] = temp;
    				i = j;
    				j = i*2+1;
    			}
    		}
    	}
    	
    	
    	/**
    	 * heap[currentSize-1] is new, adjust heap from down to up
    	 * */
    	private void swimHeap(){
    		int j = currentSize-1; 
    		int i = (j-1)/2;
    		
    		while(i >= 0){
    			if(heap[i].count <= heap[j].count){
    				break;
    			}else{
    				// do swim
    				Element temp = heap[i];
    				heap[i] = heap[j];
    				heap[j] = temp;
    				j = i;
    				i = (j-1)/2;
    			}
    		}
    	}
    	
    }

}
