package class14ProbabilityAndSamplingAndRandomization;

/**
 * 
 * @author guoyifeng
 * Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. 
 * Use random5() to implement random7().


 */
public class Random7UsingRandom5 {
	/*
	 * basic idea: dimension raising: use random 25 to implement random 7 
	 * 			   and random 25 can be computed by random 5
	 */
  public int random7() {
    // write your solution here
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    int num = random25();
    while(num > 20) { //only keep 0-20 these 21 numbers, and get module of 7, e.g if 0,7,14 in 21, this is same as roll a 0 in 7
      num = random25();
    }
    return num % 7;
  }
  
  private int random25() {
    return 5 * RandomFive.random5() + RandomFive.random5(); // construct random(25)
  }
  
  /*
   * solution 2
   */
//  public int random7() {
//		while (true) { // impossible dead loop for chance is less and less with no
//		               // return (4/25) ^ n for n times no return
//		  //generate a random number [0,24]
//		  int num = 5 * RandomFive.random5() + RandomFive.random5(); 
//			if (num < 21) {
//				return num % 7;// return 0-6 with same probablity
//    }		
//		}
//	}
  
}
