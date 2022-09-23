package com.chuanlong.leetcode.medium;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class M721_AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emails = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for(int i=0; i<accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for(int j=1; j<account.size(); j++) {
                String email = account.get(j);
                if(!emails.containsKey(email)) emails.put(email, new ArrayList<>());
                emails.get(email).add(i);
            }
        }

        Queue<Integer> queue = new LinkedBlockingQueue<>();
        boolean[] visited = new boolean[accounts.size()];
        for(int i=0; i<accounts.size(); i++) {
            if(visited[i]) continue;
            queue.offer(i);
            visited[i] = true;
            list.add(processQueue(queue, visited, emails, accounts, accounts.get(i).get(0)));
        }
        return list;
    }


    private List<String> processQueue(Queue<Integer> queue,
                                      boolean[] visited,
                                      Map<String, List<Integer>> emails,
                                      List<List<String>> accounts,
                                      String name) {
        TreeSet<String> newAccount = new TreeSet<>(String::compareTo);
        while(!queue.isEmpty()) {
            int index = queue.poll();
            List<String> account = accounts.get(index);
            for(int i=1; i<account.size(); i++) {
                String email = account.get(i);
                List<Integer> indexes = emails.get(email);
                for(int j=0; j<indexes.size(); j++) {
                    if(!visited[indexes.get(j)]) {
                        queue.offer(indexes.get(j));
                        visited[indexes.get(j)] = true;
                    }
                }
                newAccount.add(email);
            }
        }
        List<String> newAccount2 = new ArrayList<>();
        newAccount2.add(name);
        newAccount2.addAll(newAccount);
        return newAccount2;
    }

}
