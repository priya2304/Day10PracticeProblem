import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplePerson {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Person> personList = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("Welcome to address book system program");
        boolean isExit = false;
        do {
            System.out.println("\n\t\tAddress Book System");
            System.out.println("\n\t\tEnter A to Add Person ");
            System.out.println("\t\tEnter E to Edit Person");
            System.out.println("\t\tEnter D to Delete Person");
            System.out.println("\t\tEnter S to Show Person Detail");
            System.out.println("\t\tEnter Q to Quit ");
            System.out.print("\t\tPlease Select One Option : ");
            char userInput = scanner.nextLine().toUpperCase().charAt(0);
            switch (userInput) {
                case 'A':
                    //add
                    addContact();
                    break;
                case 'E':
                    //edit
                    editContact();
                    break;
                case 'D':
                    //delete
                    deletePerson();
                    break;
                case 'S':
                    //Show
                    System.out.println("\n\t\t" + personList.get(personList.size() - 1).toString());
                    break;
                case 'Q':
                    //Show
                    isExit = true;
                    break;
                default:
                    System.out.println("Please select correct option");
            }
        } while (!isExit);

    }

    /**
     * method for add new contact to the address book
     */
    private static void addContact() {
        Person newPerson = new Person();
        System.out.print("Enter Firstname: ");
        newPerson.setFirstName(scanner.nextLine());

        System.out.print("Enter Lastname: ");
        newPerson.setLastName(scanner.nextLine());

        System.out.print("Enter Address: ");
        newPerson.setAddress(scanner.nextLine());

        System.out.print("Enter City: ");
        newPerson.setCity(scanner.nextLine());

        System.out.print("Enter State: ");
        newPerson.setState(scanner.nextLine());

        System.out.print("Enter Zip: ");
        newPerson.setZip(scanner.nextLine());

        System.out.print("Enter Phone Number: ");
        newPerson.setMobileNumber(scanner.nextLine());

        personList.add(newPerson);
        System.out.println(personList.toString());
    }

    /**
     * Method for edit existing contact
     */
    private static void editContact() {
        System.out.print("\nEnter the first name of the person to edit : ");
        String firstName = scanner.nextLine();

        if (null != filter(firstName)) {
            Person person = filter(firstName);
            System.out.print("\nEnter Lastname: ");
            person.setLastName(scanner.nextLine());

            System.out.print("Enter Address: ");
            person.setAddress(scanner.nextLine());

            System.out.print("Enter City: ");
            person.setCity(scanner.nextLine());

            System.out.print("Enter State: ");
            person.setState(scanner.nextLine());

            System.out.print("Enter Zip: ");
            person.setZip(scanner.nextLine());

            System.out.print("Enter Phone Number: ");
            person.setMobileNumber(scanner.nextLine());

            for (int j = 0; j < personList.size(); j++) {
                if (personList.get(j).getFirstName().equalsIgnoreCase(person.getFirstName())) {
                    personList.set(j, person);
                }
            }

            System.out.println(personList.toString());
        }
    }

    /**
     * Method for deleting the person from existing address book
     */
    private static void deletePerson() {
        System.out.print("\nEnter the first name of the person to delete : ");
        String firstName = scanner.nextLine();
        if (null != filter(firstName)) {
            personList.remove(filter(firstName));
            System.out.println("Deleted Successfully");
        } else {
            System.out.println("Record not exist");
        }

    }


    private static Person filter(String firstName) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                return personList.get(i);
            } else {
                System.out.println("Record not exist");
            }
        }
        return null;
    }

}