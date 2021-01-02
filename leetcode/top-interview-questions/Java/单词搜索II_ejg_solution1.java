class Solution {

    class TreeNode {
        TreeNode[] next;
        boolean flag;
        public TreeNode() {
            next = new TreeNode[26];
            flag = false;
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
        cur.flag = true;
    }

    private boolean search(String word) {
        TreeNode cur = this.root;
        for (char c: word.toCharArray()) {
            if (cur.next[c - 'a'] == null) {
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.flag;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = this.root;
        for (char c: prefix.toCharArray()) {
            if (cur.next[c - 'a'] == null) {
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return true;
    }

    private Set<String> set = new HashSet<>(); 
    private int[] dx = new int[] {-1, 1, 0, 0};
    private int[] dy = new int[] {0, 0, -1, 1};
    private TreeNode root = new TreeNode(); 
    private int m, n;

    public List<String> findWords(char[][] board, String[] words) {
        for (String word: words) this.insert(word);
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                char orginal = board[i][j];
                sb.append(board[i][j]);
                board[i][j] = '#';
                dfs(sb, i, j, board);
                board[i][j] = orginal;
            }
        }
        return new ArrayList<>(this.set);
    }

    private void dfs(StringBuilder sb, int i, int j, char[][] board) {
        String str = sb.toString();
        if (!this.startsWith(str)) return ;
        if (this.search(str)) {
            if (this.set.contains(str)) return ;
            this.set.add(str);
        }  

        for (int ind = 0; ind < 4; ind++) {
            int newR = i + this.dx[ind];
            int newC = j + this.dy[ind];
            if (0 <= newR && newR < this.m && 0 <= newC && newC < this.n && board[newR][newC] != '#') {   
                char orginal = board[newR][newC];
                sb.append(board[newR][newC]);
                board[newR][newC] = '#';
                dfs(sb, newR, newC, board);
                // 退出之前要删除，使得下一个使用sb和board的dfs看不到上一次的修改。
                sb.deleteCharAt(sb.length() - 1);
                board[newR][newC] = orginal;
            }
        }     
    }
}