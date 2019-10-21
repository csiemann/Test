import java.util.Random;
import java.util.Scanner;


public class AnsiTest {
	static String s = "                                                                                                                                              ";
	static int a = s.length();

	public static void main(String[] args) {
		for (byte i = 0; i < 8; i++) {
			System.out.print(" \033[" + "1;" + (30 + i) + "mteste" + "\033[0m ");
		}
		System.out.println();
		for (byte i = 0; i < 8; i++) {
			for (byte j = 0; j < 8; j++) {
				System.out.print(" \033[" + (30 + i) + ";1;" + (j + 40) + "mteste" + "\033[0m ");
			}
			System.out.println();
		}
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		Scanner scanner = new Scanner(System.in);
		System.out.println("0 - RGB");
		System.out.println("1 - Random");
		System.out.println("2 - Binary");
		byte x = scanner.nextByte();
		scanner.close();
		if (x == 0)
			startRainbow();
		else if (x == 1)
			startRandom();
		else if (x == 2)
			startBinary();
		else if (x == 2)
			startEverything();
		else
			startRandomASCII();
	}

	private static void startEverything() {
		String s = "                                                ";
		Random random = new Random();
		short divide = 1;
		short maxColor = (short) (255 / divide);
		short min = 0;
		divide = 1;
		short r = maxColor;
		short g = min;
		short b = min;
		int[] colors = new int[] { 0, 255 };
		while (true) {
			for (int i = 0; i < a / 3; i++) {
				System.out.print("\033[48;2;" + random.nextInt(255) + ";" + random.nextInt(255) + ";"
						+ random.nextInt(255) + "m \033[0m");
			}

			for (int i = 0; i < a / 3; i++) {
				int x = random.nextInt(colors.length);
				System.out.print("\033[48;2;" + colors[x] + ";" + colors[x] + ";" + colors[x] + "m \033[0m");
			}

			if (r == maxColor && g != maxColor && b == min) {
				g++;
			} else if (r != min && g == maxColor && b == min) {
				r--;
			} else if (r == min && g == maxColor && b != maxColor) {
				b++;
			} else if (r == min && g != min && b == maxColor) {
				g--;
			} else if (r != maxColor && g == min && b == maxColor) {
				r++;
			} else if (r == maxColor && g == min && b != min) {
				b--;
			}

			System.out.print("\033[48;2;" + r * divide + ";" + g * divide + ";" + b * divide + "m" + s + "\033[0m\n");
			Utils.pause(50);
		}
	}

	private static void startRandom() {
		Random random = new Random();
		while (true) {
			for (int i = 0; i < a; i++) {
				System.out.print("\033[48;2;" + random.nextInt(255) + ";" + random.nextInt(255) + ";"
						+ random.nextInt(255) + "m \033[0m");
			}
			System.out.println();
			Utils.pause(50);
		}
	}

	private static void startBinary() {
		Random random = new Random();
		int[] colors = new int[] { 0, 255 };
		while (true) {
			for (int i = 0; i < a; i++) {
				int x = random.nextInt(colors.length);
				System.out.print("\033[48;2;" + colors[x] + ";" + colors[x] + ";" + colors[x] + "m \033[0m");
			}
			System.out.println();
			Utils.pause(50);
		}
	}

	private static void startRainbow() {
		short divide = 1;
		short maxColor = (short) (255 / divide);
		short min = 0;
		divide = 1;
		short r = maxColor;
		short g = min;
		short b = min;
		while (true) {
			if (r == maxColor && g != maxColor && b == min) {
				g++;
			} else if (r != min && g == maxColor && b == min) {
				r--;
			} else if (r == min && g == maxColor && b != maxColor) {
				b++;
			} else if (r == min && g != min && b == maxColor) {
				g--;
			} else if (r != maxColor && g == min && b == maxColor) {
				r++;
			} else if (r == maxColor && g == min && b != min) {
				b--;
			}
			System.out.print("\033[48;2;" + r * divide + ";" + g * divide + ";" + b * divide + "m" + s + "\033[0m\n");
			Utils.pause(50);
		}
	}

	private static void startRandomASCII() {
		Random random = new Random();
		while (true) {
			for (int j = 0; j < 40; j++) {
				for (int i = 0; i < a; i++) {
					char d = (char) (random.nextInt(86) + 32);
					System.out.print("\033[48;2;" + random.nextInt(255) + ";" + random.nextInt(255) + ";"
							+ random.nextInt(255) + "m" + d + "\033[0m");
					Utils.pause(5);
				}
				System.out.println();
			}
			System.out.print("\033[H\033[2J");
			System.out.flush();
			Utils.pause(50);
		}
	}

}
