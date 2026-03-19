package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/**
 * The TaskManager class manages a collection of Task objects.
 * It allows adding, finding, and retrieving tasks by status.
 * 
 * @author Elias
 */
public class TaskManager {
    private Map<String, Task> tasks;

    /**
     * Constructs a TaskManager with an empty task collection.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a task to the manager.
     * Throws exception if duplicate task ID exists.
     * 
     * @param task the task to add
     * @throws IllegalArgumentException if duplicate ID exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its ID.
     * 
     * @param taskId the ID to search for
     * @return the Task if found, otherwise null
     */
    public Task findTask(String taskId) {
        return tasks.getOrDefault(taskId, null);
    }

    /**
     * Returns a list of tasks that match a given status.
     * 
     * @param status the status to filter by
     * @return list of matching tasks
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }

        return result;
    }
}