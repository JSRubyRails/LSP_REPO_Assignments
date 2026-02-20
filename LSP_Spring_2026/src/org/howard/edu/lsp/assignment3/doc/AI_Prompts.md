Prompt 1:
- Prompt: How can I redesign a procedural Java ETL pipeline to be more object-oriented?
- AI Response: The pipeline should be decomposed into separate classes such as Product, CsvReader, CsvWriter, and a controller class to coordinate execution. Each class should have a single responsibility.
- How I Implemented The AI Response: I adopted the suggestion to separate responsibilities into multiple classes. I created Product, CsvReader, CsvWriter, and ETLPipeline classes to improve modularity and follow the Single Responsibility Principle.


Prompt 2:
- Prompt: Where should I place the transformation logic in an object-oriented design?
- AI Response: Transformation logic can either be placed inside the Product class or in a separate Transformer class to separate business rules from the data model.
- How I Implemented the AI Response: I chose to implement a separate ProductTransformer class so that business logic would not be tightly coupled with the Product data model. This makes the system easier to extend if new transformation rules are added later.


Prompt 3:
- How can I ensure Assignment 3 produces the same output as Assignment 2?
- AI Response: Delete the existing output file and run the new implementation to regenerate it, then compare both outputs using a diff tool to confirm they are identical.
- How I Implemented the AI Response: Instead of using what AI recommended, I changed the source output for Assignment 3 so the output for Assignment 2 and Assignment 3 would be on different csv files, and I compared their outputs. 

