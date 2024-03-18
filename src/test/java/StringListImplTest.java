import org.example.StringList;
import org.example.StringListImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private StringListImpl stringList;
    @BeforeEach
    public void setUp() {
        stringList = new StringListImpl();
    }
    @Test
    void testAdd() {
        stringList.add("item1");
        stringList.add("item2");
        assertEquals(2, stringList.size());
        assertTrue(stringList.contains("item1"));
        assertTrue(stringList.contains("item2"));
    }
    @Test
    void testAddAtIndex() {
        stringList.add("item1");
        stringList.add("item3");
        stringList.add(1, "item2");
        assertEquals(3, stringList.size());
        assertEquals("item1", stringList.get(0));
        assertEquals("item2", stringList.get(1));
        assertEquals("item3", stringList.get(2));
    }
    @Test
    void testSet() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.set(1, "item3");
        assertEquals(2, stringList.size());
        assertEquals("item1", stringList.get(0));
        assertEquals("item3", stringList.get(1));
    }
    @Test
    void testRemoveByItem() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        stringList.remove("item2");
        assertEquals(2, stringList.size());
        assertTrue(stringList.contains("item2"));
        assertEquals("item1", stringList.get(0));
        assertEquals("item2", stringList.get(1));
    }
    @Test
    void testRemoveByIndex() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        stringList.remove(1);
        assertEquals(2, stringList.size());
        assertFalse(stringList.contains("item2"));
        assertEquals("item1", stringList.get(0));
        assertEquals("item3", stringList.get(1));
    }
    @Test
    void testContains() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        assertTrue(stringList.contains("item1"));
        assertTrue(stringList.contains("item2"));
        assertTrue(stringList.contains("item3"));
        assertFalse(stringList.contains("item4"));
    }
    @Test
    void testIndexOf() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        assertEquals(0, stringList.indexOf("item1"));
        assertEquals(1, stringList.indexOf("item2"));
        assertEquals(2, stringList.indexOf("item3"));
        assertEquals(-1, stringList.indexOf("item4"));
    }
    @Test
    void testLastIndexOf() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item2");
        stringList.add("item3");
        assertEquals(0, stringList.lastIndexOf("item1"));
        assertEquals(2, stringList.lastIndexOf("item2"));
        assertEquals(3, stringList.lastIndexOf("item3"));
        assertEquals(-1, stringList.lastIndexOf("item4"));
    }
    @Test
    void testGet() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        assertEquals("item1", stringList.get(0));
        assertEquals("item2", stringList.get(1));
        assertEquals("item3", stringList.get(2));
    }
    @Test
    void testEquals() {
        StringList otherList = new StringListImpl();
        otherList.add("item1");
        otherList.add("item2");
        otherList.add("item3");
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        assertTrue(stringList.equals(otherList));
    }
    @Test
    void testSize() {
        assertEquals(0, stringList.size());
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        assertEquals(3, stringList.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stringList.isEmpty());
        stringList.add("item1");
        assertFalse(stringList.isEmpty());
    }

    @Test
    void testClear() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        stringList.clear();
        assertEquals(0, stringList.size());
        assertTrue(stringList.isEmpty());
    }
    @Test
    void testToArray() {
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        String[] array = stringList.toArray();
        assertEquals(3, array.length);
        assertEquals("item1", array[0]);
        assertEquals("item2", array[1]);
        assertEquals("item3", array[2]);
    }
}