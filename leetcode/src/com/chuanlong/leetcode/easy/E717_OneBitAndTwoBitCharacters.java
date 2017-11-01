package com.chuanlong.leetcode.easy;

public class E717_OneBitAndTwoBitCharacters {

	public static void main(String[] args) {

	}
	
	
    public boolean isOneBitCharacter(int[] bits) {
        if(bits == null){
        	return false;
        }else if(bits.length == 1){
        	return true;
        }else if(bits.length == 2){
        	return bits[0] == 0;
        }else{
        	int len = bits.length;
        	boolean[] valids = new boolean[len];
        	
        	valids[0] = bits[0] == 0;
        	valids[1] = (bits[1] == 0 || bits[0] == 1);
        	for(int i=2; i<len-1; i++){
        		if(bits[i] == 0){
        			valids[i] = true;
        		}else{
        			if(!valids[i-1] && valids[i-2] && bits[i-1] == 1){
        				valids[i] = true;
        			}else{
        				valids[i] = false;
        			}
        		}
        	}
        	
        	if(valids[len-3] && bits[len-2] == 1){
        		return false;
        	}else{
        		return true;
        	}
        }
    }

}
