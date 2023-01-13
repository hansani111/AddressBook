package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AddressBook addressbook1 = new AddressBook();
        boolean flag = true;

        do {
            System.out.println("PRESS 1 to Add Contact      ||       PRESS 2 to Edit Contact       ||      PRESS 3 to DELETE Contact");
            System.out.println("PRESS 4 to SEE all contacts ||   PRESS 5 to add multiple Contacts");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addressbook1.addContactDetails();
                    break;
                case 2:
                    addressbook1.editContactDetails();
                    break;
                case 3:
                    addressbook1.deleteContact();
                    break;
                case 4:
                    System.out.println(addressbook1.addressbook);
                    break;
                case 5:
                    addressbook1.addMultipleContacts();
                    break;
                default:
                    System.out.println("Invalid Input!!!! Please try again.");
                    break;
            }
            System.out.println("\n*** Total Contacts present : " + addressbook1.addressbook.size() + " ***");
            System.out.println("\n");
        } while (flag);
    }
}