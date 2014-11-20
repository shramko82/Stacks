package tests;

import static org.junit.Assert.*;
import main.Stack;

import org.junit.Test;

public class StackTest {

    @Test
    public void test() {
        Stack<String> test = new Stack<String>();
        
        test.push("111");
        test.push("222");
        test.push("333");
        assertEquals("333",test.pop());
        assertEquals("222",test.pop());
        assertEquals("111",test.pop());
        assertEquals(null,test.pop());
        
    }

}
