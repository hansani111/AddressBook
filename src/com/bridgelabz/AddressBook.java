package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    /* Taking Array list to save the contacts */
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

        addressbook.add(contact);		//storing the contact (details) in arraylist

        System.out.println("Contact added successfully.\n");
        System.out.println(addressbook);
    }
}