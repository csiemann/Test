

import java.util.Scanner;

public class DivididoPor {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i <= x; i++) {
			if (x%i==0) {
				builder.append(i+" ");
			}
		}
		s.close();
		System.out.println(builder.toString());
	}

}
