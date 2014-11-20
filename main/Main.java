package main;

public class Main {

	public static void main(String[] args) {
		Deque<String> d = new Deque<String>();
		d.pushFirst("111");

		
		System.out.println(d.popFirst());
		System.out.println(d.popFirst());

	    
//	    Stack<String> s =new Stack<String>();
//	    s.push("111");
//	    s.push("222");
//	    s.push("333");
//	    System.out.println(s.pop());
	    
	}
}
