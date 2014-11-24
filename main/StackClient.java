package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Random;

public class StackClient {

    static void processFile(BufferedReader reader) {
        Stack<StringBuilder> stack = new Stack<StringBuilder>();
        String line = null;
        int n = 0;
        int added = 0;
        int taken = 0;
        Date d1 = new Date();
        try {
            while ((line = reader.readLine()) != null) {
                boolean isEmptyWord = true;
                StringBuilder str = new StringBuilder();
                char ch;
                for (int i = 0; i < line.length(); i++) {
                    ch = line.charAt(i);
                    if (Character.isLetter(ch)) {
                        str.append(ch);
                        isEmptyWord = false;
                    }
                    if ((!Character.isLetter(ch)) || (i == line.length() - 1)) {
                        if (!isEmptyWord) {
                            //System.out.println(str);
                            str = new StringBuilder();
                            isEmptyWord = true;
                            n++;
                            Random rand = new Random();
                            int intRand;
                            if (n < 100) {
                                stack.push(str);
                                added++;
                            }

                            else {
                                intRand = rand.nextInt(2);
                                if (intRand == 1) {
                                    stack.push(str);
                                    added++;
                                }

                                else {
                                    stack.pop();
                                    taken++;
                                }
                            }
                        }
                    }
                }
            }
            Date d2 = new Date();
            System.out.println("Total words "+n);
            System.out.println("Total added "+added);
            System.out.println("Total taken "+taken);
            long time = d2.getTime()-d1.getTime();
            System.out.println("Time of processing (ms) "+time);
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
