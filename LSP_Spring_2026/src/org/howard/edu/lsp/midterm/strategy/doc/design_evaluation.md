The current implementation of the PriceCalculator class has several design issues that make it difficult to maintain and extend.

First, the class violates the Open/Closed Principle. Every time a new customer type or pricing rule is introduced, the calculatePrice method must be modified. This requires changing existing code rather than extending behavior, increasing the risk of introducing bugs.

Second, the use of multiple if statements creates poor scalability. As more customer types are added, the method will grow longer and harder to read, making the system more complex and less maintainable.

Third, the class lacks abstraction and flexibility. The pricing logic is tightly coupled to the PriceCalculator class, meaning all pricing strategies are embedded in one place instead of being separated into reusable components.

Additionally, the design does not follow the principle of single responsibility. The class is responsible for handling multiple pricing strategies instead of delegating each pricing behavior to a separate class.

Overall, the design leads to tight coupling, low cohesion, and poor extensibility. A better approach would be to use the Strategy Pattern, where each pricing strategy is encapsulated in its own class, making the system easier to extend and maintain.