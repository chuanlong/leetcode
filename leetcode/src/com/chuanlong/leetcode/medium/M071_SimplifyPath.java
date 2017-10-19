package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M071_SimplifyPath {

	public static void main(String[] args) {

	}
	
	
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
        	return path;
        }
        
        String[] tokens = path.split("/");
        List<String> list = new ArrayList<String>();
        for (int i=0; i<tokens.length; i++) {
        	String token = tokens[i];
        	if ("".equals(token) || ".".equals(token)) {
        		// ignore
        	} else if("..".equals(token)) {
        		if(list.size() > 0) list.remove(list.size()-1);
        	} else {
        		list.add(token);
        	}
        }
        
        String p = "";
        if (list.size() > 0) {
        	for(int i=0; i<list.size(); i++) {
        		p = p + "/" + list.get(i);
        	}
        } else {
        	p = "/";
        }
    	return p;
    }

}
