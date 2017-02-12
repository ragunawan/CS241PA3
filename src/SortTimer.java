public class SortTimer {
	long comparisons, moves, time;

	void reset(){
		comparisons = 0;
		moves = 0;
		time = System.nanoTime();
	}
	void addComparison(){
		comparisons++;
	}
	void addComparisons(int n){
		comparisons += n;
	}
	void addMove(){
		moves += 1;
	}
	void addMoves(int n){
		moves += n;
	}
	long getComparisons(){
		return comparisons;
	}
	long getMoves(){
		return moves;
	}
	long getElapsedTime(){
		return (System.nanoTime() - time)/1000;
	}

}