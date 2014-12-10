package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

public class StackClient {

	static void processFile(BufferedReader reader) {
		Stack<String> stack = new Stack<String>();
		String line = null;
		int n = 0;
		int added = 0;
		int taken = 0;
		Date d1 = new Date();
		try {
			while ((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					n++;
					Random rand = new Random();
					int intRand;
					if (n < 100) {
						stack.push(st.nextToken());
						added++;
					}

					else {
						intRand = rand.nextInt(2);
						if (intRand == 1) {
							stack.push(st.nextToken());
							added++;
						}

						else {
							stack.pop();
							taken++;
						}
					}
				}
			}
			Date d2 = new Date();
			System.out.println("Total words " + n);
			System.out.println("Total added " + added);
			System.out.println("Total taken " + taken);
			long time = d2.getTime() - d1.getTime();
			System.out.println("Time of processing (ms) " + time);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

	public static void main(String[] args) {

		try {
			File file = new File("1\\tolstoy.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "UTF-8"));
			processFile(reader);

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
