package com.example.accounts;

/**
 * Class holding the personal details of customers
 */
public class CustomerDetails {

    private String firstName;
    private String surname;
    private String address;
    private String phoneNumber;
    private String accountNumber;

    /**
     * Constructor for class CustomerDetails with 5 parameters
     * @param firstName
     * @param surname
     * @param address
     * @param phoneNumber
     * @param accountNumber
     */
    public CustomerDetails(String firstName, String surname, String address, String phoneNumber, String accountNumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
    }

    /**
     * Returns the first name of the customer
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the firstName of the instance to that of the argument.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the first Surname of the customer
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the Surame of the instance to that of the argument.
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns the address of the customer
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the instance to that of the argument.
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the phone number of the customer
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phoneNumber of the instance to that of the argument.
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the accountNumber of the customer
     * @return
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the accountNumber of the instance to that of the argument.
     * @param accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
