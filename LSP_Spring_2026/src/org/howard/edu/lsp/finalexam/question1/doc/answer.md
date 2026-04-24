Part 1:

- Shared Resource #1: nextId is a shared resource because it's the integer count that is used to generate request IDs

- Shared Resource #2: requests is a shared resource because it's an ArrayList that stores all string requests 

- Concurrency Problem: A race condition could occur if two threads call addRequest() at the same time. This would cause both threads to read the same value of nextID before either thread increments it, which could result in duplicate IDs.

- Why addRequest() is unsafe: addRequest() performs a check-then-act sequence (getNextId() then requests.add()), which is not atomic. This could cause another thread to occur between these steps and would cause duplicate IDs or lost/corrupted entities. 





Part 2:
-Fix A: Fix A is not correct. Even though the fix protects the ID counter, requests.add() in addRequest() is still unsynchronized, and two threads could still concurrently modify the ArrayList 

- Fix B: Fix B is correct. Since addRequest() is the only method that calls both getNextId() and requests.add(), synchronizing addRequest() makes the entire operation atomic and only one thread can execute at a time

- Fix C: Fix C is incorrect. This fix only protects the retrieval of the list and not the writing, and the race condition during addRequest() is not addressed  





Part 3:

- Based on Arthur Riel's heuristics, getNextId() should not be public. According to Riel's heuristics, a class should only expose what is necessary for its public interface, and getNextID() is an internal mechanism used only by addRequest(). If getNextID is made public, it would expose its internal state management, break encapsulation, and allows external callers to consume IDs without adding requests, which would corrupt the system's integrity.




Part 4:

- Description: Instead of relying on the synchronized keyword to manage concurrency, an alternative approach would be using classes from java.util.concurrent (AtomicInteger for the counter and CopyonWriteArrayList for the list), which are both thread-by-safe design. Using "AtomicInteger.getAndIncrement()" would perform the read-and-increment as a single atomic hardware operation, which would the eliminate the race condition on nextId. 

- Code Snippet:
	
	import java.util.concurrent.CopyOnWriteArrayList;
	import java.util.concurrent.atomic.AtomicInteger; 
	
	public class RequestManager { 
		private Atomic Integer nextId = new AtomicInteger(1);
		private List <String> requests = new CopyOnWriteArrayList<>();
	
		public void addRequest(String studentName) { 
			int id = nextId.getAndIncrement(); 
			requests.add("Request-" + id + " from " + studentName);
		}  
	}