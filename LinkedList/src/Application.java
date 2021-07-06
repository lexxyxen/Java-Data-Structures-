import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
            clearScreen();
            mainMenu();
            choice = sc.nextInt();

            makeSelection(choice);
        }while (choice!=5);
    }
    private static void mainMenu(){
        int option;
        /*
        Seperate make one menu method and just pass parameter of array  argument.
        remove the return type and just leave it looping into the make selection part.
         */

            System.out.println("Please select an option to proceed!");
            System.out.println("-------------------------------------------\n");
            System.out.println("1 - Enter values to the Linked List          ");
            System.out.println("2 - Delete a value from the Linked List      ");
            System.out.println("3 - Replicate the Link List x number of times");
            System.out.println("4 - Display the values of the Linked List    ");
            System.out.println("5 - Quit                                     ");
    }

    // Submenu
    private static void subMenu(String title, String... msg){
        System.out.println(title);
        System.out.println("-------------------------------------------\n");
        if (msg!= null){
            for (String str: msg){
                System.out.println(str);
            }
        }
    }

    private static void populateList(){
        int id=0;
        String firstName = "";
        String lastName = "";
        String address = "";
        String telephone = "";
        String ch ="";
        CustomList<Customer> myCustomerList = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        while(true){
          //  subMenu("Enter Employee Information", "Enter ID:\n","Enter Fist Name:\n",
             //       "Enter Last Name:\n", "Enter Address:\n", "Enter Telephone:\n", "Do you want to continue(Y/N):\n");
            //Customer(int customerID, String firstName, String lastName, String fullAddress, String telephoneNumber)
            //Customer cust1 = new Customer(1111, "Mike", "Smith", "333 St. Catherine St, Montreal, QC", "(514)-111-2222");
            // Customer cust2 = new Customer(2222, "Diana", "Muller", "2334 Cote-Des-Neiges, QC", "(514)-333-3533");


            //myCustomerList.put(cust1);
            // myCustomerList.put(cust2);
            System.out.println("Enter ID: ");
            id = Integer.parseInt(sc.nextLine());

            System.out.println("Enter Fist Name: ");
            firstName = sc.nextLine();

            System.out.println("Enter Last Name: ");
            lastName = sc.nextLine();

            System.out.println("Enter address: ");
            address = sc.nextLine();

            System.out.println("Enter telephone: ");

            telephone = sc.nextLine();
            myCustomerList.put(new Customer(id, firstName, lastName, address, telephone));

            myCustomerList.traverseList();

            System.out.println("\nDo you want to continue(Y/N):");
            ch = sc.nextLine();



            if (ch.equalsIgnoreCase("n") )  {
                break;
            }

        }

    }



    private  static void makeSelection(int choice) {
        CustomList<Customer> myCustomerList = new LinkedList<>();

        switch(choice) {
            case 1:
                populateList();
                break;
            case 2:
                // Creating a temp list object for deletion
                Customer cust2 = new Customer(2222, "Diana", "Muller", "2334 Cote-Des-Neiges, QC", "(514)-333-3533");
                myCustomerList.delete(cust2);
                break;
            case 3:
                myCustomerList.replicate(4);
                break;

            case 4:
                myCustomerList.traverseList();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("unexpected error has occurred!");
        }
    }

    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void promptForValidInput(int ch){
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Please enter a positive number: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            number = scanner.nextInt();
        } while (number < 0);
    }
}
