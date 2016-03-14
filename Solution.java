import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	if(numbers==null || numbers.length<=1) return false;
        for(int i=0; i<length; i++) {
            if(numbers[i] == i) continue;
            while(numbers[i] != i) {
                if(numbers[numbers[i]] == i) {
                    duplication[0] = numbers[i];
                    return true;
                }else {
					int temp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        return true;
    }
	
    public int StrToInt(String str) {
        if(str==null || str.length()==0) return 0;
        int symbol = str.charAt(0)=='-'?1:0;
        int sum = 0;
        for(int i=symbol; i<str.length(); i++) {
            if(str.charAt(i) == '+') continue;
            if(str.charAt(i)<'0' || str.charAt(i)>'9') return 0;
            sum = sum*10 + str.charAt(i)-'0';
        }
        return sum;
    }
	
    public int Sum_Solution(int n) {
        int sum = n;
        boolean value = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
	
    public boolean isContinuous(int [] numbers) {
		if(numbers==null || numbers.length!=5) return false;
        Arrays.sort(numbers);
        int count = 0;
        for(int num : numbers) count = num==0?count+1:count;
        int index = count;
        if(numbers[index] > 14-numbers.length+count) return false;
        while(index<numbers.length-1) {
        	if(numbers[index] == numbers[index+1]) return false;
            if(numbers[index]+1!=numbers[index+1]) {
                int gap = numbers[index+1]-numbers[index]-1;
                if(gap > count) return false;
                else count -= gap;
            }
            index++;
        }
        return true;
    } 
	
    public String ReverseSentence(String str) {
        if(str==null || str.trim().length()<=1) return str;
        String[] tokens = str.split(" ");
        String cont = "";
        for(int i=0; i<tokens.length; i++) {
            StringBuilder sb = new StringBuilder(tokens[i]);
            cont += sb.reverse()+" ";
        }
        return new StringBuilder(cont.substring(0, cont.length()-1)).reverse().toString();
    }
	
    public String LeftRotateString(String str,int n) {
        if(str==null || str.length()<=1 || n<=0) return str;
        int length = str.length();
        n %= length;
        StringBuilder left = new StringBuilder(str.substring(0, n));
        StringBuilder right = new StringBuilder(str.substring(n));
        StringBuilder re = new StringBuilder(left.reverse().toString()+right.reverse());
        return re.reverse().toString();
    }
	
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array==null || array.length<=1) return res;
        int left = 0;
        int right = array.length-1;
        while(left < right ) {
            if((array[left]+array[right]) == sum) {
                if(res.size() != 0) {
                    if(res.get(0)*res.get(1) > array[left]*array[right]) {
                        res.clear();
                        res.add(array[left]);
                        res.add(array[right]);
                    }
                }else {
                    res.add(array[left]);
					res.add(array[right]);
                }
                left++; right--;
            }else if(array[left]+array[right] > sum) {
            	right--;
            }else left++;
        }
        return res;
    }
	
	
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(sum <= 2) return res;
		int small = 1; 
		int big = 2;
		int mid = (sum-1)>>1;
		int count = small + big;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(small); list.add(big);
		while(small<=mid) {
			if(count == sum) {
				res.add(new ArrayList<>(list));
				list.remove(0);
				count -= small;
				small++;
			}
			while(small<=mid && count>sum) {
				count -= small;
				small++;
				list.remove(0);
			}
			while(big<=sum && count<sum) {
				big++;
				count += big;
				list.add(big);
			}
		}
		return res;
	}
	
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length<=1) return ;
        int aux = 0;
        for(int i=0; i<array.length; i++) aux ^= array[i];
        int bit = aux^(aux-1);
        num1[0] = 0;
        num2[0] = 0;
        for(int num : array) {
            if((num&bit) == 0) num1[0] ^= num;
            else num2[0] ^= num;
        }
    }
	
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        int[] l = new int[1];
       	boolean left = IsBalanced_Solution(root.left, l);
        int[] r = new int[1];
        boolean right = IsBalanced_Solution(root.right, r);
        if(left&&right&&Math.abs(r[0]-l[0])<=1) return true;
        else return false;
    }
    
    public boolean IsBalanced_Solution(TreeNode root, int[] depth) {
        if(root==null) {
            depth[0] = 0;
            return true;
        }
        int[] l = new int[1];
       	boolean left = IsBalanced_Solution(root.left, l);
        int[] r = new int[1];
        boolean right = IsBalanced_Solution(root.right, r);
        if(left&&right&&Math.abs(r[0]-l[0])<=1) {
            depth[0] = Math.max(l[0], r[0])+1;
            return true;
        }
        else return false;
    }
	
    public int GetNumberOfK(int [] array , int k) {
    	if(array==null || array.length==0) return 0;
        int low = 0, high = array.length-1;
        while(low < high) {
            int mid = low+(high-low)/2;
            if(array[mid] > k) high = mid-1;
            else if(array[mid] < k) low = mid+1;
            else high = mid;
        }
        if(array[low] != k) return -1;
        int left = low;
        low = 0;
        high = array.length-1;
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(array[mid] > k) high = mid-1;
            else if(array[mid] < k) low = mid+1;
            else {
                low = mid;
                if(low+1>=high) {
                    if(array[high] == k) return high-left+1;
                    else return low-left+1;
                }
            }
        }
        return -1;
    }
	
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		int length1 = length(pHead1);
        int length2 = length(pHead2);
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        if(length1 > length2) {
            int k = length1-length2;
            while(k > 0) {
                node1 = node1.next;
                k--;
            }
        }else if(length1<length2) {
            int k = length2-length1;
            while(k > 0) {
                node2 = node2.next;
                k--;
            }
        }
        while(node1!=node2 && node1!=null) {
                node1 = node1.next;
                node2 = node2.next;
        }
        if(node1!=null) return node1;
        else return null;
    }
    
    public int length(ListNode head) {
        if(head == null) return 0;
        else return length(head.next)+1;
    }
    
    public int InversePairs(int [] array) {
        if(array==null || array.length<=1) return 0;
        return mergeCount(array, 0, array.length-1);
    }
    
    public int mergeCount(int[] array, int start, int end) {
        if(start < end) {
            int mid = start+(end-start)/2;
            int left = mergeCount(array, start, mid);
            int right = mergeCount(array, mid+1, end);
            return left+right+merge(array, start, mid, end);
        }
        return 0;
    }
    
    public int merge(int[] array, int start, int mid, int end) {
        int count = 0;
        int[] temp = new int[end-start+1];
        int i, j;
        for(i=start, j=mid+1; i<=mid && j<=end; ) {
            if(array[i]<=array[j]) {
                temp[i+j-start-mid-1] = array[i++];
                count += (j-mid-1);
            }else temp[i+j-start-mid-1] = array[j++];
        }
        while(i<=mid) {
            temp[i+j-start-mid-1] = array[i];
            count += (j-mid-1);
            i++;
        }
        while(j<=end) {
            temp[i+j-start-mid-1] = array[j];
            j++;
        }
        for(i=start; i<=end; i++) array[i] = temp[i-start];
        return count;
    }
	
    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length()==0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c ,map.get(c)+1);
            }else {
                map.put(c, 1);
            }
        }
        for(int i=0; i<str.length(); i++) {
            if(map.get(str.charAt(i))== 1) return i;
        }
        return -1;
    }
	
    public int GetUglyNumber_Solution(int index) {
        int[] dp = new int[index];
        dp[0] = 1;
    	int two = 0;
        int three = 0;
        int five = 0;
        int count = 1;
        while(count < index) {
            int i = dp[two]*2;
            int j = dp[three]*3;
            int k = dp[five]*5;
            int cand = Math.min(Math.min(i, j), k);
            if(i==cand) two++;
            if(j==cand) three++;
            if(k==cand) five++;
            dp[count] = cand;
            count++;
        }
        return dp[index-1];
    }
    
    public int[] multiply(int[] A) {
		if(A==null || A.length==0) return A;
        int[] res = new int[A.length];
        res[0] = 1;
        for(int i=1; i<res.length; i++) res[i] = res[i-1]*A[i-1];
        int aux = A[A.length-1];
        for(int i=res.length-2; i>=0; i--) {
            res[i] *= aux;
            aux *= A[i];
        }
        return res;
    }
    
    public boolean match(char[] str, char[] pattern)
    {
        if(str.length==0) return pattern.length==0;
        return match(str, 0, pattern, 0);
    }
    
    public boolean match(char[] str, int index1, char[] pattern, int index2) {
        if(index2==pattern.length) return index1==str.length;
        if(index2<pattern.length-1 && pattern[index2+1]=='*') {
        	if(match(str, index1, pattern, index2+2)) return true;
            for(int i=index1; i<str.length&&(str[i]==pattern[index2]||pattern[index2]=='.'); i++) {
                if(match(str, i+1, pattern, index2+2)) return true;
            }
            return false;
        }else if(pattern[index2] == '.') 
        	return match(str, index1+1, pattern, index2+1);
        else return index1<str.length&&str[index1]==pattern[index2]&&match(str, index1+1, pattern, index2+1);
    }
    
    public boolean isNumeric(char[] str) {
        if(str==null) return false;
        int symbol = (str[0]=='-'||str[0]=='+')?1:0;
        int index;
        boolean fiction = false;
        for(index=symbol; index<str.length&&str[index]!='E'&&str[index]!='e'; index++) {
            if(str[index]=='.') {
                if(fiction) return false;
                else fiction=true;
            }else if(str[index]>'9' || str[index]<'0') return false;
        }
        if(index==str.length) return true;
        if((index==str.length-1))  return false;
        symbol = (str[index+1]=='-'||str[index+1]=='+')?1:0;
        for(int i=index+1+symbol; i<str.length; i++) {
            if(str[i]>'9' || str[i]<'0') return false;
        }
        return true;
    }
    
    int[] map;
   	int size;
    //Insert one char from stringstream
    
    public Solution() {
        map = new int[256];
        size = 0;
        for(int i=0; i<map.length; i++) map[i] = -1;
    }
    
    public void Insert(char ch)
    {
        if(map[ch]==-1) map[ch] = size++;
        else map[ch]=-2;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char res = '#';
        int index = size;
    	for(int i=0; i<map.length; i++) {
            if(map[i]>=0 && index>map[i]) {
                res = (char)i;
                index = map[i];
            }
        }
        return res;
    }
    
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead.next;
        while(fast!=null && fast.next!=null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast==null || fast.next==null) return null;
        int step = 1;
        fast = fast.next;
        while(fast != slow) {
            fast = fast.next;
            step++;
        }
        slow = pHead;
        fast = pHead;
        while(step > 0) {
            fast = fast.next;
            step--;
        }
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
		return slow;
    }
    
    public ListNode deleteDuplication(ListNode pHead)
    {
		if(pHead==null) return null;
        ListNode dummpy = new ListNode(pHead.val-1);
		dummpy.next = pHead;
        ListNode current = pHead;
        ListNode pre = dummpy;
        while(current != null) {
            ListNode next = current.next;
            while(next!=null && next.val==current.val) next = next.next;
            if(next == current.next) {
                pre.next = current;
                pre = pre.next;
                current = next;
            }else current = next;
        }
        pre.next = null;
        return dummpy.next;
    }
    
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }
    
    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        else if(left!=null || right!=null) return false;
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
    
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot==null) return res;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(pRoot);
        boolean left = true;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            if(left) {
                int size = stack1.size();
                while(size > 0) {
                    TreeNode node = stack1.pop();
                    level.add(node.val);
                    if(node.left != null) stack2.push(node.left);
                    if(node.right != null) stack2.push(node.right);
                    size--;
                }
                left = false;
            }else {
                int size = stack2.size();
                while(size > 0) {
                    TreeNode node = stack2.pop();
                    level.add(node.val);
                    if(node.right != null) stack1.push(node.right);
                    if(node.left != null) stack1.push(node.left);
                    size--;
                }
                left = true;
            }
            res.add(level);
        }
        return res;
    }
    
