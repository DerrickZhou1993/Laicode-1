package class14ProbabilityAndSamplingAndRandomization;

public class Shuffle {
	public void shuffle(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		for(int i = array.length - 1; i >= 0; i--) {
			int index = (int) (Math.random() * i);
			swap(array,index,i);
		}
	}
	
	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
