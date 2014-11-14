
import java.lang.reflect.Array;


//Initialize example: Stack<String> = new Stack<String>(String.class,10)
//push(x) – add x, è pop() – get item from the stack. 
public class Stack<K> {
	int size;
	K[] data;
	Class kClass;
	
	Stack(Class kClass, int capacity) {
		data = (K[]) Array.newInstance(kClass, capacity);
		this.kClass = kClass;
	}

	void push(K value) {
		if (size == data.length) {
			int newSize = size*2;
			K[] data1 = (K[]) Array.newInstance(kClass, newSize);
			System.arraycopy(data, 0, data1, 0, size);
			data = data1;
		}
		data[size++] = value;
	}

	K pop() {
		try {
			return data[--size];
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
