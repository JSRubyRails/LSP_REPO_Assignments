Heuristic 1:

- Name: Distribute system intelligence horizontally as uniformly as possible 

- Explanation: When intelligence is concentrated in one or two classes, the system becomes fragile and hard to maintain. Spreading responsibility evenly means changes to one area are less likely to ripple across the whole system, improving both readability and maintainability.




Heuristic 2:

- Name: Do not create god classes/objects in your system

- Explanation: A god class knows too much or does too much, violating encapsulation and making the system tightly coupled to a single class. Eliminating god classes forces responsibility to be distributed properly, making each class easier to understand and modify independently.





Heuristic 3:

- Name: All data should be hidden within its class

- Explanation: Keeping data private forces interaction through well-defined methods, which protects internal state from unexpected external changes. This improves maintainability because the internal implementation can be changed freely without breaking code that depends on the class.