
import java.lang.reflect.Array;

//Initialize example: Stack<String> = new Stack<String>(String.class,10)
//push(x) – add x, è pop() – get item from the stack. 
public class Stack<K> {
	int size;
	K[] data;

	Stack(Class kClass, int capacity) {
		data = (K[]) Array.newInstance(kClass, capacity);
	}

	void push(K value) {
		data[size++] = value;
	}

	K pop() {
		return data[--size];
	}
}
