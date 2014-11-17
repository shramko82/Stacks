
public class Main {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("111");
		stack.push("222");
		stack.push("333");
		stack.push("444");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push("555");
		System.out.println(stack.pop());
		
	}
}
