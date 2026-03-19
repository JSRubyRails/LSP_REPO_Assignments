## Class: Order
**Responsibilities:**
- Store order data (customer name, email, item, price)
- Provide access to order details

**Collaborators:**
- OrderProcessor



## Class: OrderProcessor
**Responsibilities:**
- Coordinate the order processing workflow
- Invoke services for tax calculation, discount, persistence, and notification

**Collaborators:**
- Order
- TaxCalculator
- DiscountService
- ReceiptPrinter
- OrderRepository
- EmailService
- LoggerService



## Class: TaxCalculator
**Responsibilities:**
- Calculate tax based on order price

**Collaborators:**
- Order



## Class: DiscountService
**Responsibilities:**
- Apply discount rules to the total price

**Collaborators:**
- Order



## Class: ReceiptPrinter
**Responsibilities:**
- Format and print order receipt

**Collaborators:**
- Order



## Class: OrderRepository
**Responsibilities:**
- Save order data to storage (file or database)

**Collaborators:**
- Order



## Class: EmailService
**Responsibilities:**
- Send confirmation email to customer

**Collaborators:**
- Order



## Class: LoggerService
**Responsibilities:**
- Log order processing activity

**Collaborators:**
- Order