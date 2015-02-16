import junit.framework.TestCase;
import org.junit.Test;

public class FunctionalLinkedListTest extends TestCase {

    @Test
    public void testHead() {
        FunctionalList fll = new FunctionalLinkedList();
        assertTrue(fll.head().hasError());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, fll.head().getError());
        fll.add(1);
        assertEquals(1, fll.size());
        assertTrue(!fll.head().hasError());
        assertEquals(1, fll.head().getReturnValue());
    }

    @Test
    public void testRest() {
        FunctionalList fll = new FunctionalLinkedList();
        FunctionalList restFll = fll.rest();
        assertTrue(restFll.isEmpty());
        fll.add(1);
        assertEquals(1, fll.size());
        restFll = fll.rest();
        assertTrue(restFll.isEmpty());
        assertEquals(1, fll.size());
        fll.add(1);
        assertEquals(2, fll.size());
        restFll = fll.rest();
        assertTrue(!restFll.isEmpty());
        assertEquals(1, restFll.size());
        assertEquals(2, fll.size());
        assertEquals(1, restFll.get(0).getReturnValue());
    }

}