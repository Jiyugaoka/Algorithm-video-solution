class Solution {

    class TreeNode {
        TreeNode[] next;
        String flag;
        public TreeNode() {
            next = new TreeNode[26];
            flag = "";
        }
    }

    private void insert(String word) {
        TreeNode cur = this.root;
        for (char c: word.toCharArray()) {
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new TreeNode();
            }
            cur = cur.next[c - 'a'];
        }
        cur.flag = word;
    }

    private boolean contains(char x, TreeNode root){
        if (root.next[x - 'a'] == null) return false;
        return true;
    }

    private List<String> res = new ArrayList<>(); 
    private int[] dx = new int[] {-1, 1, 0, 0};
    private int[] dy = new int[] {0, 0, -1, 1};
    private TreeNode root = new TreeNode(); 
    private int m, n;

    public List<String> findWords(char[][] board, String[] words) {
        for (String word: words) this.insert(word);
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.contains(board[i][j], this.root)) {
                    dfs(board, i, j, this.root);
                }    
            }
        }
        return this.res;
    }

    private void dfs(char[][] board, int i, int j, TreeNode root) {
        TreeNode cur = root.next[board[i][j] - 'a'];
        if (!cur.flag.equals("")) {
            res.add(cur.flag);
            cur.flag = ""; // 这里修改了字典树，可以使每个单词仅被访问一次。
        }
        char ss = board[i][j];
        board[i][j] = '.'; // 设为访问标记，防止多次访问。
        for (int ind = 0; ind < 4; ind++) {
            int newR = i + dx[ind];
            int newC = j + dy[ind];
            if (0 <= newR && newR < this.m && 0 <= newC && newC < this.n && board[newR][newC] != '.') {
                if (this.contains(board[newR][newC], cur)) {
                    dfs(board, newR, newC, cur);
                }
            }
        }
        board[i][j] = ss; // 恢复棋盘
    }
}

