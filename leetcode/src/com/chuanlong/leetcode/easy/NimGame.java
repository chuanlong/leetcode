package com.chuanlong.leetcode.easy;

public class NimGame {

	/**
	 * https://leetcode.com/problems/nim-game/
	 */
	public static void main(String[] args) {
		
		NimGame nimGame = new NimGame();
		
		System.out.println("1348820612 isWin:" + nimGame.canWinNim(1348820612));
	}
	
	
	public boolean canWinNim(int n) {
//		boolean[] a = new boolean[(n+1) > 4 ? (n+1) : 4];
//		a[0] = false;
//		a[1] = true;
//		a[2] = true;
//		a[3] = true;
//		
//		for(int i = 4; i < n+1; i++){
//			if(a[i-3] && a[i-2]  && a[i-1] ){
//				a[i] = false;
//			}else{
//				a[i] = true;
//			}
//		}
//		
//		return a[n];
		
		// 0 false, 1/2/3 true
		int x = n % 4;
		if(x == 0){
			return false;
		}else{
			return true;
		}
		
    }

}
