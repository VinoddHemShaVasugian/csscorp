package javasolutions;
public class FinallySystemExit {

	public static void main(String[] args) {
		try {
			int a[] = new int[2];
			System.out.println("Access element three :" + a[3]);
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException n) {
			System.out.println("ArrayIndexOutOfBoundsException catch block");
		} finally {
			System.exit(1);
			System.out.println("Finally block");
		}

	}

}
