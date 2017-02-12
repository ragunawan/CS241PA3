public class InsertionSort implements SortAlgorithm {
	public void sort(double[] array, SortTimer t) {
		// 1. for i = 1 to n-1
		for (int i = 0; i < array.length; i++) {
			double current = array[i];
			int element = i;
			// 1.1. compare the current value with elements i-1 down to 0
			while (element > 0 && array[element - 1] > current) {
				t.addComparison();
				// 1.2. shift each element that is greater than the current
				// value one position to the right
				array[element] = array[element - 1];
				element--;
				t.addMove();
			}
			// 1.3. insert current value into its correct position relative to
			// other elements in range
			array[element] = current;
			t.addMove();
		}
	}
}