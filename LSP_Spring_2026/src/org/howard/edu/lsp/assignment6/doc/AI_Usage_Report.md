Prompt 1:
- Prompt: How do I write a JUnit 5 test to verify that a custom set's equals() method correctly identifies two sets as equal when they contain the same integers but were added in a different order?

- AI Response: Create a second set and add the same elements in a different order, then use assertTrue with the equals() method to confirm both sets are considered equal, since a proper set implementation should be order-independent.

- How I implemented the AI response: I created a temporary IntegerSet and added the values 3, 1, and 2 — the reverse of set1's insertion order. I then called assertTrue(set1.equals(temp)) to confirm that the equals() method correctly handled order independence, satisfying both the normal and edge case requirements for that method.





Prompt 2:
- Prompt: How should I write JUnit 5 tests for methods that are expected to throw an exception when called on an empty set, such as largest() and smallest()?

- AI Response: Create a new empty IntegerSet and use assertThrows() with RuntimeException.class as the expected exception type, passing a method reference to the method being tested. This confirms the method throws the correct exception rather than returning an incorrect value or crashing silently.

- How I implemented the AI response: I created a new empty IntegerSet in both testLargestEmpty() and testSmallestEmpty(), then used assertThrows(RuntimeException.class, empty::largest) and assertThrows(RuntimeException.class, empty::smallest) respectively. This confirmed that both methods properly guard against being called on an empty set, covering the required exception edge cases.