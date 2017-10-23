package advanced_class7_DP4;

import java.math.BigDecimal;

public class TestBigDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal a = new BigDecimal(94911150);
		BigDecimal b = new BigDecimal(94911151);
		BigDecimal k = a.divide(b, 10, BigDecimal.ROUND_HALF_UP);
		System.out.println(k);
	}

}
