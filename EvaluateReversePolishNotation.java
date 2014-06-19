/*
Evaluate Reverse Polish Notation
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op1 + op2);
            }
            else if (tokens[i].equals("-")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 - op1);
            }
            else if (tokens[i].equals("*")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 * op1);
            }
            else if (tokens[i].equals("/")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 / op1);
            }
            else if (isInteger(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
    
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
