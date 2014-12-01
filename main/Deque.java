package main;

public class Deque<K> {
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
    //List list = new LinkedList();

    public Deque() {
    	
    }

    private K unlinkFirst(Node<K> f) {
        // assert f == first && f != null;
        final K element = f.item;
        final Node<K> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;

        return element;
    }
    
    private K unlinkLast(Node<K> l) {
        // assert l == last && l != null;
        final K element = l.item;
        final Node<K> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
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
        //final Node<K> l = last;
        return unlinkLast(last);
    }
    
    public K popFirst() {
        if (size == 0)
            return null;
        //final Node<K> f = first;
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

}