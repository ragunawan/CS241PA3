import java.util.Random;

public class Driver {
	public static void main(String[] args) {
		//test array to verify sorting algorithms operations
//		double[] inputArray = new double[] {45, 32, 12, 19, 40, 9, 56, 23, 3, 22, 18, 48, 49, 33, 11, 7};
		String algorithm = args[0];
		SortAlgorithm sorter;
		SortTimer timer = new SortTimer();
		Random r = new Random();
		double avgTime = 0, avgMove = 0, avgComp = 0;
		int k;											// maximum array size n = 10^k
		
//		algorithm = "i";
		switch(algorithm) {
			case "i":
				algorithm = "Insertion Sort";
				k = 5;
				sorter = new InsertionSort();
				break;
			case "h":
				algorithm = "Heap Sort";
				k = 6;
				sorter = new HeapSort();
				break;
			case "m":
				algorithm = "Merge Sort";
				k = 6;
				sorter = new MergeSort();
				break;
			case "q":
				algorithm = "Quick Sort";
				k = 6;
				sorter = new QuickSort();
				break;
			default : 
				algorithm = null;
				k = 0;
				sorter = null;
				break;
		}		
		System.out.println("Algorithm: " + algorithm);
/*		// Used to check the sorting algorithms validity
		for(int i = 0; i < inputArray.length; i++){
			System.out.println(inputArray[i]);
		}
		System.out.println("------ sorting");
		timer.reset();
		sorter.sort(inputArray, timer);
		System.out.println("time: " + timer.getElapsedTime());
		System.out.println("check: " + verify(inputArray));
		for(int i = 0; i < inputArray.length; i++){
			System.out.println(inputArray[i]);
		}
*/		
		System.out.printf("%15s%15s%15s%15s%n", "n", "time(micro)", "comps", "moves");
		// Step 4: Run the code random arrays size up to n = 10^k. Average five instances of each size. 
		for(int aSize = 1; aSize <= k; aSize++){
			avgTime = 0;
			avgMove = 0;
			avgComp = 0;
			double[] array =  new double[(int) Math.pow(10, aSize)];

			for (int iter = 1; iter <= 5; iter++){
				for (int create = 0; create < array.length; create++){
					array[create] = r.nextDouble();
				}
				timer.reset();
				sorter.sort(array, timer);
				avgTime += timer.getElapsedTime();
				avgMove += timer.getMoves();
				avgComp += timer.getComparisons();
				
				// Verify that the array is sorted
				 if (!verify(array)) {
					System.out.println("***Sort Error***");
				 }
			}
			avgTime = avgTime / 5;
			avgMove = avgMove / 5;
			avgComp = avgComp / 5;
			
			System.out.printf("%15d%15.0f%15.0f%15.0f %n", array.length, avgTime, avgComp, avgMove);
		}	
	}
	
	public static boolean verify(double[] array){
		for (int i = 0; i < array.length-1; i++){
			if(array[i+1] < array[i])
				return false;
		}
		return true;
	}
}
