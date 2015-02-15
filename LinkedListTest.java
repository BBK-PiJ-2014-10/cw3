import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void testsIsEmpty() {
        LinkedList ll = new LinkedList();
        assertEquals(true, ll.isEmpty());
        ll.add(1);
        assertEquals(false, ll.isEmpty());
        ll.remove(0);
        assertEquals(true, ll.isEmpty());
    }

    @Test
    public void testSize() {
        LinkedList ll = new LinkedList();
        assertEquals(0, ll.size());
        ll.add(1);
        assertEquals(1, ll.size());
        ll.add(1);
        assertEquals(2, ll.size());
        ll.remove(0);
        assertEquals(1, ll.size());
        ll.remove(0);
        assertEquals(0, ll.size());

    }

    @Test
    public void testGet() {
        LinkedList ll = new LinkedList();

        ReturnObject result = ll.get(0);
        assertTrue(result.hasError());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, result.getError());

        ll.add(1);

        result = ll.get(1);
        assertTrue(result.hasError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());

        result = ll.get(0);
        assertTrue(!result.hasError());
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals(1, result.getReturnValue());
    }

    @Test
    public void testRemove() {
        LinkedList ll = new LinkedList();

        ll.add(1);
        ll.add(1);
        assertEquals(2,ll.size());

        ReturnObject result = ll.remove(0);
        assertTrue(!result.hasError());
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals(1, result.getReturnValue());
        assertEquals(1,ll.size());

        result = ll.remove(0);
        assertTrue(!result.hasError());
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals(1, result.getReturnValue());
        assertEquals(0,ll.size());

        result = ll.remove(2);
        assertTrue(result.hasError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());
    }

    @Test
    public void testAdd() {
        LinkedList ll = new LinkedList();

        ReturnObject result = ll.add(1);
        assertTrue(!result.hasError());
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals(1,ll.size());
        // As per http://moodle.bbk.ac.uk/mod/forumng/discuss.php?d=289
        assertEquals(null, result.getReturnValue());

        ll.add(1);
        assertEquals(2,ll.size());
    }

    @Test
    public void testAddWithIndex() {
        LinkedList ll = new LinkedList();

        ReturnObject result = ll.add(0, 1);
        assertTrue(!result.hasError());
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals(1, ll.size());
        // As per http://moodle.bbk.ac.uk/mod/forumng/discuss.php?d=289
        assertEquals(null, result.getReturnValue());

        ll.add(1, 1);
        assertEquals(2, ll.size());

        result = ll.add(5, 1);
        assertTrue(result.hasError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());

        result = ll.add(-1, 1);
        assertTrue(result.hasError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());
    }
}