class Solution {
public:
    unordered_map<int, TreeNode*> fa;
    unordered_map<int, bool> vis;
    void dfs(TreeNode* root) {
        // 此dfs不会走重叠的路，保证整棵树只访问一次，很是精髓
        if (root->left != nullptr) {
            fa[root->left->val] = root;
            dfs(root->left);
        }
        if (root->right != nullptr) {
            fa[root->right->val] = root;
            dfs(root->right);
        }
    }

    TreeNode* lowestCommonAncestor1(TreeNode* root, TreeNode* p, TreeNode* q) {
        fa[root->val] = nullptr;
        dfs(root);
        // 自下而上
        while (p != nullptr) {
            vis[p->val] = true;
            p = fa[p->val];
        }
        while (q != nullptr) {
            if (vis[q->val]) return q;
            q = fa[q->val];
        }
        return nullptr;
    }

    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        // 递归访问，自上而下
        // 此递归同样也不会走重叠的路，保证整棵树只访问一次，同样很精髓
        if (root == nullptr || p == root || q == root) {
            return root;
        }

        TreeNode* l = lowestCommonAncestor(root->left, p, q);
        TreeNode* r = lowestCommonAncestor(root->right, p, q);
    
        // return l == nullptr ? r : (r == nullptr ? l : root);
        if (l == nullptr) {
            return r;
        } else {
            if (r == nullptr) {
                return l;
            } else {// 说明此刻p、q正好是root的左右子节点。
                return root;
            }
        }
    }
};