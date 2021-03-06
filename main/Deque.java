package main;

import java.util.Iterator;

public class Deque<K> implements Iterable<K> {
    int size = 0;
    
    Node<K> first;
    Node<K> last;

    private static class Node<K> {
        K item; 
        Node<K> next;
        Node<K> prev;

        Node(Node<K> prev, K element, Node<K> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public Deque() {
    	
    }

    private K unlinkFirst(Node<K> f) {

        final K element = f.item;
        final Node<K> next = f.next;
        f.item = null;
        f.next = null; 
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;

        return element;
    }
    
    private K unlinkLast(Node<K> l) {

        final K element = l.item;
        final Node<K> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
  
        return element;
    }

    public K popLast() {
        if (size == 0)
            return null;
        return unlinkLast(last);
    }
    
    public K popFirst() {
        if (size == 0)
            return null;
        return unlinkFirst(first);
    }

    public void pushFirst(K e) {
        final Node<K> f = first;
        final Node<K> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    public void pushLast(K e) {
        final Node<K> l = last;
        final Node<K> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }
    
	@Override
	public Iterator<K> iterator() {
		return new Iterator<K>() {
			private int index = 0;
			private Node<K> currentIterator;

			public boolean hasNext() {
				return index < size;
			}

			public K next() {
				if (index++ == 0) {
					currentIterator = first;
					return (K) currentIterator.item;
				} else {
					currentIterator = currentIterator.next;
					return (K) currentIterator.item;
				}

			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

}