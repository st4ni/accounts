package com.example.accounts;

/**
 * Class holding the personal details of customers
 */
public class CustomerDetails {

    private String firstName;
    private String surname;
    private String address;
    private String phoneNumber;
    private String dateOfBirth;
    private String accountNumber;

    /**
     * Constructor for class CustomerDetails with 5 parameters
     * @param firstName
     * @param surname
     * @param address
     * @param phoneNumber
     * @param dateOfBirth
     * @param accountNumber
     */
    public CustomerDetails(String firstName, String surname, String address, String phoneNumber, String dateOfBirth, String accountNumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber = accountNumber;
    }

    /**
     *
     * @return the first name of the customer
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the firstName.
     * @param firstName first name of customer
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return the surname of the customer
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surame of the customer.
     * @param surname the surname of the customer.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return the address of the customer
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the customer.
     * @param address the address of the customer
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return the phone number of the customer
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phoneNumber of the customer.
     * @param phoneNumber the phone number of the customer.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     *
     * @return the accountNumber of the customer
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the accountNumber of the customer.
     * @param accountNumber the account number of the customer
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
