import java.util.Stack;

public class P150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
		for(String token : tokens) {
			if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				int op2 = nums.pop();
				int op1 = nums.pop();
				switch (token.charAt(0)) {
					case '+':
						nums.push(op1+op2);
						break;
					case '-':
						nums.push(op1-op2);
						break;
					case '*':
						nums.push(op1*op2);
						break;
					case '/':
						nums.push(op1/op2);
						break;
				}
			}else {
				nums.push(Integer.parseInt(token));
			}
		}
		return nums.pop();
    }
}