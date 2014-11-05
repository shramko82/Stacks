
import java.lang.reflect.Array;

//при реализации наткнулс€ на проблему, когда нельз€ инициализировать массив неизвестного типа  
//при объ€влении стека следует использовать конструкцию типа Stack<String> = new Stack<String>(String.class,10)
//push(x) Ц добавить x в стек, и pop() Ц извлечь верхушку из стека. 
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
