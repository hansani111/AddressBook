package com.bridgelabz;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

    static Scanner sc = new Scanner(System.in);

    static HashMap<String, AddressBook> allAddressbook = new HashMap<>();

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("**** Main Menu****");
            System.out.println("\n1.Add New AddressBook");
            System.out.println("2.Show AddressBook details");
            System.out.println("3.Delete Addressbook");
            System.out.println("4.Edit Addressbook");
            System.out.println("9. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addAdressbook();
                    break;
                case 2:
                    printAdressbook();
                    break;
                case 3:
                    deleteAddressbook();
                    break;
                case 4:
                    editAdressbook();
                    break;
                case 9:
                    flag = false;
                    System.out.println("Successfully exited");
                    break;

                default:
                    System.out.println("INVALID INPUT !!!!!");
                    break;
            }
        }
    }

    private static void editAdressbook() {
        if (allAddressbook.size() == 0) {
            System.out.println("There is no AdressBook present till now. Please add an Adressbook first.");
            return;
        }
        System.out.println("Enter the name of the AdressBook which you want to edit : ");
        String adressBookName = sc.next();
        if (allAddressbook.containsKey(adressBookName)) {
            boolean flag = true;
            while (flag) {
                System.out.println("\n" + "***** AddressBook Menu *****");
                System.out.println("1.Add contact");
                System.out.println("2.Edit Contact");
                System.out.println("3.Delete contact");
                System.out.println("4. Show details of a particular contact");
                System.out.println("5. Show all contacts of " + adressBookName);
                System.out.println("9. Exit");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("How many Contacts do you want to add : ");
                        int numOfContacts = sc.nextInt();
                        if (numOfContacts <= 0)
                            System.out.println("INVALID INPUT !!!");
                        else
                            for (int i = 0; i < numOfContacts; i++) {
                                allAddressbook.get(adressBookName).addContactDetails();
                            }
                        break;

                    case 2:
                        allAddressbook.get(adressBookName).editContactDetails();
                        break;

                    case 3:
                        allAddressbook.get(adressBookName).deleteContact();
                        break;
                    case 4:
                        allAddressbook.get(adressBookName).showContact();
                        break;
                    case 5:
                        System.out.println(allAddressbook.get(adressBookName));
                        break;
                    case 9:
                        flag = false;
                        System.out.println("Successfully exited from " + adressBookName);
                        break;

                    default:
                        System.out.println("INVALID INPUT !!!!");
                        break;
                }
            }

        } else {
            System.out.println("SORRY!!! Adressbook NOT FOUND with the name " + adressBookName);
            System.out.println("Currently present AdressBooks are :  " + allAddressbook.keySet());
        }
    }

    private static void deleteAddressbook() {
        if (allAddressbook.size() == 0) {
            System.out.println("There is no AdressBook present till now. Please add an Adressbook first.");
            return;
        }

        System.out.println("Enter the name of the Adressbook you want to delete : ");
        String adressbookName = sc.next();

        if (allAddressbook.containsKey(adressbookName)) {
            allAddressbook.remove(adressbookName);
            System.out.println("AdressBook Deleted Successfully!!!");
        } else
            System.out.println("Adressbook NOT FOUND with the name " + adressbookName);
        System.out.println("Currently present AdressBooks are :  " + allAddressbook.keySet());

    }

    private static void printAdressbook() {
        System.out.println(allAddressbook);
    }

    private static void addAdressbook() {
        System.out.println("Enter the name of the Adressbook:");
        String adressbookName = sc.next();
        allAddressbook.put(adressbookName, new AddressBook());
    }
}