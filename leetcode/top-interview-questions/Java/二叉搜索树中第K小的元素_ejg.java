class Solution {
    class Temp {
        int res = 0;
        int n = 0;
    }
    private int res = 0, n = 0;
    public int kthSmallest(TreeNode root, int k) {
        // dfs(root, n, k);
        // return res;
        Temp temp = new Temp();
        dfs(root, temp, k);
        return temp.res;
    }
    void dfs(TreeNode root, int n, int k) {
        // 错误写法，仅为了对比
        if (root.left != null) {
            dfs(root.left, n, k);
        }

        n++;
        System.out.println("cur n is: " + n);
        System.out.println("cur root.val is: " + root.val);
        
        if (n == k) {
            res = root.val;
            return ;
        }

        if (root.right != null) {
            dfs(root.right, n, k);
        }
    }

    void dfs(TreeNode root, Temp temp, int k) {
        if (root.left != null) {
            dfs(root.left, temp, k);
        }

        temp.n++;
        System.out.println("cur n is: " + temp.n);
        System.out.println("cur root.val is: " + root.val);
        if (temp.n == k) {
            temp.res = root.val;
            return ;
        }
        
        if (root.right != null) {
            dfs(root.right, temp, k);
        }
    }
}