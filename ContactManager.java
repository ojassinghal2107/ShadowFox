
    import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManager {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Contact Manager ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> updateContact();
                case 4 -> deleteContact();
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added.");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    static void updateContact() {
        viewContacts();
        if (contacts.isEmpty()) return;
        System.out.print("Enter contact number to update: ");
        int index = sc.nextInt() - 1;
        sc.nextLine(); // consume newline
        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter new email: ");
        String email = sc.nextLine();
        contacts.set(index, new Contact(name, phone, email));
        System.out.println("Contact updated.");
    }

    static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) return;
        System.out.print("Enter contact number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine(); // consume newline
        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }
        contacts.remove(index);
        System.out.println("Contact deleted.");
    }
}

