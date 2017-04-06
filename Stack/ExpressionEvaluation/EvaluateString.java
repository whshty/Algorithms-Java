package ExpressionEvaluation;

/**
 * Created by tengy on 4/5/2017.
 */

import java.util.Stack;

class EvaluateString {
    public static void main(String[] args) throws java.lang.Exception {
        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 ) / 14"));
    }

    public static int evaluate(String expression) {
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();

        char[] input = expression.toCharArray();

        for (int i = 0; i < input.length; i++) {

            if (input[i] == ' ') continue;

            if (input[i] >= '0' && input[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < input.length && input[i] >= '0' && input[i] <= '9') {
                    sb.append(input[i++]);
                }
                values.push(Integer.parseInt(sb.toString()));
            } else if (input[i] == '(') {
                operators.push(input[i]);
            } else if (input[i] == ')') {
                while (operators.peek() != '(') {
                    values.push(useOperators(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (input[i] == '+' || input[i] == '-' || input[i] == '*' || input[i] == '/') {
                while (!operators.isEmpty() && hasPrecedence(input[i], operators.peek())) {
                    values.push(useOperators(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(input[i]);
            }
        }


        while (!operators.isEmpty()) {
            int temp = useOperators(operators.pop(), values.pop(), values.pop());
            values.push(temp);
        }


        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }


    public static int useOperators(char op, int b, int a) {
        if (op == '+') {
            return a + b;

        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else if (op == '/') {
            if (b == 0) {
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
            }
            return a / b;
        }
        return 0;
    }
}