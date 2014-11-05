import java.lang.reflect.Array;

// Dequeu - двусторонн€€ очередь
// ѕример инициализации: Dequeu<String> = new Dequeu<String>(String.class,10)
// pushBack(x) Ц добавить x в хвост, и popBack() Ц извлечь из хвоста. 

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