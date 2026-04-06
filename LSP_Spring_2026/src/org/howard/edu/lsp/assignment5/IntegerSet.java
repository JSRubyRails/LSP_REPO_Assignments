package org.howard.edu.lsp.assignment5;

/**
 * Models a mathematical set of integers 
 * A set cannot contain duplicate values 
 * Supports standard set operations: union, intersection, differences, and complement
 * @author Elias Zegeye
 */

import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet {
    
    private ArrayList<Integer> set = new ArrayList<>();

    // Removes all elements from the set
    public void clear() {
        set.clear();
    }

    // Returns the length of the set
    public int length() {
        return set.size();
    }

    // Returns true if two sets are equal (same elements)
    public boolean equals(IntegerSet b) {
        if (b == null) return false;
        if (this.length() != b.length()) return false;

        ArrayList<Integer> aList = new ArrayList<>(this.set);
        ArrayList<Integer> bList = new ArrayList<>(b.set);

        Collections.sort(aList);
        Collections.sort(bList);

        return aList.equals(bList);
    }

    // Returns true if value is in the set
    public boolean contains(int value) {
        return set.contains(value);
    }

    // Returns largest value
    public int largest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    // Returns smallest value
    public int smallest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    // Adds item (no duplicates allowed)
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    // Removes item if it exists
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    // UNION
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        result.set.addAll(this.set);

        for (int item : intSetb.set) {
            if (!result.set.contains(item)) {
                result.set.add(item);
            }
        }

        return result;
    }

    // INTERSECTION
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : this.set) {
            if (intSetb.set.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    // DIFFERENCE (this - b)
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : this.set) {
            if (!intSetb.set.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    // COMPLEMENT (b - this)
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : intSetb.set) {
            if (!this.set.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    // Returns true if set is empty
    public boolean isEmpty() {
        return set.isEmpty();
    }

    // REQUIRED STRING FORMAT
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);

        return sorted.toString();
    }
}