//    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        if(pRoot == null) return res;
//        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(pRoot);
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            ArrayList<Integer> level = new ArrayList<Integer>();
//            while(size > 0) {
//                TreeNode node = queue.poll();
//                level.add(node.val);
//                if(node.left != null) queue.add(node.left);
//                if(node.right != null) queue.add(node.right);
//                size--;
//            }
//            res.add(level);
//        }
//        return res;
//    }
    
    String Serialize(TreeNode root) {
    	if(root == null) return "#";
    	else return root.val+","+Serialize(root.left)+","+Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
    	String[] chars = str.split(",");
    	return Deserialize(chars, 0);
    }
    
    TreeNode Deserialize(String[] strings, int index) {
    	if(index>=strings.length || strings[index].equals("#")) return null;
    	TreeNode node = new TreeNode(Integer.parseInt(strings[index]));
    	node.left = Deserialize(strings, (index<<1)+1);
    	node.right = Deserialize(strings, (index+1)<<1);
    	return node;
    }
    
    int count;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        count = k;
        return kthNode(pRoot);
    }

	TreeNode kthNode(TreeNode root) {
        if(root == null) return null;
       	TreeNode node = kthNode(root.right);
        if(node != null) return node;
        else if(count == 1) return root;
        count--;
        return kthNode(root.left);
    }
	
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public void Insert(Integer num) {
        if(maxHeap.size()<=minHeap.size()+1) {
            maxHeap.offer(num);
            return ;
        }
        if(maxHeap.size()==minHeap.size()+2) minHeap.offer(maxHeap.poll());
    }

    public Double GetMedian() {
        if(maxHeap.size() == minHeap.size()+1) return maxHeap.peek()/1.0;
        else return (maxHeap.peek()+minHeap.peek())/2.0;
    }
    public static void main(String[] args) {
    	Solution test = new Solution();
//    	System.out.println(test.InversePairs(new int[]{1,2,3,4,7,6,5}));
//    	System.out.println(test.GetNumberOfK(new int[]{1,2,2,2,6,7}, 7));
//    	System.out.println(test.FindContinuousSequence(100));
//    	System.out.println(test.FindNumbersWithSum(new int[]{-1, 2,5,6,7,8,12,15, 18}, 17));
//    	System.out.println(test.LeftRotateString("abcXYZdef", 3));
//    	System.out.println(test.ReverseSentence("  "));
//    	System.out.println(test.Sum_Solution(5));
//    	System.out.println(test.multiply(new int[]{2,3,4,5,7,1,9,3}));
//    	System.out.println(test.match("a".toCharArray(), ".*".toCharArray()));
//    	System.out.println(test.isNumeric("123.45e+6".toCharArray()));
//    	System.out.println(test.EntryNodeOfLoop(new ListNode(new int[]{1,2,3})));
//    	String str = test.Serialize(new TreeNode(new Integer[]{8,6,10}, 0));
//    	TreeNode node = test.Deserialize(str);
    	
    	System.out.println(test.KthNode(new TreeNode(new Integer[]{5,3,7,2,4,6,8}, 0), 2).val);
    }
    
}
*/
public class Solution {
	private Heap maxHeap = new Heap(Heap.isMaxHeap);
	private Heap minHeap = new Heap(Heap.isMinHeap);

