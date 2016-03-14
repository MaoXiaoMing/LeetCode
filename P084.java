import java.util.Stack;

public class P084 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
		int i = 0;
		Stack<Integer> stack = new Stack<>();
		while(i <= heights.length) {
			int height = i==heights.length?-1:heights[i];
			if(stack.isEmpty() || heights[stack.peek()] <= height) {
				//能把等号去掉么
				stack.push(i++);
			}else {
				int last = stack.pop();
				max = Math.max(max, heights[last]*(stack.isEmpty()?i:i-stack.peek()-1));
			}
		}
		return max;
    }
}
