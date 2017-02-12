public class HeapSort implements SortAlgorithm {
	private int N;
	public void sort(double[] array, SortTimer t) {
		// 1. convert list into max heap
        heapify(array, t);
        
        // 2. for i = n-1 down to 1
        for (int i = N; i > 0; i--){
        	// 2.1 exchange maximum element (at pos 0) with element at pos i
            swap(array,0, i, t);
            // 2.2 decrement heap size
            N = N-1;
            // 2.3 use sift-down to restore heap property
            maxheap(array, 0, t);
        }		
	}
	
	public void heapify(double[] array, SortTimer t){
        N = array.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(array, i, t);        
	}
      
    public void maxheap(double[] array, int i, SortTimer t){ 
        int left  = 2 * i;
        int right = 2 * i + 1;
        int max   = i;
        
        t.addComparison();
        if (left <= N && array[left] > array[i])
            max = left;
        t.addComparison();
        if (right <= N && array[right] > array[max])        
            max = right;
        t.addComparison();
        if (max != i){
            swap(array, i, max, t);
            maxheap(array, max, t);
        }
    }  

    public static void swap(double[] array, int i, int j, SortTimer t){
    	t.addMoves(3);
        double tmp = array[i];
        array[i] = array[j];
        array[j] = tmp; 
    }  

}
