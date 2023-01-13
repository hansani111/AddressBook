package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {

        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            AddressBook adresssbook1 = new AddressBook();
            boolean flag = true;

            do {
                System.out.println("PRESS 1 to Add Contact");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        adresssbook1.addContactDetails();
                        break;
                    default:
                        System.out.println("Invalid Input!!!! Please try again.");
                        break;
                }
                System.out.println("\n*** Total Contacts present : " + adresssbook1.addressbook.size() + " ***");
                System.out.println("\n");
            } while (flag);
        }
}