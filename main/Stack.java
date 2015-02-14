package main;

import java.lang.reflect.Array;
import java.util.Iterator;

//Initialize example: Stack<String> = new Stack<String>(String.class,10)
//push(x) – add x, è pop() – get item from the stack. 
public class Stack<K> implements Iterable<K> {
	private int size;
	private  Object[] data;

    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public Stack() {
        this.data = EMPTY_ELEMENTDATA;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public int length() {
        return data.length;
    }
    
    public Stack(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "
                    + initialCapacity);
        this.data = new Object[initialCapacity];
    }

    private void ensureCapacityGrow(int newCapacity) {
        if (data == EMPTY_ELEMENTDATA) {
        	newCapacity = Math.max(DEFAULT_CAPACITY, newCapacity);
        	grow(newCapacity);
        } else if (newCapacity * 2 - length() > 0)
        	grow(length()*2);
    }

    private void ensureCapacityDecrease(int newCapacity) {
        if (data == EMPTY_ELEMENTDATA) {
        	throw new IllegalArgumentException("Illegal Capacity: "
                    + newCapacity);
        }
        if ((newCapacity < length()/4) && (length() > DEFAULT_CAPACITY))
        	decrease(Math.max(DEFAULT_CAPACITY,length()/2));
    }
    
    private void decrease(int newCapacity) {
    	newCapacity = Math.max(newCapacity, DEFAULT_CAPACITY);
    	data = copyOf(data, newCapacity);
    }

    private void grow(int newCapacity) {
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(newCapacity);
        data = copyOf(data, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    @SuppressWarnings("unchecked")
    private static <T> T[] copyOf(T[] original, int newLength) {
        return (T[]) copyOf(original, newLength, original.getClass());
    }

    private static <T, U> T[] copyOf(U[] original, int newLength,
            Class<? extends T[]> newType) {
        @SuppressWarnings("unchecked")
        T[] copy = ((Object) newType == (Object) Object[].class) ? (T[]) new Object[newLength]
                : (T[]) Array
                        .newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
        return copy;
    }

    public void push(K value) {
        ensureCapacityGrow(size + 1);
        data[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public K pop() {
        if (size() == 0)
            return null;
        ensureCapacityDecrease(size - 1);
        K item = (K) data[size-1];
        data[size-1] = null;
        size--;
        return item;
    }

	@Override
	public Iterator<K> iterator() {
		return new Iterator<K>() {
			private int index = 0;

			public boolean hasNext() {
				return index < size;
			}

			@SuppressWarnings("unchecked")
			public K next() {
				return (K) data[index++];
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}
}
