package class7DFS;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author guoyifeng
 *	Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.

	Arguments
	
	coins - an array of positive integers representing the different denominations of coins, 
	there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
	target - a non-negative integer representing the target number of cents, eg. 99
	Assumptions
	
	coins is not null and is not empty, all the numbers in coins are positive
	target >= 0
	You have infinite number of coins for each of the denominations, you can pick any number of the coins.
	Return
	
	a list of ways of combinations of coins to sum up to be target.
	each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.
	Examples
	
	coins = {2, 1}, target = 4, the return should be
	
	[
	
	  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
	
	  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
	
	  [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
	
	]
 */
public class CombinationsOfCoins {
	/*
	 * each layer of recursion tree represents one type of coin with its all possible frequency 
	 */
	public List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> plan = new ArrayList<>();
		helper(target,coins,0,plan,result);
		return result;
	}
	
	private void helper(int target, int[] coins, int level, List<Integer> plan, List<List<Integer>> result) {
		if(level == coins.length - 1) {// base case: if level reaches the last layer of recursion tree
			if(target % coins[coins.length - 1] == 0) { // if the current combination can match the target
				plan.add(target / coins[coins.length - 1]);
				result.add(new ArrayList<Integer>(plan));//a copy of current
				plan.remove(plan.size() - 1); // delete last element to make next backtracking have original condition
			}
			return;
		}
		int potentialNum = target / coins[level]; // count the max number of current coin type at this layer
		for(int i = 0; i <= potentialNum; i++) {
			plan.add(i);
			helper(target - coins[level] * i, coins, level + 1, plan, result);//DFS
			plan.remove(plan.size() - 1);//retrieve last state and continue to next iteration
		}
	}
}
