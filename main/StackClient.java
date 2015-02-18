package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class StackClient {

	static Stack<String> stack = new Stack<String>();
	BufferedReader reader;

	public StackClient(BufferedReader reader) {
		this.reader = reader;
	}

	void processFile() {

		String line = null;
		int n = 0;
		int added = 0;
		int taken = 0;
		Date d1 = new Date();
		try {
			while ((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					stack.push(st.nextToken());
					n++;
				}
			}
			Date d2 = new Date();
			long time = d2.getTime() - d1.getTime();
			// System.out.println("Time of processing (ms) " + time);

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

	public static void main(String[] args) {

		try {
			File file = new File("1\\tolstoy.txt");
			for (int j = 0; j < 10; j++) {
				System.out.println(j + " CHAPTER-----------------------------------");
				for (int i = 0; i < 20; i++) {
					new StackClient(new BufferedReader(new InputStreamReader(
							new FileInputStream(file), "UTF-8"))).processFile();
					System.out.println(i + " - iteration. Now our size is "
							+ stack.size() / 1000 + "k");
					TimeUnit.SECONDS.sleep(1);

				}
				TimeUnit.SECONDS.sleep(5);
				int n = stack.size();
				int t = 0;
				System.out.println("Now pop()");
				for (int i = 0; i < n; i++) {

					stack.pop();
					if (++t == 2000000) {
						System.out.println("Now our size is " + stack.size()
								/ 1000 + "k");
						t = 0;
						TimeUnit.SECONDS.sleep(1);
					}

				}
				System.out.println("Now our size is " + stack.size());
				TimeUnit.SECONDS.sleep(5);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
