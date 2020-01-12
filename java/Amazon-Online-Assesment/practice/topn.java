package Amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopNBuzzWords {
	

	
	public static List<String> top(int numToys,int topToys,String[] toys,int numQoutes, String[] quotes ){
		List<String> ans  =  new ArrayList<String>();
		
		List<String[]> str = new ArrayList<>();
		
		for(int i=0;i<numQoutes;i++){
			str.add(quotes[i].trim().toLowerCase().replaceAll("[\\!?,;.]", "").split(" "));
		}
		
		Map<String,Object[]> records = new HashMap<String, Object[]>();
		
		for(int i=0;i<numToys;i++){
			records.put(toys[i].toLowerCase(), new Object[]{0,new HashSet<Integer>(),toys[i]});
		}
		
		
		for(int i=0;i<numQoutes;i++){
			String[] qu = str.get(i);
			for(int j=0;j<qu.length;j++){
				String in = qu[j];
				if(records.containsKey(in)){
					Object[] values = records.get(in);
					values[0] = (int) (values[0]) + 1;
					Set<Integer> set = ((HashSet)values[1]);
					set.add(i);
				}
			}
		}
		
		Collection<Object[]>values = records.values();
		PriorityQueue<Object[]> queue = new PriorityQueue<>((t1,t2)->{
			int diff = ((int)t2[0]) - ((int)t1[0]);
			if(diff==0){
				diff = ((HashSet)t2[1]).size() - ((HashSet)t1[1]).size();
				if(diff==0){
					return ((String)t2[2]).toLowerCase().compareTo(((String)t1[2]).toLowerCase());
				}
				return diff;
			}
			return diff;
		});
		
		for(Object[] value :values){
			queue.add(value);
		}
		
		for(int i=0;i<topToys&&!queue.isEmpty();i++){
			ans.add((String)queue.poll()[2]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
		String[] toys = {
				"Elmo", "ElSa", "legos", "drone", "tablet", "warcraft"
		};
		String[] quotes = {
				"Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
				"The new Elmo dolls are super high quality",
				"Expect the Elsa dolls to be very popular this year, Elsa!",
				"Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
				"For parents of older kids, look into buying them a drone",
				"Warcraft is slowly rising in popularity ahead of the holiday season"
		};
		List<String> ans  = top(toys.length,2,toys,quotes.length,quotes);
		
		for(String str : ans){
			System.out.println(str);
		}
		
	}
}
