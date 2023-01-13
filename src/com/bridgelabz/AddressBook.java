package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    /* Taking array list to save the contacts */
    ArrayList<Contact> addressbook = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    /*Creating contact with this method */
    void addContactDetails() {
        Contact contact = new Contact();

        System.out.println("Enter Firstname : ");
        contact.setFirstName(sc.next());

        System.out.println("Enter Lastname : ");
        contact.setLastName(sc.next());

        System.out.println("Enter Address : ");
        contact.setAddress(sc.next());

        System.out.println("Enter City : ");
        contact.setCity(sc.next());

        System.out.println("Enter State : ");
        contact.setState(sc.next());

        System.out.println("Enter ZIP : ");
        contact.setZip(sc.next());

        System.out.println("Enter PhoneNumber : ");
        contact.setPhoneNumber(sc.next());

        System.out.println("Enter Email : ");
        contact.setEmail(sc.next());

        //storing the contact (details) in array list
        addressbook.add(contact);

        System.out.println("Contact added successfully.\n");
        System.out.println(addressbook);
    }

    /* edit the contact */
    void editContactDetails() {
        if(addressbook.size() == 0) {
            System.out.println("There is no contact present in adressbook. Please add atleast one contact first to edit.");
            addContactDetails();
            return;
        }
        System.out.println("Enter the Firstname of the contact which you want to edit :  ");
        String name = sc.next();
        boolean flag1 = false;

        //for all the contacts in the array list
        for(int person = 0; person < addressbook.size(); person++) {
            if(addressbook.get(person).getFirstName().equals(name)) {
                flag1 = true;
                System.out.println("Please select any one option(1-8) to change the contact details" + "\n" + "PRESS 1 to edit FirstName" + "\n"
                        + "PRESS 2 to edit Lastname" + "\n" +"PRESS 3 to edit Address" + "\n" + "PRESS 4 to edit City" + "\n"
                        + "PRESS 5 to edit State" + "\n" + "PRESS 6 to edit zip" + "\n" + "PRESS 7 to edit PhoneNumber" + "\n"
                        + "PRESS 8 to edit Email");
                int choiceEdit = sc.nextInt();

                switch (choiceEdit) {
                    case 1:
                        System.out.println("Enter new FirstName : ");
                        addressbook.get(person).setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter new Lastname : ");
                        addressbook.get(person).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter new Address : ");
                        addressbook.get(person).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter new City : ");
                        addressbook.get(person).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter new State :  ");
                        addressbook.get(person).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter new ZIP : ");
                        addressbook.get(person).setZip(sc.next());
                        break;
                    case 7:
                        System.out.println("Enter new PhoneNumber : ");
                        addressbook.get(person).setPhoneNumber(sc.next());
                        break;
                    case 8:
                        System.out.println("Enter new Email : ");
                        addressbook.get(person).setEmail(sc.next());
                        break;
                    default:
                        System.out.println("Wrong choice!!!! Please try again later. ");
                        return;
                }
                System.out.println("Details of the contact after edited: ");
                System.out.println(addressbook.get(person));
                return;
            }
        }
        if (flag1 == false)
            System.out.println("Sorry!!! There is no such contact present. Please check the firstname and try again.");
    }

    /* Delete a contact*/
    void deleteContact() {
        if(addressbook.size() == 0) {
            System.out.println("There is no contact present in adressbook. Please add atleast one contact first to delete.");
            addContactDetails();
            return;
        }
        System.out.println("Enter the firstname of the contact which you want to delete : ");
        String name = sc.next();
        boolean flag1 = false;
        for(int person = 0; person < addressbook.size(); person++) {
            if(addressbook.get(person).getFirstName().equals(name)) {
                flag1 = true;
                addressbook.remove(person);
                System.out.println("Contact deleted.");
                return;
            }
        }
        if (flag1 == false)
            System.out.println("Sorry!!! There is no such contact present. Please check the firstname and try again.");
    }

    /* Add Multiple contacts */
    void addMultipleContacts() {
        System.out.println("How many contacts do you want to add now : ");
        int number = sc.nextInt();
        if(number <= 0) {
            System.out.println("Invalid Input!!!");
        }else {
            for(int i = 1; i <= number; i++) {
                addContactDetails();
                System.out.println("( " + i + " Contact added. )");
            }
        }
    }

}