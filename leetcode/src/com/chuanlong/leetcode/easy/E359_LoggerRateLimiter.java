package com.chuanlong.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E359_LoggerRateLimiter {
    class Logger {
        private Map<String, Integer> map;
        public Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if(map.containsKey(message) && timestamp-map.get(message)<10) {
                return false;
            } else {
                map.put(message, timestamp);
                return true;
            }
        }
    }
}
