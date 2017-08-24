package com.codejam.alex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QR2016_Problem_A {

	private static final String INPUT = "D:\\A-large-practice.in";
	private static final String OUTPUT = "D:\\A-large-practice.out";

	static boolean ZERO = false;
	static boolean ONE = false;
	static boolean TWO = false;
	static boolean THREE = false;
	static boolean FOUR = false;
	static boolean FIVE = false;
	static boolean SIX = false;
	static boolean SEVEN = false;
	static boolean EIGHT = false;
	static boolean NINE = false;

	public static void main(String[] args) throws IOException {

		try {

			int result = 0;

			File f = new File(INPUT);
			BufferedReader b = new BufferedReader(new FileReader(f));

			String str_T = b.readLine();
			int T = Integer.parseInt(str_T);

			for (int i = 0; i < T; i++) {

				String str_sheep = "";
				if ((str_sheep = b.readLine()) != null) {
					int sheep = Integer.parseInt(str_sheep);

					if (sheep == 0)
						write2output(0, 0, true);
					else {

						int count = 1;
						int number = 0;
						clearVector();
						boolean keepgoing = true;
						while (keepgoing) {
							number = sheep * (count++);
							handle(number);
							if (halt())
								keepgoing = false;
						}

						write2output(i, number, false);
					}

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void clearVector() {
		ZERO = false;
		ONE = false;
		TWO = false;
		THREE = false;
		FOUR = false;
		FIVE = false;
		SIX = false;
		SEVEN = false;
		EIGHT = false;
		NINE = false;
	}

	public static boolean halt() {
		return ZERO && ONE && TWO && THREE && FOUR && FIVE && SIX && SEVEN && EIGHT && NINE;
	}

	public static void handle(int number) {
		while (number > 0) {
			int digit = number % 10;
			switch (digit) {
			case 0:
				ZERO = true;
				break;
			case 1:
				ONE = true;
				break;
			case 2:
				TWO = true;
				break;
			case 3:
				THREE = true;
				break;
			case 4:
				FOUR = true;
				break;
			case 5:
				FIVE = true;
				break;
			case 6:
				SIX = true;
				break;
			case 7:
				SEVEN = true;
				break;
			case 8:
				EIGHT = true;
				break;
			case 9:
				NINE = true;
				break;
			default:
				break;

			}
			number = number / 10;
		}
	}

	public static void write2output(int i, int result, boolean INSOMNIA) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT, true))) {
			String content;
			if (INSOMNIA)
				content = "Case #" + Integer.toString(i + 1) + ": " + "INSOMNIA\n";
			else
				content = "Case #" + Integer.toString(i + 1) + ": " + Integer.toString(result) + "\n";

			bw.write(content);

			System.out.println(content);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}
