package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
//		Deque<String> d = new Deque<String>();
//		d.pushFirst("111");
//        d.pushFirst("222");
//		d.pushLast("333");
//		for (String str : d)
//	    	System.out.println(str);
		

	    List l = new ArrayList();
	    Stack<String> s =new Stack<String>();
	    System.out.println(s.size()+" - "+s.length());
	    for (int i = 0; i < 100; i++) {
			s.push("111");
			System.out.println(s.size()+" - "+s.length());

			
		}
	    for (int i = 0; i < 100; i++) {
			s.pop();
			System.out.println(s.size()+" - "+s.length());

			
		}
	    
	    
	    	
	    
	}
}
