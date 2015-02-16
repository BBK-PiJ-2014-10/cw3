import junit.framework.TestCase;
import org.junit.Test;

public class FunctionalArrayListTest extends TestCase {

    @Test
    public void testHead() {
        FunctionalList fal = new FunctionalArrayList();
        assertTrue(fal.head().hasError());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, fal.head().getError());
        fal.add(1);
        assertEquals(1, fal.size());
        assertTrue(!fal.head().hasError());
        assertEquals(1, fal.head().getReturnValue());
    }

    @Test
    public void testRest() {
        FunctionalList fal = new FunctionalArrayList();
        FunctionalList restFal = fal.rest();
        assertTrue(restFal.isEmpty());
        fal.add(1);
        assertEquals(1, fal.size());
        restFal = fal.rest();
        assertTrue(restFal.isEmpty());
        assertEquals(1, fal.size());
        fal.add(1);
        assertEquals(2, fal.size());
        restFal = fal.rest();
        assertEquals(2, fal.size());
        assertTrue(!restFal.isEmpty());
        assertEquals(1, restFal.size());
        assertEquals(2, fal.size());
        assertEquals(1, restFal.get(0).getReturnValue());
    }
}