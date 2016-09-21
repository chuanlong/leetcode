package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H174_DungeonGame {

	/**
	 * https://leetcode.com/problems/dungeon-game/
	 */
	public static void main(String[] args) {

		H174_DungeonGame obj = new H174_DungeonGame();
		
//		obj.calculateMinimumHP(new int[][]{{1,-2,3}, {2,-2,-2}});   // [[1,-2,3],[2,-2,-2]]
//		obj.calculateMinimumHP(new int[][]{{1,-4,5,-99}, {2,-2,-2,-1}});   // [[1,-4,5,-99],[2,-2,-2,-1]]
		obj.calculateMinimumHP(new int[][]{{1,-3,3}, {0,-2,0}, {-3,-3,-3}});
		
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
    	
		List[][] hps = new List[m][n];
    	
		hps[0][0] = new ArrayList<HP>();
    	hps[0][0].add(new HP(dungeon[0][0], Math.max(1, 1-dungeon[0][0])));
    	
    	for(int i=1; i<m; i++){    		
    		hps[i][0] = cal(hps[i-1][0], dungeon[i][0]);
    	}
    	
    	for(int j=1; j<n; j++){
    		hps[0][j] = cal(hps[0][j-1], dungeon[0][j]);
    	}
    	
    	for(int i=1; i<m; i++){
    		for(int j=1; j<n; j++){
    			hps[i][j] = new ArrayList<HP>();
    			hps[i][j].addAll(cal(hps[i-1][j], dungeon[i][j]));
    			hps[i][j].addAll(cal(hps[i][j-1], dungeon[i][j]));
    			hps[i][j] = sort(hps[i][j]);
    		}
    	}
    	
    	return ((HP) hps[m-1][n-1].get(0)).minHP;
    }
	
    
    class HP implements Comparable<HP>{
    	int curHP;
    	int minHP;
    	public HP(int curHP, int minHP){
    		this.curHP = curHP;
    		this.minHP = minHP;
    	}
    	
		@Override
		public int compareTo(HP o) {
			if(minHP < o.minHP || (minHP == o.minHP && curHP > o.curHP)){
				return -1;
			}else if(minHP == o.minHP && curHP == o.curHP){
				return 0;
			}else{
				return 1;
			}
		}    	
    }
    
    private List<HP> cal(List<HP> pre, int dungeon){
    	List<HP> cur = new ArrayList<HP>();
    	for(int i=0; i<pre.size(); i++){
    		HP hp = pre.get(i);
    		
    		int curHP = hp.curHP + dungeon;
    		int minHP = Math.max(hp.minHP, 1-curHP);
    		cur.add(new HP(curHP, minHP));
    	}
    	return cur;
    }
    
    private List<HP> sort(List<HP> hps){    	
    	Collections.sort(hps);
    	
    	List<HP> newHPs = new ArrayList<HP>();
    	int minCurHP = Integer.MAX_VALUE;
    	
    	while(hps.size() > 0){
    		HP hp = hps.get(0);
    		if(newHPs.size() == 0 || hp.minHP > newHPs.get(newHPs.size()-1).minHP){
    			if(minCurHP == Integer.MAX_VALUE || (minCurHP != Integer.MAX_VALUE && hp.curHP > minCurHP)){
    				newHPs.add(hp);
    				minCurHP = Math.min(minCurHP, hp.curHP);
    			}
    		}
    		hps.remove(hp);
    	}

    	return newHPs;
    }

}
