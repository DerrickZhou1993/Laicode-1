package advanced_class7_DP4;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BinomialBigInteger {
	static BigInteger binomial(final int N, final int K) {
		BigInteger ret = BigInteger.ONE;
		for (int k = 0; k < K; k++) {
			ret = ret.multiply(BigInteger.valueOf(N - k)).divide(BigInteger.valueOf(k + 1));
		}
		return ret;
	}
	
	static int getThreshold_GuessB(int flip) {
		double factor1 = 4.0 / 7.0;
		double factor2 = 2;
		for (int i = 0; i < flip; i++) {
			if (Math.pow(factor1, i) * Math.pow(factor2, flip - i) < 1.0) {
				return i;
			}
		}
		return -1;
	}
	
	static BigDecimal getPGuessBCoinA(int flip) {
		BigDecimal P_gB_cA = null;
		BigDecimal res = BigDecimal.ZERO;
		BigDecimal max = BigDecimal.ZERO;
		int headsnMax = 0;
		int threshold = getThreshold_GuessB(flip);
		for (int i = threshold; i <= flip; i++) {
			BigInteger temp = binomial(flip, i);
			P_gB_cA = new BigDecimal(temp);
			P_gB_cA = P_gB_cA.multiply(new BigDecimal(Math.pow(0.4, i))); // head
			P_gB_cA = P_gB_cA.multiply(new BigDecimal(Math.pow(0.6, flip - i))); // tail
			if (P_gB_cA.compareTo(max) > 0) {
				headsnMax = i;
				max = P_gB_cA;
			}
			// System.out.println("headsn: " + i + " P_gB_cA: " + P_gB_cA +" max: "+ max +" max_headsn "+ headsnMax);
			res = res.add(P_gB_cA);
		}
		return res;
	}
	
	static BigDecimal getPGuessACoinB(int flip) {
		BigDecimal P_gA_cB = null;
		BigDecimal res = BigDecimal.ZERO;
		BigDecimal max = BigDecimal.ZERO;
		int headsnMax = 0;
		int threshold = getThreshold_GuessB(flip);
		for (int i = 0; i <= threshold - 1; i++) {
			BigInteger temp = binomial(flip, i);
			P_gA_cB = new BigDecimal(temp);
			P_gA_cB = P_gA_cB.multiply(new BigDecimal(Math.pow(0.7, i))); // head
			P_gA_cB = P_gA_cB.multiply(new BigDecimal(Math.pow(0.3, flip - i))); // tail
			if (P_gA_cB.compareTo(max) > 0) {
				headsnMax = i;
				max = P_gA_cB;
			}
			// System.out.println("headsn: " + i + " P_gA_cB: " + P_gA_cB + " max: " + max + " max_headsn "+ headsnMax);
			res = res.add(P_gA_cB);
		}
		return res;
	}
	public static void main(String[] args) {
		int flip = 1000;
		int res = 0;
//		getPGuessACoinB(17); test for Q8
//		getPGuessBCoinA(17); 
		 System.out.println(getThreshold_GuessB(17));  // test for Q6
		 System.out.println(getPGuessBCoinA(17));
		 System.out.println(getPGuessACoinB(17));
		for (int i = 0; i < flip; i++) { // find smallest flip which satisfies  P (Guessn != Coin) ≤ 0.1
			BigDecimal P_gB_cA = getPGuessBCoinA(i);
			BigDecimal P_gA_cB = getPGuessACoinB(i);
			// System.out.println(getThreshold_GuessB(i));
			// System.out.println("failed this time");
			if (P_gB_cA.add(P_gA_cB).doubleValue() * 0.5 <= 0.1) {
				res = i;
				System.out.println(i);
				return;
			}
		}
	}
}
