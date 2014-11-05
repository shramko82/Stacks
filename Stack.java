
import java.lang.reflect.Array;

//��� ���������� ��������� �� ��������, ����� ������ ���������������� ������ ������������ ���� �
//��� ���������� ����� ������� ������������ ����������� ���� Stack<String> = new Stack<String>(String.class,10)
//push(x) � �������� x � ����, � pop() � ������� �������� �� �����. 
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
