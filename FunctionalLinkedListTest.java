import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FunctionalLinkedListTest {

    @Test
    public void testHead() {
        FunctionalLinkedList fll = new FunctionalLinkedList();
        fll.add(1);
        assertEquals(1, fll.size());
        assertTrue(!fll.head().hasError());
        assertEquals(1, fll.head().getReturnValue());
    }

    @Test
    public void testRest() {
        FunctionalLinkedList fll = new FunctionalLinkedList();
        FunctionalLinkedList restFll = fll.rest();
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