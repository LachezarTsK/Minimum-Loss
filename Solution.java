import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IVStreamlinedSolution {

	/**
	 * Applying HashMap so that each year can be accessed through the price with
	 * O(1) time.
	 */
	private static Map<Long, Integer> pricesPerYears = new HashMap<Long, Integer>();

	public static long minimumLoss(long[] price) {
		long minLoss = (long) (Math.pow(10, 16) - 2);
		Arrays.sort(price);

		for (int i = 0; i < price.length - 1; i++) {
			if (pricesPerYears.get(price[i]) > pricesPerYears.get(price[i + 1])) {
				long loss = price[i + 1] - price[i];
				minLoss = Math.min(minLoss, loss);
			}
		}
		return minLoss;
	}

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int numberOfYears = reader.nextInt();
		long[] prices = new long[numberOfYears];

		for (int i = 0; i < numberOfYears; i++) {
			prices[i] = reader.nextLong();
			pricesPerYears.put(prices[i], i);
		}
		reader.close();

		long result = minimumLoss(prices);
		System.out.println(result);
	}
}
