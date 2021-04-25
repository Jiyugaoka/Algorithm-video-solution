 /**
 方法一：前序遍历
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if (root == nullptr) return "#";
        return to_string(root->val) + "," + serialize(root->left) + "," + serialize(root->right);
    }

    queue<string> split(string& str) {
        queue<string> ans;
        if (str.empty()) return ans;
        int size = str.size();
        int pre = 0;
        for (int i = 0; i <= size; i++) {
            if (i == size || str[i] == ',') {
                ans.emplace(str.substr(pre, i - pre));
                pre = i + 1;
            }
        }
        return ans;
    }

    TreeNode* deserialize(queue<string>& data) {
        if (data.empty()) return nullptr;
        string val = data.front();
        data.pop();
        if (val == "#") return nullptr;
        TreeNode* root = new TreeNode(stoi(val));
        root->left = deserialize(data);
        root->right = deserialize(data);
        return root;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        queue<string> res = split(data);
        return deserialize(res);
    }
};
/**
 方法二：后序遍历
*/
class Codec {
public:
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if (root == nullptr) return "#";
        return serialize(root->left) + "," + serialize(root->right) + "," + to_string(root->val);
    }

    queue<string> split(string& str) {
        queue<string> ans;
        if (str.empty()) return ans;
        int size = str.size();
        int pre = size;
        for (int i = size - 1; i >= -1; i--) {
            if (i == -1 || str[i] == ',') {
                ans.emplace(str.substr(i + 1, pre - i - 1));
                pre = i;
            }
        }
        return ans;
    }

    TreeNode* deserialize(queue<string>& data) {
        if (data.empty()) return nullptr;
        string val = data.front();
        data.pop();
        if (val == "#") return nullptr;
        TreeNode* root = new TreeNode(stoi(val));
        root->right = deserialize(data);
        root->left = deserialize(data);
        return root;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        queue<string> res = split(data);
        return deserialize(res);
    }

    // 使用栈保存分割后的字符串
    stack<string> split(string& str) {
        stack<string> ans;
        if (str.empty()) return ans;
        int size = str.size();
        int pre = 0;
        for (int i = 0; i <= size; ++i) {
            if (i == size || str[i] == ',') {
                ans.emplace(str.substr(pre, i - pre));
                pre = i + 1;
            }
        }
        return ans;
    }

    TreeNode* deserialize(stack<string>& data) {
        if (data.empty()) return nullptr;
        string val = data.top();
        data.pop();
        if (val == "#") return nullptr;
        TreeNode* root = new TreeNode(stoi(val));
        root->right = deserialize(data);
        root->left = deserialize(data);
        return root;
    }

    TreeNode* deserialize(string data) {
        stack<string> res = split(data);
        return deserialize(res);
    }
};