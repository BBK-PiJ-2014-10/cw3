import junit.framework.TestCase;
import org.junit.Test;

public class ImprovedStackImplTest extends TestCase {

    @Test
    public void testReverse() {
        ImprovedStack stack = new ImprovedStackImpl(new LinkedList());

        for (int i = 1; i < 1000; i++) {
            stack.push(i);
        }

        Stack reversedStack = stack.reverse();

        for (int i = 1; i < 1000; i++) {
            assertEquals(i, reversedStack.pop().getReturnValue());
        }
    }

    @Test
    public void testRemove() {
        ImprovedStack stack = new ImprovedStackImpl(new LinkedList());

        for (int i = 1; i < 1001; i++) {
            if (i % 2 == 0) {
                stack.push(1);
            } else {
                stack.push(2);
            }

        }

        assertEquals(1000, stack.size());
        stack.remove(1);
        assertEquals(500, stack.size());

        for (int i = 0; i < stack.size(); i++) {
            assertEquals(2, stack.pop().getReturnValue());
        }
    }

    @Test
    public void testIsEmpty() {
        ImprovedStack stack = new ImprovedStackImpl(new LinkedList());

        assertTrue(stack.isEmpty());

        stack.push(1);
        assertTrue(!stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        ImprovedStack stack = new ImprovedStackImpl(new LinkedList());

        assertEquals(0, stack.size());

        stack.push(1);
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void testPush() {
        ImprovedStack stack = new ImprovedStackImpl(new LinkedList());

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
        ImprovedStack stack = new ImprovedStackImpl(new LinkedList());

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
        ImprovedStack stack = new ImprovedStackImpl(new LinkedList());

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
