import junit.framework.TestCase;
import org.junit.Test;

public class ArrayListTest extends TestCase {

    @Test
    public void testsIsEmpty() {
        List al = new ArrayList();
        assertEquals(true, al.isEmpty());
        al.add(1);
        assertEquals(false, al.isEmpty());
        al.remove(0);
        assertEquals(true, al.isEmpty());
    }

    @Test
    public void testSize() {
        List al = new ArrayList();
        assertEquals(0, al.size());
        al.add(1);
        assertEquals(1, al.size());
        al.add(1);
        assertEquals(2, al.size());
        al.remove(0);
        assertEquals(1, al.size());
        al.remove(0);
        assertEquals(0, al.size());

    }

    @Test
    public void testGet() {
        List al = new ArrayList();

        ReturnObject result = al.get(0);
        assertTrue(result.hasError());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, result.getError());

        al.add(1);

        result = al.get(1);
        assertTrue(result.hasError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());

        result = al.get(0);
        assertTrue(!result.hasError());
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals(1, result.getReturnValue());
    }

    @Test
    public void testRemove() {
        List al = new ArrayList();

        al.add(1);
        al.add(1);
        assertEquals(2, al.size());

        ReturnObject result = al.remove(0);
        assertTrue(!result.hasError());
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals(1, result.getReturnValue());
        assertEquals(1, al.size());

        result = al.remove(0);
        assertTrue(!result.hasError());
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals(1, result.getReturnValue());
        assertEquals(0, al.size());

        result = al.remove(2);
        assertTrue(result.hasError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());
    }

    @Test
    public void testAdd() {
        List al = new ArrayList();

        ReturnObject result = al.add(1);
        assertTrue(!result.hasError());
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals(1, al.size());
        // As per http://moodle.bbk.ac.uk/mod/forumng/discuss.php?d=289
        assertEquals(null, result.getReturnValue());

        al.add(1);
        assertEquals(2, al.size());
    }

    @Test
    public void testAddWithIndex() {
        List al = new ArrayList();

        ReturnObject result = al.add(0, 1);
        assertTrue(!result.hasError());
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals(1, al.size());
        // As per http://moodle.bbk.ac.uk/mod/forumng/discuss.php?d=289
        assertEquals(null, result.getReturnValue());

        List nal = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            nal.add(i, i);
            assertEquals(i, nal.get(i).getReturnValue());
        }

        result = al.add(5, 1);
        assertTrue(result.hasError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());

        result = al.add(-1, 1);
        assertTrue(result.hasError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());
    }
}