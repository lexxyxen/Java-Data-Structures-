import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        initMenu();

    }
    private static int mainMenu(){
        int option;
        Scanner sc = new Scanner(System.in);

            System.out.println("Please select an option to proceed!");
            System.out.println("-------------------------------------------\n");
            System.out.println("1 - Enter values to the Linked List          ");
            System.out.println("2 - Delete a value from the Linked List      ");
            System.out.println("3 - Replicate the Link List x number of times");
            System.out.println("4 - Display the values of the Linked List    ");
            System.out.println("5 - Quit                                     ");
            option = sc.nextInt();
        return option;
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
    /*
    * ustomer ID: " + customerID + "\n" +
                " First Name: " + firstName + "\n" +
                " Last Name: " + lastName + "\n" +
                " Address: " + fullAddress +  "\n" +
                " Telephone Number: " + telephoneNumber;
    *
    * */
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

            System.out.println("Do you want to continue(Y/N):");
            ch = sc.next();



            if (ch.equalsIgnoreCase("n") )  {
                break;
            }

        }

    }
    public static void initMenu(){
        int choice;
        do{
            clearScreen();
           choice= mainMenu();
        }while (choice==5);
        makeSelection(choice);
    }

    private  static void makeSelection(int choice) {
        CustomList<Customer> myCustomerList = new LinkedList<>();

        switch(choice) {
            case 1:
                populateList();
                break;
            case 2:
                Customer cust2 = new Customer(2222, "Diana", "Muller", "2334 Cote-Des-Neiges, QC", "(514)-333-3533");
                myCustomerList.delete(cust2);
                break;
            case 3:
                myCustomerList.replicate(4);
                break;

            case 4:
                myCustomerList.traverseList();
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
