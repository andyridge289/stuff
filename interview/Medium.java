package interview;

public class Medium {
	
	public static void main(String[] args) {
		Medium m = new Medium();
		m.inPlaceSwap(1, 2);
	}
	
	public Medium() {
		
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
