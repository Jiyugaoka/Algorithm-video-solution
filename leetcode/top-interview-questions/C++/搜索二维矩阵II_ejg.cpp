class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.size() == 0) return false;
        int m = matrix.size(), n = matrix[0].size();        //矩阵为m行，n列
        int row = 0, col = n-1;                             //从右上角开始寻找目标值
        while(row <= m-1 && col >= 0)
        {
            if(target > matrix[row][col])        ++row;
            else if(target < matrix[row][col])   --col;
            else if(target == matrix[row][col])  return true;
        }
        return false;
    }
};