	public void Insert(Integer num) {
    	if(maxHeap.size() == 0) {
    		maxHeap.add(num);
    		return ;
    	}
    	if(num>maxHeap.peek()) minHeap.add(num);
    	else maxHeap.add(num);
        if(maxHeap.size()==minHeap.size()+2) minHeap.add(maxHeap.pop());
        else if(maxHeap.size()+2 == minHeap.size()) maxHeap.add(minHeap.pop());
    }

    public Double GetMedian() {
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek()/1.0;
        else if(minHeap.size() > maxHeap.size()) return minHeap.peek()/1.0;
        else return (maxHeap.peek()+minHeap.peek())/2.0;
    }
    
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(num==null || num.length==0 || size<=0) return res;
    	Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<size; i++) {
        	while(queue.size()!=0 && num[i]>=num[queue.getLast()])
        		queue.removeLast();
        	queue.addLast(i);
        }    
        for(int i=size; i<num.length; i++) {
            res.add(num[queue.getFirst()]);
            while(queue.size()!=0 && num[i]>=num[queue.getLast()])
        		queue.removeLast();
            if(queue.size()!=0 && queue.getFirst()+size<=i)
        		queue.removeFirst();
        	queue.addLast(i);
        }
        res.add(num[queue.getFirst()]);
        return res;
    }
    
    public boolean hasPath(char[][] matrix, int rows, int cols, char[] str)
    {
    	if(matrix==null || rows<=0 || cols<=0 ||str==null) return false;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(dfs(matrix, i, j, str, 0)) return true;
            }
        }
        return false;
    }

	public boolean dfs(char[][] matrix, int rows, int cols, char[] str, int index) {
        if(index==str.length) return true;
        if(str[index]==matrix[rows][cols]) {
            char c = matrix[rows][cols];
            matrix[rows][cols] = '#';
            if(rows>0 && matrix[rows-1][cols]!='#' && dfs(matrix, rows+1, cols, str, index+1)) return true;
            if(rows<matrix.length-1 && matrix[rows+1][cols]!='#' && dfs(matrix, rows+1, cols, str, index+1)) return true;
            if(cols>0 && matrix[rows][cols-1]!='#' && dfs(matrix, rows, cols-1, str, index+1)) return true;
            if(cols<matrix[0].length-1 && matrix[rows][cols-1]!='#' && dfs(matrix, rows, cols+1, str, index+1)) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
    	Solution test = new Solution();
    	test.Insert(5);
    	System.out.println(test.GetMedian());
    	test.Insert(2);
    	System.out.println(test.GetMedian());
    	test.Insert(3);
    	System.out.println(test.GetMedian());
    	test.Insert(4);
    	System.out.println(test.GetMedian());
    	test.Insert(1);
    	System.out.println(test.GetMedian());
    	test.Insert(6);
    	System.out.println(test.GetMedian());
    	test.Insert(7);
    	System.out.println(test.GetMedian());
    	test.Insert(0);
    	System.out.println(test.GetMedian());
    	test.Insert(8);
    	System.out.println(test.GetMedian());
    }
    
}

