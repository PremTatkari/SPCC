import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Vector;

class TAC {
    public static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
        
            case '*':
            case '/':
                return 2;
        
            case '^':
                return 3;
        }
        return -1;
    }
    public static void main(String[] args) {
        String expr = "(a+b)*(c-d)";
        String res = "";

        System.out.println("\nExpression: " + expr);


        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if(Character.isLetter(c)) {
                res += c;
            }
            else if(c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    res += stack.peek();
                    stack.pop();
                }
                stack.pop();
            }
            else {
                while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    res += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            res += stack.peek();
            stack.pop();
        }
        System.out.println("\nPostfix: " + res);

        Vector<String> v = new Vector<String>();
        char t = 'O';
        for (int i = 0; i < res.length(); i++) {
            char c = res.charAt(i);
            if(c == '+') {
                t++;
                String st = t + "=" + res.charAt(i-2) + "+" + res.charAt(i-1);
                res = res.substring(0, i-2) + t + res.substring(i+1); 
                v.add(st);
                i=0;
            }
            if(c == '-') {
                t++;
                String st = t + "=" + res.charAt(i-2) + "-" + res.charAt(i-1);
                res = res.substring(0, i-2) + t + res.substring(i+1); 
                v.add(st);
                i=0;
            }
            if(c == '*') {
                t++;
                String st = t + "=" + res.charAt(i-2) + "*" + res.charAt(i-1);
                res = res.substring(0, i-2) + t + res.substring(i+1); 
                v.add(st);
                i=0;
            }
            if(c == '/') {
                t++;
                String st = t + "=" + res.charAt(i-2) + "/" + res.charAt(i-1);
                res = res.substring(0, i-2) + t + res.substring(i+1); 
                v.add(st);
                i=0;
            }
        }
        System.out.println("\n3AC:");

        for (String string : v) {
            System.out.println(string);
        }
        System.out.println();
    }
}