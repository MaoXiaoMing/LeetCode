import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class P284 implements Iterator<Integer> {
	List<Integer> iter;
	int index;
	
	public P284(Iterator<Integer> iterator) {
	    // initialize any member here.
		iter = new ArrayList<Integer>();
		index = 0;
	    while(iterator.hasNext()) {
			iter.add(iterator.next());
		}
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return iter.get(index);
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return iter.get(index++);
	}

	@Override
	public boolean hasNext() {
	    if(index >= iter.size()) return false;
		return true;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<3; i++) list.add(i);
		System.out.println();
	}
	
}