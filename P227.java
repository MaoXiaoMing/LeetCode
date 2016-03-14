import java.util.Stack;

public class P227 {
    public int calculate(String s) {
		if(s==null || s.length()==0) return 0;
        Stack<Character> op = new Stack<>();
		Stack<Integer> num = new Stack<>();
		char[] array = (s+"#").toCharArray();
		if(array[0]>='0' && array[0]<='9') num.push(array[0]-'0');
		for(int i=1; i<s.length(); i++) {
			if(array[i]==' ') continue;
			if(array[i]>='0'&&array[i]<='9') {
				if(array[i-1]>='0'&&array[i-1]<='9') {
					num.push(num.pop()*10+array[i]-'0');
				}else {
					num.push(array[i]-'0');
				}
			}else {
				if(!op.isEmpty()) {
					char pre = op.pop();
					int num2 = num.pop();
					int num1 = num.pop();
					if(array[i]=='+'||array[i]=='-'||array[i]=='#') {
						switch(pre) {
						case '+':
							num.push(num1+num2);
							break;
						case '-':
							num.push(num1-num2);
							break;
						case '*':
							num.push(num1*num2);
							break;
						case '/':
							num.push(num1/num2);
							break;
						}
					}else {
						if(pre=='*'||pre=='/') {
							switch(pre) {
								case '*':
									num.push(num1*num2);
									break;
								case '/':
									num.push(num1/num2);
									break;
							}
						}
					}
				}
				op.push(array[i]);
			}
		}
		return num.peek();
    }
}