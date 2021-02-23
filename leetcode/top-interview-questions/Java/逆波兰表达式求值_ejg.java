class Solution {
    private Deque<Integer> stack = new LinkedList<>();
    private Set<String> operator = new HashSet<>() {{
        add("+");
        add("-");
        add("*");
        add("/");
    }};
    
    public int evalRPN(String[] tokens) {
        for (String token: tokens) {
            if (operator.contains(token)) {
                int num2 = stack.pollLast(), num1 = stack.pollLast(); 
                int res = eval(token, num1, num2);
                stack.offerLast(res);
            } else {
                stack.offerLast(Integer.valueOf(token));
            }
        }
        return stack.peekLast();
    }

    private int eval(String op, int num1, int num2) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        } 
        return 0; 
    }
}