import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayListTest {
    @Test
    public void testsGetSize() {
        ArrayList al = new ArrayList();
        assertEquals(0, al.size());
    }
    @Test
    public void testsIsEmpty() {
        ArrayList al = new ArrayList();
        assertEquals(true, al.isEmpty());
    }
}