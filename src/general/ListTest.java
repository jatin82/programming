package general;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<10;i++) list.add(i);
		
		System.out.println(list.size());
		
		
		for(int i=0;i<10;i++) {
			list.remove(list.size()-1);
			System.out.println(list.size());
		}
		
		System.out.println("final:"+list.size());
		
	}
}
