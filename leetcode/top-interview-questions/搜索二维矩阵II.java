class Solution {
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    break;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] < target) {
                    break;
                }
            }
        }
        return false;
    }
}