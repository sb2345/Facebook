import java.io.*;
import java.util.*;

class Solution {
    private boolean checkSubArray(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = nums.length;
        while (right < len) {
            sum += nums[right]; 
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                return true;
            }
            right++;
        }
        return false;
    }
    
    public boolean checkSubMatrix(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int col = 0;
        while (col < colLen) {
            int[] sum = new int[rowLen];
            int colIndex = col;
            while (colIndex < colLen) {
                int row = 0;
                while (row < rowLen) {
                    sum[row] += matrix[row][colIndex];
                    row++;
                }
                if (checkSubArray(target, sum)) {
                    return true;
                }
                colIndex++;
            }
            col++;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {
            {1, 2, 4},
            {3, 4, 7}
        };
        System.out.print(s.checkSubMatrix(17, matrix));
    }
}
