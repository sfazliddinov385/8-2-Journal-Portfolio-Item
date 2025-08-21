# CS 320 Software Testing Portfolio

## Project Overview
This repository contains my work from CS 320 Software Test Automation & QA class. It shows how I tested a mobile app to make sure it works correctly.

## Repository Contents

### Project One: Contact Service
- `Contact.java` - Code for storing contact information
- `ContactService.java` - Code for managing contacts (add, delete, update)
- `ContactTest.java` - Tests for Contact class
- `ContactServiceTest.java` - Tests for ContactService class

### Project Two: Testing Summary & Reflections
- `ReflectionProjectTwo.docx` - My report about testing strategies and what I learned

## Test Coverage Results
- **Overall Coverage:** 92%
- **Total Test Cases:** 121
- All major functions tested with both good and bad inputs

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

I make sure my code works and is secure by testing everything thoroughly. I write tests that check what happens when users do things correctly and when they make mistakes. For example, if a phone number should be 10 digits, I test with 9 digits, 10 digits, 11 digits, letters, and empty fields to make sure the program catches all the wrong inputs.

For security, I check all user input before using it. The program won't accept letters in phone number fields or let users create IDs that are too long. I also make sure that once something important like an ID is created, it can't be changed by accident. Every test runs separately so if one breaks, it doesn't affect the others.

### How do I interpret user needs and incorporate them into a program?

I take what users ask for and turn it into specific rules the program follows. When the client said "contact IDs must be unique and less than 10 characters," I made the program check both things. I also think about mistakes users might make - like trying to schedule an appointment yesterday or typing their phone number with dashes.

I test the program the way real people would use it. This means checking what happens when someone forgets to fill in a field, types too much, or enters the wrong kind of information. The program needs to help users understand what went wrong with clear error messages, not just crash or do something unexpected.

### How do I approach designing software?

I keep my code organized and simple. Each piece does one job well. The Contact class handles contact information, the ContactService manages all the contacts, and each has its own tests. This makes it easy to find and fix problems.

I write code that's easy to test and easy to understand. Instead of copying the same code over and over, I create helper functions that can be reused. I give everything clear names - a test called "testAddDuplicateContactId" tells you exactly what it's checking without needing extra explanation.

I always plan for things to go wrong. Every part of the program checks its inputs and handles errors properly. If someone tries to delete a contact that doesn't exist, the program tells them clearly instead of crashing. With 121 tests covering 92% of my code, I can make changes confidently knowing the tests will catch any problems I create.

## Technologies Used
- **Language:** Java
- **Testing Framework:** JUnit 5
- **IDE:** IntelliJ IDEA

## Author
Sarvarbek Fazliddinov  
CS 320 - Software Test Automation & QA  
Date: August 2025
