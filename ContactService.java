package com.grandstrand;

import java.util.HashMap;
import java.util.Map;

/**
 * ContactService class for managing contacts in memory.
 * Provides functionality to add, delete, and update contacts.
 */
public class ContactService {
    private Map<String, Contact> contacts;

    /**
     * Constructor initializes the contacts map
     */
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    /**
     * Adds a new contact with unique ID
     * @param contact The contact to add
     * @throws IllegalArgumentException if contact ID already exists
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists: " + contact.getContactId());
        }
        
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes a contact by contact ID
     * @param contactId The ID of the contact to delete
     * @throws IllegalArgumentException if contact ID doesn't exist
     */
    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found: " + contactId);
        }
        
        contacts.remove(contactId);
    }

    /**
     * Updates the first name of a contact
     * @param contactId The ID of the contact to update
     * @param firstName The new first name
     * @throws IllegalArgumentException if contact ID doesn't exist
     */
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    /**
     * Updates the last name of a contact
     * @param contactId The ID of the contact to update
     * @param lastName The new last name
     * @throws IllegalArgumentException if contact ID doesn't exist
     */
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    /**
     * Updates the phone number of a contact
     * @param contactId The ID of the contact to update
     * @param phone The new phone number
     * @throws IllegalArgumentException if contact ID doesn't exist
     */
    public void updatePhone(String contactId, String phone) {
        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    /**
     * Updates the address of a contact
     * @param contactId The ID of the contact to update
     * @param address The new address
     * @throws IllegalArgumentException if contact ID doesn't exist
     */
    public void updateAddress(String contactId, String address) {
        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }

    /**
     * Retrieves a contact by ID
     * @param contactId The ID of the contact to retrieve
     * @return The contact object
     * @throws IllegalArgumentException if contact ID doesn't exist
     */
    public Contact getContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found: " + contactId);
        }
        
        return contacts.get(contactId);
    }

    /**
     * Gets the total number of contacts
     * @return The number of contacts
     */
    public int getContactCount() {
        return contacts.size();
    }

    /**
     * Checks if a contact exists
     * @param contactId The ID of the contact to check
     * @return true if contact exists, false otherwise
     */
    public boolean contactExists(String contactId) {
        return contactId != null && contacts.containsKey(contactId);
    }
}
