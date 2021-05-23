public class Customer implements Comparable<Customer> {
    private int customerID;
    private String firstName;
    private String lastName;
    private String fullAddress;
    private String telephoneNumber;

    public Customer(int customerID, String firstName, String lastName, String fullAddress, String telephoneNumber) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullAddress = fullAddress;
        this.telephoneNumber = telephoneNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    @Override
    public int compareTo(Customer c){

        // other and 0 if they are supposed to be equal
        int last = this.lastName.compareTo(c.lastName);
        return last == 0 ? this.firstName.compareTo(c.firstName) : last;
    }
    @Override
    public String toString() {
        return "Customer Information: \n" +
                " Customer ID: " + customerID +
                " First Name: " + firstName + "\n" +
                " Last Name: " + lastName + "\n" +
                " Address: " + fullAddress +  "\n" +
                " Telephone Number: " + telephoneNumber;
    }
}
