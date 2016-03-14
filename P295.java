import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*295. Find Median from Data Stream
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2*/

public class P295 {
	Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	Queue<Integer> minHeap = new PriorityQueue<>();

	// Adds a number into the data structure.
	public void addNum(int num) {
		if(maxHeap.size()==0) {
			maxHeap.offer(num);
			return ;
		}
		int max = maxHeap.peek();
		if(num < max) maxHeap.offer(num);
		else minHeap.offer(num);
		if(maxHeap.size() == minHeap.size()+2) minHeap.offer(maxHeap.poll());
		else if(maxHeap.size()+2 == minHeap.size()) maxHeap.offer(minHeap.poll());
	}

	// Returns the median of current data stream
	public double findMedian() {
		if(maxHeap.size()>minHeap.size()) return maxHeap.peek();
		else if(minHeap.size() > maxHeap.size()) return minHeap.peek();
		else return (maxHeap.peek()+minHeap.peek())/2.0;
	}

	public static void main(String[] args) {
		P295 mf = new P295();
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
	}

}
