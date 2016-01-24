import java.util.List;

public class Util<E> {
	public static void p(Object o) {
		System.out.println(o);
	}
	
	public static void displayList(List<String> list) {
		for(String e : list) 
			System.out.println(e);
	}
	
}
