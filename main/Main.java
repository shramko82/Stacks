package main;

public class Main {

	public static void main(String[] args) {
		Deque<String> d = new Deque<String>();
		d.pushFirst("111");
        d.pushFirst("222");
		d.pushLast("333");
		for (String str : d)
	    	System.out.println(str);
		

	    
//	    Stack<String> s =new Stack<String>();
//	    s.push("111");
//	    s.push("222");
//	    s.push("333");
//	    for (String str : s)
//	    	System.out.println(str);
	    
	}
}
