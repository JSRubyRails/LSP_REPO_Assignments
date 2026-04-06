Prompt 1:
- Prompt: How can I implement the union operation for a set of integers in Java using an ArrayList while avoiding duplicates and not modifying the original sets? 

- AI Response: Create a new IntegerSet, adding all elements from the first set, iterate through the second set and only adding elements not already present, and ensure no modification of the original sets.

- How I implemented the AI response: I created a new IntegerSet and used addAll() to copy elements from the current set. Then I looped through the second set and added only elements that were not already present in the result. This ensured uniqueness and preserved immutability of the original sets. 



Prompt 2:
- Prompt: How do I ensure that an ArrayList-based set in Java does not allow duplicate values when adding elements?

- AI Response: Check if the value already exists using .contains(), and only add the element if it is not already present.

- How I implemented the AI response: In my add(int item) method, I added a conditional check using set.contains(item). If the value was not already in the list, I added it. This ensures the structure behaves like a mathematical set.



Prompt 3:
- Prompt: How can I compare two sets of integers in Java for equality when order should not matter?

- AI Response: Create copies of both sets, sort both lists, and compare them using .equals()

- How I implemented the AI response: I created two new ArrayList copies of each set, sorted them using Collections.sort(), and then compared them using .equals(). This ensures that order does not affect equality. 



Prompt 4:
- Prompt: How do I format a Java ArrayList of integers so that it prints in ascending order like [1, 2, 3]?

- AI Response: Create a copy of the list, sort it using Collections.sort(), and return the list's string representation. 

- How I implemented the AI response: In my toString() method, I created a copy of the internal list, sorted it, and returned the result using .toString(). This guarantees the required format and ordering.
