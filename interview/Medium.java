package interview;

public class Medium {
	
	public static void main(String[] args) {
		Medium m = new Medium();
//		m.inPlaceSwap(1, 2);
		
		int[][] grid = {
			{ 0, 1, 0 },
			{ 1, 0, 1 },
			{ 1, 0, 0 }
		};
		System.out.println(m.naiveTicTacToe(grid));
	}
	
	public Medium() {
		
	}
	
	int naiveTicTacToe(int[][] grid) {
		// Either it's a row, column, or one of the two diagonals
	}
	
	void inPlaceSwap(int a, int b) {
		System.out.println(a + "   " + b);
		if(a > b) {
			a = a - b;
			b = a + b;
			a = b - a;
		} else if (a < b) {
			b = b - a;
			a = b + a;
			b = a - b;
		}
		System.out.println(a + "   " + b);
	}
}
