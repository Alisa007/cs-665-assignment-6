| CS-665       | Software Design & Patterns |
| ------------ | -------------------------- |
| Name         | ALISA BELOUSOVA            |
| Date         | MM/DD/2023                 |
| Course       | Fall                       |
| Assignment # |                            |

# Assignment Overview

Please add a paragraph or two overviewing the objectives of the assignment.

# GitHub Repository Link:

https://github.com/alisa007/cs-665-assignment-{ASSIGNMENT_NUMBER}

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
