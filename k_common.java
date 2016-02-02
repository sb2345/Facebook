import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 5, 20}, 
            {1, 7, 20, 30}, 
            {1, 4, 20, 30},
            {4, 20, 30}
        };
        Solution sol = new Solution();
        int ans = sol.firstKCommonElements(arr, 4);
        System.out.print(ans);
    }
    
    private int firstKCommonElements(int[][] arrays, int k) {
        if (arrays == null || arrays.length == 0) {
            return -1;
        }
        int n = arrays.length;
        int[] pointers = new int[n];
        for (int i = 0; i < n; i++) {
            pointers[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            while (pointers[i] < arrays[i].length) {
                int num = arrays[i][pointers[i]]; //不能在index变了之后，再用index. 
                if (hasKCommonElements(arrays, pointers, i, k)) {
                    return num;
                }
            }
        }
        return -1;
    }
    
    private boolean hasKCommonElements(int[][] arrays, int[] pointers, int idx, int k) {
        int cnt = 1;
        int num = arrays[idx][pointers[idx]]; 
        pointers[idx]++;
        for (int i = idx; i < pointers.length; i++) {
            while (pointers[i] < arrays[i].length && arrays[i][pointers[i]] <= num) {
                if (arrays[i][pointers[i]] == num) {
                    cnt++;
                }
                pointers[i]++;
            }
        }
        return cnt >= k;
    }
}