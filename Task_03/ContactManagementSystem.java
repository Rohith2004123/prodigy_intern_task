import java.io.*;
import java.util.*;

class Contact implements Serializable {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManagementSystem {
    private static final String CONTACTS_FILE = "contacts.dat";
    private List<Contact> contacts = new ArrayList<>();

    // Load contacts from the file
    @SuppressWarnings("unchecked")
    public ContactManagementSystem() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CONTACTS_FILE))) {
            contacts = (List<Contact>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous contacts found. Starting a new contact list.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }

    // Save contacts to the file
    private void saveContacts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CONTACTS_FILE))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    // Add a new contact
    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, phone, email));
        saveContacts();
        System.out.println("Contact added successfully!");
    }

    // View all contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    // Edit a contact
    public void editContact() {
        Scanner scanner = new Scanner(System.in);
        viewContacts();
        System.out.print("Enter the contact number to edit: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < contacts.size()) {
            scanner.nextLine(); // Clear buffer
            System.out.print("Enter new name (leave blank to keep unchanged): ");
            String name = scanner.nextLine();
            System.out.print("Enter new phone (leave blank to keep unchanged): ");
            String phone = scanner.nextLine();
            System.out.print("Enter new email (leave blank to keep unchanged): ");
            String email = scanner.nextLine();

            Contact contact = contacts.get(index);
            if (!name.isBlank()) contact.setName(name);
            if (!phone.isBlank()) contact.setPhone(phone);
            if (!email.isBlank()) contact.setEmail(email);

            saveContacts();
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    // Delete a contact
    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        viewContacts();
        System.out.print("Enter the contact number to delete: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            saveContacts();
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    // Display menu options
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nContact Management System:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> editContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        ContactManagementSystem cms = new ContactManagementSystem();
        cms.menu();
    }
}
