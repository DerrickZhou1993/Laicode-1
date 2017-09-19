package TAclass8_DP;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 
 * @author guoyifeng
 	There are several wood boards and each board height is 1. How to get largest height by
	    piling these wood boards and guarantee each wood's width and length are both shorter than
	    whose which is under it.
 */

/*
 * basic idea:
 * 		this is follow up of LIS
 * 		sort the wood boards by width(or length both ok)
	    in ascending and if woods with same width, we put ones 
	    with longer length in front of ones with shorter length
	    and then we run LIS on length of each wood board
	                 
	            (1,3) (1,1) (2,5) (2,4) (3,6)    ->  (1 3)  (2 5)  (3 6)   = 3
	            
	     time = O(n ^ 2)
	     space = O(n)
 */
public class LIS3WoodBoardPile {
	static class Board {
		private int l; // length of wood board
		private int w; // width of wood board

		public Board(int l, int w) {
			this.l = l;
			this.w = w;
		}
	}

	public int maxHeight(Board[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		Arrays.sort(arr, new Comparator<Board>() {
			@Override
			public int compare(Board b1, Board b2) {
				if (b1.w == b2.w && b1.l == b2.l) {
					return 0;
				}
				if (b1.w < b2.w) {
					return -1;
				} else if (b1.w == b2.w && b1.l > b2.l) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		int globalMax = 1;
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i].l > arr[j].l) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			globalMax = Math.max(dp[i], globalMax);
		}
		return globalMax;
	}
	
	public static void main(String[] args) {
		Board b1 = new Board(2,5);
		Board b2 = new Board(1,3);
		Board b3 = new Board(1,1);
		Board b4 = new Board(2,4);
		Board b5 = new Board(3,6);
		Board b6 = new Board(7,4);
		Board b7 = new Board(4,8);
		Board[] arr = new Board[]{b1,b2,b3,b4,b5,b6,b7};
		int max = new LIS3WoodBoardPile().maxHeight(arr);
		System.out.println(max);
	}
}
