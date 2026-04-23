AI Tools Used: Claude

Prompts Used:
1. "What are the shared resources in this RequestManager class and what concurrency problems exist?"
2. "Is synchronizing only getNextId() enough to fix the race condition?"
3. "Show me how to use AtomicInteger and CopyOnWriteArrayList to make addRequest() thread-safe."

How AI Helped:
AI helped identify which shared resources were at risk and why synchronizing only one method
was insufficient. It also demonstrated the java.util.concurrent alternative with a concrete
code snippet.

Reflection:
I learned that thread safety requires protecting the entire compound operation, not just
individual method calls. Atomic classes can often replace synchronized blocks more cleanly.