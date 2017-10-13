package com.example.accounts;

/**
 * Classes that implement security require authorisation.
 */
public interface Security {
    /**
     *
     * @return true if authorised, otherwise false.
     */
    public boolean authorised();
}
