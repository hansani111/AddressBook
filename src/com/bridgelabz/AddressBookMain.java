package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
    static Scanner sc = new Scanner(System.in);

    static Map<String, AddressBook> allAddressbook = new HashMap<>();

    private static Map<String, ArrayList<Contact>> cityMap = new HashMap<>();
    private static Map<String, ArrayList<Contact>> stateMap = new HashMap<>();

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("\n" + "***** Main Menu *****");
            System.out.println("1.Add New AddressBook" + "     " + "2.Show AddressBook details");
            System.out.println("3.Delete Addressbook" + "      " + " 4.Edit Addressbook");
            System.out.println("5. Sort by City" + "           " + "6. Sort by state");
            System.out.println("0. Exit");

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
                case 5:
                    sortByCity();
                    break;
                case 6:
                    sortByState();
                    break;
                case 0:
                    flag = false;
                    System.out.println("Successfully exited");
                    break;

                default:
                    System.out.println("INVALID INPUT !!!!!");
                    break;
            }
        }
    }

    private static void sortByState() {
        allAddressbook.forEach((name, adBook) -> adBook.allContacts.stream().forEach(contact -> {
            if (stateMap.containsKey(contact.getState())) {
                stateMap.get(contact.getState()).add(contact);
            } else {
                ArrayList<Contact> state = new ArrayList<>();
                state.add(contact);
                stateMap.put(contact.getState(), state);
            }
        }));
        stateMap.forEach((state, contacts) -> System.out.println(state + " :- " + "\n" + contacts + "\n"
                + "Total contacts present in " + state + " :- " + contacts.size()));

    }

    private static void sortByCity() {
        allAddressbook.forEach((name, adBook) -> adBook.allContacts.stream().forEach(contact -> {
            if (cityMap.containsKey(contact.getCity())) {
                cityMap.get(contact.getCity()).add(contact);
            } else {
                ArrayList<Contact> city = new ArrayList<>();
                city.add(contact);
                cityMap.put(contact.getCity(), city);
            }
        }));
        cityMap.forEach((city, contacts) -> System.out.println(city + " :- " + "\n" + contacts + "\n"
                + "Total contacts present in " + city + " :- " + contacts.size()));

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
                System.out.println("1.Add contact" + "         " + "2.Edit Contact");
                System.out.println("3.Delete contact" + "      " + "4. Show details of a particular contact");
                System.out.println("5. Show all contacts of '" + adressBookName + "'");
                System.out.println("6. Display by city" + "     " + "7. Display by state");
                System.out.println("0. Exit");

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
                    case 6:
                        System.out.println("Enter the name of the city to see all the contacts of that city : ");
                        String cityName = sc.next();
                        List<Contact> listForCity = allAddressbook.get(adressBookName).allContacts.stream().distinct()
                                .collect(Collectors.toList());

                        System.out.println(listForCity);

                        break;
                    case 7:
                        System.out.println("Enter the name of the State to see all the contacts of that city : ");
                        String stateName = sc.next();
                        System.out.println("All the contacts presents in the State " + stateName + " : \n");
                        System.out.println(allAddressbook.get(adressBookName).allContacts.stream()
                                .filter(t -> t.getState().equals(stateName)).collect(Collectors.toList()));
                        break;
                    case 0:
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
        if (allAddressbook.containsKey(adressbookName)) {
            System.out.println("Can't take this name. please try with any other unique name.");
            System.out.println("All the present addressbooks list is :-  " + allAddressbook.keySet());
            return;
        } else {
            allAddressbook.put(adressbookName, new AddressBook());
        }

    }

}