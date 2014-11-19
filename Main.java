
public class Main {

	public static void main(String[] args) {
		Deque<String> d = new Deque<String>();
		d.pushFirst("111");
		d.pushFirst("222");
		d.pushFirst("333");
		d.pushFirst("444");
		
		System.out.println(d.popFirst());
		System.out.println(d.popFirst());
		d.pushLast("555");
		System.out.println(d.popFirst());
		System.out.println(d.popLast());
	}
}
