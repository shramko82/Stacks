package tests;

import static org.junit.Assert.*;
import main.Deque;

import org.junit.Test;

public class DequeTest {

    @Test
    public void test() {
        Deque<String> test = new Deque<String>();
        
        test.pushFirst("111");
        test.pushFirst("222");
        test.pushFirst("333");
        test.pushLast("444");
        test.pushLast("555");
        test.pushLast("666");
        
        assertEquals("333",test.popFirst());
        assertEquals("666",test.popLast());
        assertEquals("222",test.popFirst());
        assertEquals("555",test.popLast());
        assertEquals("444",test.popLast());
        assertEquals("111",test.popLast());
        assertEquals(null,test.popLast());
        assertEquals(null,test.popFirst());
    }

}
