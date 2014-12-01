package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

public class DequeClient {

	static void processFile(BufferedReader reader) {
		Date d1 = new Date();
		Deque<String> deque = new Deque<String>();
		String line = null;
		int n = 0;
		int added = 0;
		int taken = 0;
		try {
			while ((line = reader.readLine()) != null) {

				StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {

					n++;
					Random rand = new Random();
					int intRand;
					if (n < 100) {
						deque.pushLast(st.nextToken());
						added++;
					}

					else {
						intRand = rand.nextInt(4);
						if (intRand == 0) {
							deque.pushLast(st.nextToken());
							added++;
						} else if (intRand == 1) {
							deque.pushFirst(st.nextToken());
							added++;
						} else if (intRand == 2) {
							deque.popFirst();
							taken++;
						} else if (intRand == 3) {
							deque.popFirst();
							taken++;
						}
					}
				}

				/*
				 * boolean isEmptyWord = true; StringBuilder str = new
				 * StringBuilder(); char ch; for (int i = 0; i < line.length();
				 * i++) { ch = line.charAt(i); if (Character.isLetter(ch)) {
				 * str.append(ch); isEmptyWord = false; } if
				 * ((!Character.isLetter(ch)) || (i == line.length() - 1)) { if
				 * (!isEmptyWord) { //System.out.println(str); str = new
				 * StringBuilder(); isEmptyWord = true; n++; Random rand = new
				 * Random(); int intRand; if (n < 100) { deque.pushLast(str);
				 * added++; }
				 * 
				 * else { intRand = rand.nextInt(4); if (intRand == 0) {
				 * deque.pushLast(str); added++; } else if (intRand == 1) {
				 * deque.pushFirst(str); added++; } else if (intRand == 2) {
				 * deque.popFirst(); taken++; } else if (intRand == 3) {
				 * deque.popFirst(); taken++; } } } } }
				 */
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
					new FileInputStream(file), "Windows-1251"));
			processFile(reader);

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
