package org.howard.edu.lsp.assignment5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setup() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);
    }

    // ---------------- CLEAR ----------------
    @Test
    public void testClear() {
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    // ---------------- LENGTH ----------------
    @Test
    public void testLength() {
        assertEquals(3, set1.length());
    }

    // ---------------- EQUALS ----------------
    @Test
    public void testEqualsTrue() {
        IntegerSet temp = new IntegerSet();
        temp.add(3);
        temp.add(1);
        temp.add(2);

        assertTrue(set1.equals(temp));
    }

    @Test
    public void testEqualsFalse() {
        assertFalse(set1.equals(set2));
    }

    // ---------------- CONTAINS ----------------
    @Test
    public void testContains() {
        assertTrue(set1.contains(2));
        assertFalse(set1.contains(5));
    }

    // ---------------- LARGEST ----------------
    @Test
    public void testLargest() {
        assertEquals(3, set1.largest());
    }

    @Test
    public void testLargestEmpty() {
        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::largest);
    }

    // ---------------- SMALLEST ----------------
    @Test
    public void testSmallest() {
        assertEquals(1, set1.smallest());
    }

    @Test
    public void testSmallestEmpty() {
        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::smallest);
    }

    // ---------------- ADD ----------------
    @Test
    public void testAddNoDuplicates() {
        set1.add(2); // duplicate
        assertEquals(3, set1.length());
    }

    // ---------------- REMOVE ----------------
    @Test
    public void testRemove() {
        set1.remove(2);
        assertFalse(set1.contains(2));
    }

    @Test
    public void testRemoveNonExistent() {
        set1.remove(10); // should not crash
        assertEquals(3, set1.length());
    }

    // ---------------- UNION ----------------
    @Test
    public void testUnion() {
        IntegerSet result = set1.union(set2);
        assertEquals("[1, 2, 3, 4]", result.toString());
    }

    // ---------------- INTERSECT ----------------
    @Test
    public void testIntersect() {
        IntegerSet result = set1.intersect(set2);
        assertEquals("[2, 3]", result.toString());
    }

    // ---------------- DIFF ----------------
    @Test
    public void testDiff() {
        IntegerSet result = set1.diff(set2);
        assertEquals("[1]", result.toString());
    }

    // ---------------- COMPLEMENT ----------------
    @Test
    public void testComplement() {
        IntegerSet result = set1.complement(set2);
        assertEquals("[4]", result.toString());
    }

    // ---------------- ISEMPTY ----------------
    @Test
    public void testIsEmpty() {
        IntegerSet empty = new IntegerSet();
        assertTrue(empty.isEmpty());
        assertFalse(set1.isEmpty());
    }

    // ---------------- TOSTRING ----------------
    @Test
    public void testToStringSorted() {
        IntegerSet temp = new IntegerSet();
        temp.add(5);
        temp.add(1);
        temp.add(3);

        assertEquals("[1, 3, 5]", temp.toString());
    }

    @Test
    public void testToStringEmpty() {
        IntegerSet empty = new IntegerSet();
        assertEquals("[]", empty.toString());
    }

    // ---------------- EDGE CASES ----------------
    @Test
    public void testUnionWithEmpty() {
        IntegerSet empty = new IntegerSet();
        IntegerSet result = set1.union(empty);
        assertEquals("[1, 2, 3]", result.toString());
    }

    @Test
    public void testIntersectWithEmpty() {
        IntegerSet empty = new IntegerSet();
        IntegerSet result = set1.intersect(empty);
        assertEquals("[]", result.toString());
    }

    @Test
    public void testDiffWithEmpty() {
        IntegerSet empty = new IntegerSet();
        IntegerSet result = set1.diff(empty);
        assertEquals("[1, 2, 3]", result.toString());
    }

    @Test
    public void testComplementWithEmpty() {
        IntegerSet empty = new IntegerSet();
        IntegerSet result = set1.complement(empty);
        assertEquals("[]", result.toString());
    }
}