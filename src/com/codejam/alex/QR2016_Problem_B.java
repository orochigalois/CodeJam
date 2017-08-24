package com.codejam.alex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QR2016_Problem_B {

	private static final String INPUT = "D:\\B-large-practice.in";
	private static final String OUTPUT = "D:\\B-large-practice.out";

	public static void main(String[] args) throws IOException {

		try {

			int inStack_count = 0;
			boolean having_In_Top = false;
			
			int result=0;

			File f = new File(INPUT);
			BufferedReader b = new BufferedReader(new FileReader(f));

			String str_T = b.readLine();
			int T = Integer.parseInt(str_T);

			for (int i = 0; i < T; i++) {
				String pancake = "";
				if ((pancake = b.readLine()) != null) {
					if (pancake.length() == 1) {
						char c = pancake.charAt(0);
						if(c=='-')
							result=1;
						else
							result=0;

					} else {
						inStack_count=0;
						having_In_Top=false;
						for (int j = 1; j < pancake.length(); j++) {
							char c = pancake.charAt(j);
							char last_c = pancake.charAt(j - 1);

							if (last_c == '-' && j == 1) {
								having_In_Top = true;
							}

							if (c == '-') {
								if (last_c == '-') {

								} else {
									inStack_count++;
								}
							}

						}
						result = inStack_count * 2 + (having_In_Top ? 1 : 0);
					}

					write2output(i, result);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void write2output(int i, int result) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT, true))) {
			String content = "Case #" + Integer.toString(i + 1) + ": " + Integer.toString(result) + "\n";

			bw.write(content);

			System.out.println(content);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
	

}
