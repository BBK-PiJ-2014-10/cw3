import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionalArrayListTest {

    @Test
    public void testHead() {
        FunctionalArrayList fal = new FunctionalArrayList();
        assertTrue(fal.head().hasError());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, fal.head().getError());
        fal.add(1);
        assertEquals(1, fal.size());
        assertTrue(!fal.head().hasError());
        assertEquals(1, fal.head().getReturnValue());
    }

    @Test
    public void testRest() {
        FunctionalArrayList fal = new FunctionalArrayList();
        FunctionalArrayList restFal = fal.rest();
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