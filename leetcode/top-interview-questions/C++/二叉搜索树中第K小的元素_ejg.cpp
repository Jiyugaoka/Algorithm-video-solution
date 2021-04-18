/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    int res = 0, n = 0;
public:
    int kthSmallest0(TreeNode* root, int k) {
        // 递归
        dfs(root, n, k);
        return res;
    }

    void dfs(TreeNode* root, int& n, const int k) {
        if (root->left != nullptr) {
            dfs(root->left, n, k);
        }
        
        n++;
        cout<<"cur n is: "<<n<<endl;
        cout<<"cur root->val is: "<<root->val<<endl;

        if (n == k) {
            res = root->val;
            return ;
        }
        
        if (root->right != nullptr) {
            dfs(root->right, n, k);
        }
    }

    void dfs1(TreeNode* root, int n, const int k) {
        // 这是错误写法，仅为了对比
        if (root->left != nullptr) {
            dfs(root->left, n, k);
        }

        n++;
        cout<<"cur n is: "<<n<<endl;
        cout<<"cur root->val is: "<<root->val<<endl;

        if (n == k) {
            res = root->val;
            return ; // 加了return 语句可以提前结束递归
        }
        
        if (root->right != nullptr) {
            dfs(root->right, n, k);
        }
    }

    int kthSmallest(TreeNode* root, int k) {
        //迭代
        stack<TreeNode*>sk;
        int res;
        int n = 1;
        TreeNode* cur = root;
        while(!sk.empty() || cur != nullptr){
            while(cur != nullptr){
                sk.push(cur);
                cur = cur->left;
            }
            cur = sk.top();
            sk.pop();
            if(n == k) return cur->val;
            n++;
            cur = cur->right;
        }
        return 0;
    }
};