import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackImplTest {

    @Test
    public void testIsEmpty() {
        LinkedList ll = new LinkedList();
        StackImpl stack = new StackImpl(ll);

        assertTrue(stack.isEmpty());

        stack.push(1);
        assertTrue(!stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        LinkedList ll = new LinkedList();
        StackImpl stack = new StackImpl(ll);

        assertEquals(0, stack.size());

        stack.push(1);
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void testPush() {
        LinkedList ll = new LinkedList();
        StackImpl stack = new StackImpl(ll);

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());

        for (int i = 1; i < 999; i++) {
            stack.push(i);
            assertTrue(!stack.isEmpty());
            assertEquals(i, stack.size());
        }
    }

    @Test
    public void testTop() {
        LinkedList ll = new LinkedList();
        StackImpl stack = new StackImpl(ll);

        stack.push(1);
        assertEquals(1, stack.top().getReturnValue());
        assertEquals(1, stack.size());
        stack.pop();

        for (int i = 1; i < 999; i++) {
            stack.push(i);
            assertEquals(i, stack.top().getReturnValue());
            assertEquals(i, stack.size());
        }
    }

    @Test
    public void testPop() {
        LinkedList ll = new LinkedList();
        StackImpl stack = new StackImpl(ll);

        stack.push(1);
        assertEquals(1, stack.pop().getReturnValue());
        assertEquals(0, stack.size());

        for (int i = 1; i < 999; i++) {
            stack.push(i);
            assertEquals(i, stack.pop().getReturnValue());
            assertEquals(0, stack.size());
        }
    }
}
