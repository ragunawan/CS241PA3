public class MergeSort implements SortAlgorithm {
	public void sort(double[] array, SortTimer t){
		// 1. call recursive mergesort procedure with left=0 and right=n-1
		mergeSort(array, 0, array.length-1, t);
	}
	
	public void mergeSort(double[] array, int left, int right, SortTimer t){
		t.addComparison();
        if (left < right) {
        	// 1.1 set mid to the middle idex in range left to right
            int middle = left + (right - left) / 2;
            // 1.2 recursively mergesort elements left..mid
            mergeSort(array, left, middle, t);
            // 1.3 recursively mergesort elements mid+1 to right
            mergeSort(array, middle + 1, right, t);
            // 1.4 merge the two sorted lists and return the result
            merge(array, left, middle, right, t);
        }
	}
	
	public void merge(double[] array, int left, int middle, int right, SortTimer t){
		double[] tempMergeArray = new double[array.length];
		
        for (int i = left; i <= right; i++) {
        	t.addMove();
            tempMergeArray[i] = array[i];
        }
        
        int i = left;
        int j = middle + 1;
        int k = left;
        
        t.addComparison();
        while (i <= middle && j <= right) {
        	t.addComparison();
            if (tempMergeArray[i] <= tempMergeArray[j]) {
            	t.addMove();
                array[k] = tempMergeArray[i];
                i++;
            } else {
            	t.addMove();
                array[k] = tempMergeArray[j];
                j++;
            }
            k++;
            t.addComparison();
        }
    	t.addComparison();
        while (i <= middle) {
        	t.addMove();
            array[k] = tempMergeArray[i];
            k++;
            i++;
        	t.addComparison();
        }
	}
}