class Heap {
    public List<Integer> list = null;
    public static final boolean isMaxHeap = true;
    public static final boolean isMinHeap = false;
    private boolean flag = true;  
    public Heap(){
        this.list = new ArrayList<Integer>();
    }
    public Heap(boolean flag){
        this.list = new ArrayList<Integer>();
        this.flag = flag;
    }
    public int size(){
        return this.list.size();
    }
    public int peek(){
        if(list.size() == 0) return 0;
        return list.get(0);
    }
    public void add(int val){
        this.list.add(val);
        int i = list.size() - 1, index, parent, cur;
        while(i > 0){
            index = (i - 1) / 2;
            parent = list.get(index);
            cur = list.get(i);
            if(flag == true && parent < cur){
                swap(index, i);
            }else if(flag == false && parent > cur){
                swap(index, i);
            }
            i = index;
        }
    }

    public int pop(){
        if(list.size() == 0) return -1;
        int res = list.get(0);
        list.set(0,list.get(list.size() - 1));
        list.remove(list.size()-1);
        int len = list.size() - 1 , i = 0;
        int left , right;
        while(i < len){
            left = (i << 1) + 1;
            right= (i << 1) + 2;
            int maxIndex = i;
            if(flag == true){
                if(left < len && list.get(left) > list.get(maxIndex)) maxIndex = left;
                if(right< len && list.get(right)> list.get(maxIndex)) maxIndex = right;
            }else{
                if(left < len && list.get(left) < list.get(maxIndex)) maxIndex = left;
                if(right< len && list.get(right)< list.get(maxIndex)) maxIndex = right;
            }
            if(maxIndex != i){
                swap(maxIndex,i);
                i = maxIndex;
            }else break;
        }
        return res;
    }
    public void swap(int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j,temp);
    }
}
