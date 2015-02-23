package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class DequeClient extends Thread {

	BufferedReader reader;
	
	public DequeClient(BufferedReader reader) {
		this.reader = reader;
	}
	
	public void run() {
		for (int i = 0; i < 10000; i++) {
			doSmth();
		}
	}
	
	public void doSmth() {
		Deque<String> deque = new Deque<String>();
		String line = null;
		int n = 0;
		try {
			while ((line = reader.readLine()) != null) {

				StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {

					n++;
					Random rand = new Random();
					int intRand;
					if (n < 100) {
						deque.pushLast(st.nextToken());
					}

					else {
						intRand = rand.nextInt(4);
						if (intRand == 0) {
							deque.pushLast(st.nextToken());
						} else if (intRand == 1) {
							deque.pushFirst(st.nextToken());
						} else if (intRand == 2) {
							deque.popFirst();
						} else if (intRand == 3) {
							deque.popFirst();
						}
					}
				}

			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

	public static void main(String[] args) {

		try {
			File file = new File("1\\tolstoy.txt");
			for (int i = 0; i < 10000; i++) {
				new DequeClient (new BufferedReader(new InputStreamReader(
						new FileInputStream(file), "UTF-8"))).doSmth();
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
