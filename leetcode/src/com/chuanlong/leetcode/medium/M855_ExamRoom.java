package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class M855_ExamRoom {

    class ExamRoom {

        private Map<Integer, int[]> start;
        private Map<Integer, int[]> end;
        private PriorityQueue<int[]> queue;
        private int nn;

        public ExamRoom(int n) {
            nn = n;
            start = new HashMap<>();
            end = new HashMap<>();
            queue = new PriorityQueue<>((a,b) -> {
                int distance1 = nextSeatDistance(a[0], a[1]);
                int distance2 = nextSeatDistance(b[0],b[1]);
                if(distance1 == distance2) {
                    return a[0]-b[0];
                } else {
                    return distance2-distance1;
                }
            });
            put(new int[]{0, n-1});
        }

        public int seat() {
            int[] oldSeat = queue.peek();
            remove(oldSeat);
            int mid = nextSeatPosition(oldSeat[0], oldSeat[1]);
            if(oldSeat[0] <= mid-1) {
                put(new int[]{oldSeat[0], mid-1});
            }
            if(mid+1 <= oldSeat[1]) {
                put(new int[]{mid+1, oldSeat[1]});
            }
            return mid;
        }

        public void leave(int p) {
            int[] cur = new int[]{p, p};
            if(end.containsKey(p-1)) {
                int[] prev = end.get(p-1);
                remove(prev);
                cur[0] = prev[0];
            }
            if(start.containsKey(p+1)) {
                int[] next = start.get(p+1);
                remove(next);
                cur[1] = next[1];
            }
            put(cur);
        }

        private int nextSeatDistance(int s, int e) {
            if(s==0) return e-s-1;
            else if (e == nn-1) return e-s-1;
            return (s+e)/2-1-s;
        }

        private int nextSeatPosition(int s, int e) {
            if(s==0) return s;
            else if (e == nn-1) return nn-1;
            return (s+e)/2;
        }

        private void remove(int[] seat) {
            start.remove(seat[0]);
            end.remove(seat[1]);
            queue.remove(seat);
        }

        private void put(int[] seat) {
            start.put(seat[0], seat);
            end.put(seat[1], seat);
            queue.offer(seat);
        }
    }

    class ExamRoom1 {

        private Map<Integer, int[]> start;
        private Map<Integer, int[]> end;
        private PriorityQueue<int[]> queue;
        private int nn;

        public ExamRoom1(int n) {
            nn = n;
            start = new HashMap<>();
            end = new HashMap<>();
            queue = new PriorityQueue<>((a,b) -> {
                int select1 = nextSeatDistance(a[0], a[1]);
                int select2 = nextSeatDistance(b[0],b[1]);
                if(select1 == select2) {
                    return a[0]-b[0];
                } else {
                    return select2-select1;
                }
            });
            int[] seat = new int[]{0, n-1};
            start.put(0, seat);
            end.put(n-1, seat);
            queue.offer(seat);
        }

        public int seat() {
            int[] oldSeat = queue.poll();
            start.remove(oldSeat[0]);
            end.remove(oldSeat[1]);
            int mid;
            if(oldSeat[0] == 0) {
                mid = 0;
            } else if(oldSeat[1] == nn-1) {
                mid = nn-1;
            } else {
                mid = (oldSeat[0]+oldSeat[1])/2;
            }

            if(oldSeat[0] <= mid-1) {
                int[] newSeat1 = new int[]{oldSeat[0], mid-1};
                queue.offer(newSeat1);
                start.put(newSeat1[0], newSeat1);
                end.put(newSeat1[1], newSeat1);
            }
            if(mid+1 <= oldSeat[1]) {
                int[] newSeat2 = new int[]{mid+1, oldSeat[1]};
                queue.offer(newSeat2);
                start.put(newSeat2[0], newSeat2);
                end.put(newSeat2[1], newSeat2);
            }
            return mid;
        }

        public void leave(int p) {
            if(end.containsKey(p-1) && start.containsKey(p+1)) {
                int[] prev = end.get(p-1);
                int[] next = start.get(p+1);
                start.remove(prev[0]);
                start.remove(next[0]);
                end.remove(prev[1]);
                end.remove(next[1]);
                queue.remove(prev);
                queue.remove(next);

                int[] cur = new int[]{prev[0], next[1]};
                start.put(cur[0], cur);
                end.put(cur[1], cur);
                queue.offer(cur);
            } else if (end.containsKey(p-1) && !start.containsKey(p+1)) {
                int[] prev = end.get(p-1);
                start.remove(prev[0]);
                end.remove(prev[1]);
                queue.remove(prev);

                int[] cur = new int[]{prev[0], p};
                start.put(cur[0], cur);
                end.put(cur[1], cur);
                queue.offer(cur);
            } else if (!end.containsKey(p-1) && start.containsKey(p+1)){
                int[] next = start.get(p+1);
                start.remove(next[0]);
                end.remove(next[1]);
                queue.remove(next);

                int[] cur = new int[]{p, next[1]};
                start.put(cur[0], cur);
                end.put(cur[1], cur);
                queue.offer(cur);
            } else {
                int[] cur = new int[]{p, p};
                start.put(cur[0], cur);
                end.put(cur[1], cur);
                queue.offer(cur);
            }
        }

        private int nextSeatDistance(int s, int e) {
            if(s==0) return e-s-1;
            else if (e == nn-1) return e-s-1;
            return (s+e)/2-1-s;
        }

    }

}
