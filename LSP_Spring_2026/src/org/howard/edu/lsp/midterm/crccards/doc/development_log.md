Tool Used: ChatGPT

---

### Prompt 1
"Implement a Java class called Task with fields taskId, description, and status. The default status should be OPEN. Include getters, a setter that validates status (OPEN, IN_PROGRESS, COMPLETE), and a toString method formatted as 'taskId description [status]'."

### Response 1
ChatGPT provided a Java implementation of the Task class including:
- Private fields for taskId, description, and status
- A constructor initializing status to "OPEN"
- Getter methods for all fields
- A setStatus method that checks if the input is one of the valid statuses and assigns "UNKNOWN" otherwise
- A toString method returning the formatted string

### Explanation
This response helped me correctly structure the Task class and ensure that status validation followed the exact rules specified in the assignment.

---

### Prompt 2
"What is the best data structure in Java to store objects if I need to quickly find them by ID and prevent duplicates?"

### Response 2
ChatGPT recommended using a HashMap because:
- It provides fast lookup using keys (O(1) average time complexity)
- It naturally prevents duplicate keys
- It allows storing objects as values associated with unique IDs

### Explanation
This helped me choose HashMap for TaskManager, ensuring efficient task lookup and easy duplicate prevention.

---

### Prompt 3
"Write a Java TaskManager class that stores Task objects, prevents duplicate IDs, allows searching by ID, and returns a list of tasks filtered by status."

### Response 3
ChatGPT generated a TaskManager class that:
- Uses a HashMap<String, Task> to store tasks
- Throws IllegalArgumentException when adding duplicate IDs
- Implements findTask() using map lookup
- Iterates through stored tasks to filter by status and return a List<Task>

### Explanation
This response guided the implementation of TaskManager and ensured all required methods behaved correctly according to the CRC card responsibilities.

---

### Prompt 4
"How should I structure Javadoc comments for a Java class and its methods?"

### Response 4
ChatGPT explained that:
- Each class should include a description and author name
- Each public method should include a description, @param tags for parameters, and @return tags when applicable

### Explanation
This helped me properly document my code to meet the assignment’s Javadoc requirement.

---