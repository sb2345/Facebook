import java.io.*;
import java.util.*;

class Solution {
    public int isExist(String str, String t) {
        int len = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int start = 0;
        int end = 0;
        while (true) {
            if (end - start < t.length()) {
                if (end == str.length()) {
                    break;
                }
                char c = str.charAt(end);
                if (map.containsKey(c)) {
                    if (map.get(c) > 0) {
                        len--;
                    }
                    map.put(c, map.get(c) - 1);
                }
                end++;
            }
            if (end - start == t.length()) {
                if (len == 0) {
                    return start;
                }
                char c = str.charAt(start);
                if (map.containsKey(c)) {
                    if (map.get(c) >= 0) {
                        len++;
                    }
                    map.put(c, map.get(c) + 1);
                }
                start++;
            }   
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isExist("facebook", "acer"));
    }
}