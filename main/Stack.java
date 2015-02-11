package main;

import java.lang.reflect.Array;
import java.util.Iterator;

//Initialize example: Stack<String> = new Stack<String>(String.class,10)
//push(x) – add x, è pop() – get item from the stack. 
public class Stack<K> implements Iterable<K> {
    int size;
    public Object[] data;

    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public Stack() {
        this.data = EMPTY_ELEMENTDATA;
    }

    public Stack(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "
                    + initialCapacity);
        this.data = new Object[initialCapacity];
    }

    public void ensureCapacity(int minCapacity) {
        int minExpand = (data != EMPTY_ELEMENTDATA)
        // any size if real element table
        ? 0
                // larger than default for empty table. It's already supposed to
                // be
                // at default size.
                : DEFAULT_CAPACITY;

        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (data == EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {

        if (minCapacity * 2 - data.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = minCapacity;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
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
        ensureCapacityInternal(size + 1);
        data[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public K pop() {
        if (size == 0)
            return null;
        return (K) data[--size];
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
