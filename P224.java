import java.util.Stack;

/*
 * 224. Basic Calculator
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
*/
public class P224 {
	
    public int calculate(String s) {
    	return aux('('+s+')');
    }
    
    public int aux(String s) {
    	Stack<Character> oper = new Stack<>();
        Stack<Integer> num = new Stack<>();
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if(c==' ') continue;
        	else if(c=='(') oper.push(c);
        	else if(c=='+' || c=='-') {
        		if(oper.peek() != '(') {
        			char op = oper.pop();
        			int num2 = num.pop();
        			int num1 = num.pop();
        			if(op=='+') num.push(num1+num2);
        			else num.push(num1-num2);
        		}
        		oper.push(c);
        	}else if(c==')') {
        		char op = oper.pop();
        		if(op != '(') {
        			int num2 = num.pop();
            		int num1 = num.pop();
            		if(op=='+') num.push(num1+num2);
            		else num.push(num1-num2);
            		oper.pop();
        		}
        	}
        	else if(c>='0'&&c<='9') {
        		if(i!=0 && s.charAt(i-1)>='0'&&s.charAt(i-1)<='9') {
        			num.push(num.pop()*10+c-'0');
        		}else num.push(c-'0');
        	}
        }
        return num.peek();
    }
    
	public static void main(String[] args) {
		String input = "1+(4+5+2)-3";
		P224 test = new P224();
		System.out.println(test.calculate(input));
	}

}
