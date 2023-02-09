package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    static Scanner sc = new Scanner(System.in);
    /* Taking arraylist to save the contacts */
    ArrayList<Contact> allContacts = new ArrayList<>();

    /* Creating contact with this method */
    void addContactDetails() {
        System.out.println("Creating new contact:- \n");
        String firstName = null;
        String lastName = null;

        boolean flag = true;
        while (flag) {
            System.out.println("Enter FirstName");
            firstName = sc.next();

            System.out.println("Enter LastName");
            lastName = sc.next();

            flag = checkContactExist(firstName, lastName);
        }

        System.out.println("Enter address");
        String address = sc.next();

        System.out.println("Enter City");
        String city = sc.next();

        System.out.println("Enter State");
        String state = sc.next();

        System.out.println("Enter zip");
        String zip = sc.next();

        System.out.println("Enter Phone No");
        String phoneNumber = sc.next();

        System.out.println("Enter email");
        String email = sc.next();

        allContacts.add(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));

        System.out.println("Contact created successfully. Total contact present in the current adressbook = "
                + allContacts.size());
    }

    /* Checking if given First name & Last name is already present in the arraylist or not */
    boolean checkContactExist(String firstName, String lastName) {
        for (Contact contact : allContacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                System.out.println(
                        "Another contact is already present with the same Name. So please try with different name.");
                return true;
            }
        }
        return false;
    }

    /* edit the contact */
    void editContactDetails() {
        if (allContacts.size() == 0) {
            System.out.println(
                    "There is no contact present in current adressbook. Please add atleast one contact first to edit.");
            addContactDetails();
            return;
        }
        System.out.println("Enter the Firstname of the contact which you want to edit :  ");
        String name = sc.next();
        boolean flag1 = false;

        for (int person = 0; person < allContacts.size(); person++) { // for all the contacts in the arraylist
            if (allContacts.get(person).getFirstName().equals(name)) {
                flag1 = true;
                System.out.println("Please select any one option(1-8) to change the contact details" + "\n"
                        + "PRESS 1 to edit FirstName" + "\n" + "PRESS 2 to edit Lastname" + "\n"
                        + "PRESS 3 to edit Address" + "\n" + "PRESS 4 to edit City" + "\n" + "PRESS 5 to edit State"
                        + "\n" + "PRESS 6 to edit zip" + "\n" + "PRESS 7 to edit PhoneNumber" + "\n"
                        + "PRESS 8 to edit Email");
                int choiceEdit = sc.nextInt();

                switch (choiceEdit) {
                    case 1:
                        System.out.println("Enter new FirstName : ");
                        allContacts.get(person).setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter new Lastname : ");
                        allContacts.get(person).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter new Address : ");
                        allContacts.get(person).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter new City : ");
                        allContacts.get(person).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter new State :  ");
                        allContacts.get(person).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter new ZIP : ");
                        allContacts.get(person).setZip(sc.next());
                        break;
                    case 7:
                        System.out.println("Enter new PhoneNumber : ");
                        allContacts.get(person).setPhoneNumber(sc.next());
                        break;
                    case 8:
                        System.out.println("Enter new Email : ");
                        allContacts.get(person).setEmail(sc.next());
                        break;
                    default:
                        System.out.println("Wrong choice!!!! Please try again later. ");
                        return;
                }
                System.out.println("Details of the contact after edited: ");
                System.out.println(allContacts.get(person));
                return;
            }
        }
        if (flag1 == false)
            System.out.println("Sorry!!! There is no such contact present. Please check the firstname and try again.");
    }

    /* Delete a contact */
    void deleteContact() {
        if (allContacts.size() == 0) {
            System.out.println(
                    "There is no contact present in adressbook. Please add atleast one contact first to delete.");
            addContactDetails();
            return;
        }
        System.out.println("Enter the firstname of the contact which you want to delete : ");
        String name = sc.next();
        boolean flag1 = false;
        for (int person = 0; person < allContacts.size(); person++) {
            if (allContacts.get(person).getFirstName().equals(name)) {
                flag1 = true;
                allContacts.remove(person);
                System.out.println("Contact deleted successfully. Total contact present in the current adressbook = "
                        + allContacts.size());
                return;
            }
        }
        if (flag1 == false)
            System.out.println("Sorry!!! There is no such contact present. Please check the firstname and try again.");
    }

    /* Showing details of a particular contact */
    public void showContact() {
        System.out.println("Enter the firstname of the contact to see the details : ");
        String name = sc.next();
        for (int i = 0; i < allContacts.size(); i++) {
            if (allContacts.get(i).getFirstName().equals(name)) {
                System.out.println(allContacts.get(i));
                return;
            }
        }
        System.out.println("Contact NOT FOUND!!! Check the First name and try again.");

    }

    @Override
    public String toString() {
        return "All contacts:-\n[" + allContacts + "]";
    }
}