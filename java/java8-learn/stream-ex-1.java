package JavaLearn.javaInAction;

import java.util.Arrays;
import java.util.List;

/**
 * The Class Driver.
 */
public class Driver {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		transactions.forEach(t -> System.out.println(t));
		System.out.println("-----------------------******************************---------------------");
		System.out.println("1. Find all transactions in the year 2011 and sort them by value (small to high).");

		// ans:
		// transactions.parllelStream().filter(t->t.year==2011).sorted((t1,t2)->t1.value-t2.value).forEach(t->System.out.println(t));
		// this will be wrong

		transactions.stream().filter(t -> t.year == 2011).sorted((t1, t2) -> t1.value - t2.value)
				.forEach(t -> System.out.println(t));

		System.out.println("2. What are all the unique cities where the traders work?");

		transactions.parallelStream().map(t -> t.trader.city).distinct().forEach(t -> System.out.println(t));

		System.out.println("3. Find all traders from Cambridge and sort them by name.");
		// ans :
		// transactions.parllelStream().map(t->t.trader.name).sorted((t1,t2)->t1.compareTo(t2)).forEach(t->System.out.println(t));
		// this will be wrong

		transactions.stream().filter(t -> t.trader.city.equals("Cambridge")).map(t -> t.trader.name)
				.sorted((t1, t2) -> t1.compareTo(t2)).forEach(t -> System.out.println(t));

		System.out.println("4. Return a string of all traders’ names sorted alphabetically.");
		transactions.stream().map(t -> t.trader.name).sorted((t1, t2) -> t1.compareTo(t2))
				.forEach(t -> System.out.println(t));

		System.out.println("5. Are any traders based in Milan?");
		long count = transactions.parallelStream().filter(t -> t.trader.city.equalsIgnoreCase("milan")).count();
		System.out.println(count > 0);

		System.out.println("6. Print all transactions’ values from the traders living in Cambridge.");
		transactions.parallelStream().filter(t -> t.trader.city.equalsIgnoreCase("cambridge")).map(t -> t.value)
				.forEach(t -> System.out.println(t));

		System.out.println("7. What’s the highest value of all the transactions?");
		int ans = transactions.parallelStream().map(t -> t.value).reduce(Integer::max).get();
		System.out.println(ans);

		System.out.println("8. Find the transaction with the smallest value.");
		ans = transactions.parallelStream().map(t -> t.value).reduce(Integer::min).get();
		System.out.println(ans);

	}
}

