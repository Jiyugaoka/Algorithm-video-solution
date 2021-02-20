class Solution {
    public int calculate1(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        char lastOp = '+';
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') continue;
            if (Character.isDigit(arr[i])) {
                int tempNum = arr[i] - '0';
                while(++i < arr.length && Character.isDigit(arr[i])){
                    tempNum = tempNum * 10 + (arr[i] - '0');
                } 
                i--;
                if (lastOp == '+') numStack.offerLast(tempNum);
                else if (lastOp == '-') numStack.offerLast(-tempNum);
                else {
                    int res = lastOp == '*' ? numStack.pollLast() * tempNum : numStack.pollLast() / tempNum;
                    numStack.offerLast(res);
                }
            } else lastOp = arr[i];
        }
        int ans = 0;
        for (int num : numStack) ans += num;
        return ans;
    }  

    public int calculate(String s) {
        Deque<Integer> num = new LinkedList<>();
        Deque<Character> symbol = new LinkedList<>(); 
        Set<Character> sym = new HashSet<>();
        sym.add('+');
        sym.add('-');
        sym.add('*');
        sym.add('/');
        int N = s.length(), temp = 0;
        for (char c: s.toCharArray()) {
            if (c == ' ') continue; 
            if (!sym.contains(c)) {// 此处c是一个数字
                // 【易错点一：不是一个单独的数字，比如123。】
                temp = temp * 10 + (c - '0');
            } else {// 此处c是一个运算符
                num.offerLast(temp);
                // 【易错点二：运算符有优先级，要区别对待。】
                if (!symbol.isEmpty()) {
                    boolean flag1 = symbol.peekLast() == '*', flag2 = symbol.peekLast() == '/';
                    boolean flag3 = symbol.peekLast() == '+', flag4 = symbol.peekLast() == '-';
                    if (flag1 || flag2) {
                        int num2 = num.pollLast(), num1 = num.pollLast(), res = 0;
                        symbol.pollLast();
                        if (flag1) {
                            res = num1 * num2;
                        } else {
                            res = num1 / num2;
                        }
                        num.offerLast(res);
                    }
                }
                symbol.offerLast(c);
                temp = 0;                    
            }
        }
        // 【易错点三：最后一个运算符后边的数，计算完了却并没有添加进nums栈中，需要手动添加。】
        num.offerLast(temp);
        // 【易错点四：最后一个运算符左右两边的数，并没有经过运算就直接添加进入了栈中，若是高级运算符会出错。】
        if (!symbol.isEmpty() && (symbol.peekLast() == '*' || symbol.peekLast() == '/')) {
            int num2 = num.pollLast(), num1 = num.pollLast(), res = 0;
            char operator = symbol.pollLast();
            res = operator == '*' ? num1 * num2 : num1 / num2;
            num.offerLast(res);
        }
        // 【易错点五：最后需要从左至右依次计算结果。】
        // 
        while (!symbol.isEmpty()) {
            int num1 = num.pollFirst(), num2 = num.pollFirst(), res = 0;
            char operator = symbol.pollFirst();
            if (operator == '+') {
                res = num1 + num2;
            } else if (operator == '-') {
                res = num1 - num2;
            } else if (operator == '*') {
                res = num1 * num2;
            } else {
                res = num1 / num2;
            }
            num.offerFirst(res);
        }
        // 最后数字栈中只剩一个元素，就是最终的运算结果。
        return num.peekFirst();
    }
}