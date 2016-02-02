import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {
    public String minWindow(String s, String t) {
        if (t.length() <= 0 || s.length() < t.length()) {
            return "";
        }
        int start = 0, end = 0;
        int i = 0, j = 0, count = t.length(), min = s.length() + 1;
        int[] table = new int[256];
        
        for (int k = 0; k < count; k++){
            char c = t.charAt(k);
            table[c]++;
        }
        for (int k = 0; k < 256; k++) {
            if (table[k] < 1) {
                table[k] = Integer.MIN_VALUE;
            }
        }
    while (end < s.length()) {
        while (end < s.length() && count > 0) {
            char c = s.charAt(end);
            end++;
            if (table[c] != Integer.MIN_VALUE) {
                if (table[c] > 0) {
                    count--;
                }
                table[c]--;
            }
        }
        if (count > 0) {
            break;
        }
        while (start < s.length() && count <= 0) {
            char c = s.charAt(start);
            start++;
            if (table[c] != Integer.MIN_VALUE) {
                if (table[c] >= 0) {
                    count++;
                }
                table[c]++;
            }
        }
        if (end - start + 1 < min) {
            min = end - start + 1;
            i = start - 1;
            j = end;
        }
    }
    return min == s.length() + 1 ? "" : s.substring(i, j);
}
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abcde";
        String t = "ce";
        String ans = sol.minWindow(s, t);
        System.out.print(ans);
    }
}