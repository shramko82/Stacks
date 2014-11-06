import java.lang.reflect.Array;


// Initialize example: Dequeu<String> = new Dequeu<String>(String.class,10)
// push..(x) – add x to head/tail, è pop...() – get item from head/tail. 

class Deque<K> {
    int size;
    int head;
    int tail;
    K[] data;


    Deque(Class kClass, int size) {
        
        data = (K[]) Array.newInstance(kClass, this.size = size);
        
    }

    void pushBack(K value) {
        if (++tail == size)
            tail = 0;
        data[tail] = value;
    }

    K popBack() {
        K ret = data[tail];
        if (--tail < 0)
            tail = size - 1;
        return ret;
    }

    void pushFront(K value) {
        data[head] = value;
        if (--head < 0)
            head = size - 1;
    }

    K popFront() {
        if (++head == size)
            head = 0;
        return data[head];
    }

    boolean isEmpty() {
        return head == tail;
    }
}