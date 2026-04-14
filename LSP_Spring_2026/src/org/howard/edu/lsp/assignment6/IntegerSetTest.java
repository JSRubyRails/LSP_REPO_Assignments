package org.howard.edu.lsp.assignment6;

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
        // Edge case: same elements, different insertion order
        IntegerSet temp = new IntegerSet();
        temp.add(3);
        temp.add(1);
        temp.add(2);
        assertTrue(set1.equals(temp));
    }

    @Test
    public void testEqualsFalse() {
        // Normal case: two different sets are not equal
        assertFalse(set1.equals(set2));
    }

    // ---------------- CONTAINS ----------------
    @Test
    public void testContainsPresent() {
        // Normal case: value is in the set
        assertTrue(set1.contains(2));
    }

    @Test
    public void testContainsNotPresent() {
        // Edge case: value is not in the set
        assertFalse(set1.contains(5));
    }

    // ---------------- LARGEST ----------------
    @Test
    public void testLargest() {
        // Normal case: multiple elements
        assertEquals(3, set1.largest());
    }

    @Test
    public void testLargestSingleElement() {
        // Edge case: single element
        IntegerSet single = new IntegerSet();
        single.add(42);
        assertEquals(42, single.largest());
    }

    @Test
    public void testLargestEmpty() {
        // Edge case: empty set throws exception
        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::largest);
    }

    // ---------------- SMALLEST ----------------
    @Test
    public void testSmallest() {
        // Normal case: multiple elements
        assertEquals(1, set1.smallest());
    }

    @Test
    public void testSmallestSingleElement() {
        // Edge case: single element
        IntegerSet single = new IntegerSet();
        single.add(7);
        assertEquals(7, single.smallest());
    }

    @Test
    public void testSmallestEmpty() {
        // Edge case: empty set throws exception
        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::smallest);
    }

    // ---------------- ADD ----------------
    @Test
    public void testAddNormal() {
        // Normal case: adding a new element increases length and element is present
        set1.add(99);
        assertEquals(4, set1.length());
        assertTrue(set1.contains(99));
    }

    @Test
    public void testAddNoDuplicates() {
        // Edge case: adding a duplicate does not change the set
        set1.add(2);
        assertEquals(3, set1.length());
    }

    // ---------------- REMOVE ----------------
    @Test
    public void testRemove() {
        // Normal case: removing an existing element
        set1.remove(2);
        assertFalse(set1.contains(2));
        assertEquals(2, set1.length());
    }

    @Test
    public void testRemoveNonExistent() {
        // Edge case: removing a value not in the set does not crash or change length
        set1.remove(10);
        assertEquals(3, set1.length());
    }

    // ---------------- UNION ----------------
    @Test
    public void testUnion() {
        // Normal case: union of two overlapping sets
        IntegerSet result = set1.union(set2);
        assertEquals("[1, 2, 3, 4]", result.toString());
    }

    @Test
    public void testUnionWithEmpty() {
        // Edge case: union with an empty set returns the original set
        IntegerSet empty = new IntegerSet();
        IntegerSet result = set1.union(empty);
        assertEquals("[1, 2, 3]", result.toString());
    }

    // ---------------- INTERSECT ----------------
    @Test
    public void testIntersect() {
        // Normal case: two overlapping sets
        IntegerSet result = set1.intersect(set2);
        assertEquals("[2, 3]", result.toString());
    }

    @Test
    public void testIntersectNoCommonElements() {
        // Edge case: no common elements between two non-empty sets
        IntegerSet disjoint = new IntegerSet();
        disjoint.add(5);
        disjoint.add(6);
        disjoint.add(7);
        IntegerSet result = set1.intersect(disjoint);
        assertEquals("[]", result.toString());
    }

    // ---------------- DIFF ----------------
    @Test
    public void testDiff() {
        // Normal case: set1 minus set2
        IntegerSet result = set1.diff(set2);
        assertEquals("[1]", result.toString());
    }

    @Test
    public void testDiffIdenticalSets() {
        // Edge case: diff of identical sets is empty
        IntegerSet copy = new IntegerSet();
        copy.add(1);
        copy.add(2);
        copy.add(3);
        IntegerSet result = set1.diff(copy);
        assertEquals("[]", result.toString());
    }

    // ---------------- COMPLEMENT ----------------
    @Test
    public void testComplement() {
        // Normal case: elements in set2 not in set1
        IntegerSet result = set1.complement(set2);
        assertEquals("[4]", result.toString());
    }

    @Test
    public void testComplementDisjointSets() {
        // Edge case: complement of two fully disjoint sets returns all of set2
        IntegerSet disjoint = new IntegerSet();
        disjoint.add(5);
        disjoint.add(6);
        IntegerSet result = set1.complement(disjoint);
        assertEquals("[5, 6]", result.toString());
    }

    // ---------------- ISEMPTY ----------------
    @Test
    public void testIsEmptyTrue() {
        // Edge case: empty set
        IntegerSet empty = new IntegerSet();
        assertTrue(empty.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        // Normal case: non-empty set
        assertFalse(set1.isEmpty());
    }

    // ---------------- TOSTRING ----------------
    @Test
    public void testToStringSorted() {
        // Normal case: elements are sorted in output
        IntegerSet temp = new IntegerSet();
        temp.add(5);
        temp.add(1);
        temp.add(3);
        assertEquals("[1, 3, 5]", temp.toString());
    }

    @Test
    public void testToStringEmpty() {
        // Edge case: empty set produces []
        IntegerSet empty = new IntegerSet();
        assertEquals("[]", empty.toString());
    }
}