public class QuickSort implements SortAlgorithm {
	public double[] data;
	public void sort(double[] array, SortTimer t) {
		// 1.  call recursive quicksort procedure with left = 0 and right = n-1
		quickSort(array, 0, array.length-1, t);
		
	}

	public void quickSort(double[] array, int left, int right, SortTimer t){
		// 1. if left < right then
		t.addComparison();
		if (left < right){
			// 1.1 select pivot element in the range left to right
			double pivot = array[(left + right) / 2];
			// 1.2 partition list in place so that all elements <= pivot precede those that are > pivot
			// 1.3 let index be the position of the pivot element after partitioning
			int index = partition(array, left, right, pivot, t);
			// 1.4 recursively quicksort elements left to pos-1
			quickSort(array, left,  index-1, t);
			// 1.5 recursively quicksort elements pos+1 to right
			quickSort(array, index, right,   t);
		}
	}
	
	public int partition(double[] array, int left, int right, double pivot, SortTimer t){
		t.addComparison();
		while ( left <= right) {
			t.addComparison();
			while (array[left] < pivot){
				left++;
				t.addComparison();
			}
			
			t.addComparison();
			while (array[right] > pivot) {
				right--;
				t.addComparison();
			}
			
			t.addComparison();
			if (left <= right) {
				// Swap
				t.addMoves(3);
				double temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
	
}
