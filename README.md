| CS-665       | Software Design & Patterns |
| ------------ | -------------------------- |
| Name         | ALISA BELOUSOVA            |
| Date         | 09/07/2023                 |
| Course       | Fall                       |
| Assignment # | 1                          |

# Assignment Overview

The goal of the project is to develop a fully automated beverage vending machine. Implementation manages brewing process of various coffee and tea beverages, including:

* Espresso
* Americano
* Latte Macchiato
* Black Tea
* Green Tea
* Yellow Tea

Vending machine should have the capability to add condiments such as milk and sugar to the hot beverage. Users should be able to select between 0 and 3 units of either milk or sugar to add to their drink.

## Assumptions

1. Vending machine accepts only electronic payment. Reason: simplicity, cash processing is complicated
2. Coffee is brewed from capsules or something similar so we don't have to mix different ingridients ourself, only add hot water. Reason: vending machine should be able to consistently produce high-quality beverages that meet the expectations of customers. It's difficult to control quality of coffee made from the fresh ingridients
3. Can't order multiple items in the same order. Reason: it's rare case that user will decide to make more then couple drinks, simplifies process
4. Need inventory for both drinks and condiments, everything is counted in items. Reason: it's easier to ensure portions are consistent when individually packaged
5. Condiments are same for all drinks, condiments quantity can be different based on condiment but not on drink it's used for. Reason: better UX, users learn the limit and can use the knowledge for all drinks, condiments in the requirements (milk and sugar) ) are also universal
6. There's no admin and servicing functionality such as reset, see statistics, insert more drink and condiment capsules and so on. Reason: there's nothing about admin interface in requirements so seems to be out of scope of the project
7. Condiments are free. Reason: There's no reason to limit paid condiments

# GitHub Repository Link:

https://github.com/alisa007/cs-665-assignment-1

# Implementation Description

For each assignment, please answer the following:

- Explain the level of flexibility in your implementation, including how new object types can
  be easily added or removed in the future.
- Discuss the simplicity and understandability of your implementation, ensuring that it is
  easy for others to read and maintain.
- Describe how you have avoided duplicated code and why it is important.
- If applicable, mention any design patterns you have used and explain why they were
  chosen.

## Compile

Type on the command line:

```bash
mvn clean compile
```

## JUnit Tests

To run, use the following command:

```bash
mvn clean test
```

## Spotbugs

Use the following command:

```bash
mvn spotbugs:gui 
```

## Checkstyle

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`
