Here’s a simple `README.md` file for your Guessing Game Java project:

```markdown
# Guessing Game

## Description
The Guessing Game is a simple Java console application that generates a random number between 1 and 100 and challenges the user to guess it. The program provides feedback if the guess is too high or too low and continues until the user correctly guesses the number. It also tracks and displays the number of attempts it took the user to win the game.

## Features
- Generates a random number between 1 and 100.
- Provides feedback to guide the user (too high or too low).
- Counts the number of attempts taken to guess correctly.
- Handles invalid input (non-numeric guesses).

## How to Run the Program

### Requirements
- Java Development Kit (JDK) 8 or higher.
- A command line interface (CLI) such as Command Prompt, Terminal, or PowerShell.

### Steps



1. **Compile the Java program:**
   Open a terminal or command prompt, navigate to the project directory, and run the following command to compile the Java program:
   ```bash
   javac Task_02/GuessingGame.java
   ```

2. **Run the program:**
   After compiling, you can run the program using the following command:
   ```bash
   java Task_02.GuessingGame
   ```

. **Play the game:**
   The program will prompt you to guess a number between 1 and 100. Keep entering guesses until you correctly guess the number. The program will tell you if your guess is too high or too low, and once you guess correctly, it will display how many attempts it took.

## Folder Structure
```
Task_02/
│   └── GuessingGame.java
└── README.md
```

## Example Output
```
Welcome to the Guessing Game!
I'm thinking of a number between 1 and 100. Can you guess what it is?

Enter your guess: 50
Too high! Try again.

Enter your guess: 25
Too low! Try again.

Enter your guess: 30
Congratulations! You've guessed the correct number: 30
It took you 3 attempts.
```

## Error Handling
- If the user enters a non-numeric input, the program will prompt them to enter a valid number and continue the game.

## License
This project is open-source and available under the MIT License.
```
