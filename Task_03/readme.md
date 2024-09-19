Here's a `README.md` for the **Simple Contact Management System** task:

---

# Simple Contact Management System

This project implements a **Contact Management System** in Java that allows users to store, manage, and manipulate contact information. The system supports adding, viewing, editing, and deleting contacts. Contacts are stored in memory during the program's execution and can also be saved to a file for persistence.

## Features

- **Add a New Contact**: Users can add a new contact by entering a name, phone number, and email address.
- **View Contacts**: Users can view a list of all saved contacts.
- **Edit Existing Contacts**: Users can update the name, phone number, or email of existing contacts.
- **Delete Contacts**: Users can remove a contact from the list.
- **Persistent Storage**: Contact data is saved to a file (`contacts.dat`) so that the list can be loaded on subsequent runs.

## Getting Started

### Prerequisites

To run this project, ensure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)

### Running the Program

1. Clone or download the project files.
2. Compile the Java program:
   ```bash
   javac ContactManagementSystem.java
   ```
3. Run the program:
   ```bash
   java ContactManagementSystem
   ```

### Usage

When you run the program, you'll be presented with the following options:

```
Contact Management System:
1. Add Contact
2. View Contacts
3. Edit Contact
4. Delete Contact
5. Exit
Enter your choice: 
```

- **Add Contact**: Enter the name, phone number, and email of the contact.
- **View Contacts**: Displays a list of all contacts.
- **Edit Contact**: Choose a contact from the list and update their information.
- **Delete Contact**: Select a contact to delete from the list.
- **Exit**: Closes the program.

### Data Persistence

The program saves the contact list to a file (`contacts.dat`) in the working directory. This allows the program to load the previously saved contacts the next time it is run.

### Example Output

```
Contact Management System:
1. Add Contact
2. View Contacts
3. Edit Contact
4. Delete Contact
5. Exit
Enter your choice: 1
Enter name: John Doe
Enter phone number: 123-456-7890
Enter email: john@example.com
Contact added successfully!

Contact Management System:
1. Add Contact
2. View Contacts
3. Edit Contact
4. Delete Contact
5. Exit
Enter your choice: 2
1. Name: John Doe, Phone: 123-456-7890, Email: john@example.com
```

## File Structure

- `Contact.java`: The `Contact` class defines the contact object, which contains a name, phone number, and email.
- `ContactManagementSystem.java`: The main program file that manages contact operations (add, view, edit, delete) and handles data persistence.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
