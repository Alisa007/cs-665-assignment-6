# Vending machine

| CS-665       | Software Design & Patterns |
| ------------ | -------------------------- |
| Name         | ALISA BELOUSOVA            |
| Date         | 12/5/2023                  |
| Course       | Fall                       |
| Assignment # | 6 (based on 1)             |

## UPDATE: Refactoring

### **1. Divergent Change**

The original code required changes in multiple places (like separate handling for `Drink` and `Condiment`) when modifying inventory-related behavior. Using a unified approach with `InventoryItem`, I've made the system more cohesive, addressing the divergent change smell. Now, changes in inventory behavior can be managed more centrally.

### **2. Inappropriate Intimacy**

The `VendingMachine` was closely tied to specific classes (`Drink` and `Condiment`), creating a high degree of coupling. By abstracting these into a general `InventoryItem`, I've reduced the coupling, addressing the inappropriate intimacy smell.

### 3. Limited Use of Encapsulation

Fields like `count` and maxPerOrder in `InventoryItem` were public, which broke encapsulation. I've made fields private.

### 4. Varargs in Constructor

Usage of varargs for `maxPerOrder` in the `InventoryItem` constructor was confusing (source: https://rules.sonarsource.com/java/RSPEC-5669/). Provided overloaded constructors for different initializations.

## Assignment Overview

The goal of the project is to develop a fully automated beverage vending machine. Implementation manages brewing process of various coffee and tea beverages, including:

* Espresso
* Americano
* Latte Macchiato
* Black Tea
* Green Tea
* Yellow Tea

Vending machine should have the capability to add condiments such as milk and sugar to the hot beverage. Users should be able to select between 0 and 3 units of either milk or sugar to add to their drink.

## Assumptions

1. Vending machine accepts only electronic payment.
2. Coffee is brewed from capsules. Need inventory for both drinks and condiments.
3. Can't order multiple items in the same order.
4. Condiments are same for all drinks, condiments quantity can be different based on condiment but not on drink it's used for.
5. There's no admin and servicing functionality such as reset, statistics, insert more capsules and so on.
6. Condiments are free.

## GitHub Repository Link:

https://github.com/alisa007/cs-665-assignment-1

## Implementation Description

### **Flexibility:**

The implementation is designed with flexibility in mind. It uses classes and enumerations to encapsulate different components of the vending machine system. For example, `InventoryItem` is a generic class, and specialized items such as `Drink` and `Condiment` extend it, making it easier to add new types of inventory items in the future by extending `InventoryItem`. The use of a `HashMap` for `drinks` and `condiments` within the `VendingMachine` class allows for dynamic addition and removal of items. New items can be added by simply extending the `InventoryItem` class and adding instances to the respective HashMap. The `VendingMachineState` and `VendingMachineError` enumerations encapsulate the different states and error types, making it straightforward to add or remove states or error types as needed.

### **Simplicity and Understandability:**

The code is structured in a modular fashion, with each class having a specific responsibility, following the Single Responsibility Principle. This makes the codebase easier to understand and maintain. Descriptive variable and method names are used to improve readability and understanding of the code. Javadoc comments are extensively used to provide documentation and context, which aids in understanding the purpose and usage of classes, methods, and attributes.

### **Avoidance of Duplicated Code:**

Duplicated code is minimized by using methods and inheritance. For example, common functionalities and attributes of inventory items are placed in the `InventoryItem` class, and specialized behaviors are implemented in the derived classes. The `remove()` and `isAvailable()` methods in `InventoryItem` are reused by all objects that extend this class, avoiding code duplication.

### **Design Patterns:**

- **State Pattern:** The `VendingMachineState` enumeration and the state attribute in the `VendingMachine` class indicate the use of the State Pattern. This pattern allows the `VendingMachine` object to alter its behavior when its internal state changes, making it appear as if the object changed its class.
- **Factory Pattern:** While not implemented in the code, the Factory Pattern could be easily added if required to instantiate different types of `InventoryItem` or other objects. This would further decouple the code and make adding new item types even more straightforward.

## Commands

### Compile

Type on the command line:

```bash
mvn clean compile
```

### JUnit Tests

To run, use the following command:

```bash
mvn clean test
```

### Spotbugs

Use the following command:

```bash
mvn spotbugs:gui 
```

### Checkstyle

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`
