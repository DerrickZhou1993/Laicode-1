package class14ProbabilityAndSamplingAndRandomization;

/**
 * 
 * @author guoyifeng
 * Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. 
 * Use random5() to implement random1000()
 */
public class Random1000UsingRandom5 {
	  public int random1000() {
	    // you can use RandomFive.random5() for generating
	    // 0 - 4 with equal probability.
	    
	    //5 ^ 4 = 625
	    //5 ^ 5 = 3125
	    int num = 0;
	    for(int i = 0; i < 5; i++) {
	      num = 5 * num + RandomFive.random5();
	    }
	    if(num < 1000) {
	      return num % 1000;
	    }
	    return 0;
	  }
	}
