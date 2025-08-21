package com.grandstrand;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ContactService class.
 * Tests all requirements including add, delete, and update functionality.
 */
public class ContactServiceTest {
    private ContactService contactService;
    private Contact testContact;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        testContact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testAddContact() {
        contactService.addContact(testContact);
        assertEquals(1, contactService.getContactCount());
        assertTrue(contactService.contactExists("123"));
        assertEquals(testContact, contactService.getContact("123"));
    }

    @Test
    public void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(null);
        });
    }

    @Test
    public void testAddDuplicateContactId() {
        contactService.addContact(testContact);
        Contact duplicateContact = new Contact("123", "Jane", "Smith", "0987654321", "456 Oak Ave");
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(duplicateContact);
        });
    }

    @Test
    public void testAddMultipleContacts() {
        Contact contact2 = new Contact("456", "Jane", "Smith", "0987654321", "456 Oak Ave");
        
        contactService.addContact(testContact);
        contactService.addContact(contact2);
        
        assertEquals(2, contactService.getContactCount());
        assertTrue(contactService.contactExists("123"));
        assertTrue(contactService.contactExists("456"));
    }

    @Test
    public void testDeleteContact() {
        contactService.addContact(testContact);
        assertEquals(1, contactService.getContactCount());
        
        contactService.deleteContact("123");
        assertEquals(0, contactService.getContactCount());
        assertFalse(contactService.contactExists("123"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("nonexistent");
        });
    }

    @Test
    public void testDeleteNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact(null);
        });
    }

    @Test
    public void testUpdateFirstName() {
        contactService.addContact(testContact);
        contactService.updateFirstName("123", "Jane");
        
        assertEquals("Jane", contactService.getContact("123").getFirstName());
    }

    @Test
    public void testUpdateFirstNameNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("nonexistent", "Jane");
        });
    }

    @Test
    public void testUpdateFirstNameInvalid() {
        contactService.addContact(testContact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("123", null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("123", "TooLongFirstName");
        });
    }

    @Test
    public void testUpdateLastName() {
        contactService.addContact(testContact);
        contactService.updateLastName("123", "Smith");
        
        assertEquals("Smith", contactService.getContact("123").getLastName());
    }

    @Test
    public void testUpdateLastNameNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("nonexistent", "Smith");
        });
    }

    @Test
    public void testUpdateLastNameInvalid() {
        contactService.addContact(testContact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("123", null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("123", "TooLongLastName");
        });
    }

    @Test
    public void testUpdatePhone() {
        contactService.addContact(testContact);
        contactService.updatePhone("123", "0987654321");
        
        assertEquals("0987654321", contactService.getContact("123").getPhone());
    }

    @Test
    public void testUpdatePhoneNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("nonexistent", "0987654321");
        });
    }

    @Test
    public void testUpdatePhoneInvalid() {
        contactService.addContact(testContact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("123", null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("123", "123456789");
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("123", "12345678901");
        });
    }

    @Test
    public void testUpdateAddress() {
        contactService.addContact(testContact);
        contactService.updateAddress("123", "456 Oak Ave");
        
        assertEquals("456 Oak Ave", contactService.getContact("123").getAddress());
    }

    @Test
    public void testUpdateAddressNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("nonexistent", "456 Oak Ave");
        });
    }

    @Test
    public void testUpdateAddressInvalid() {
        contactService.addContact(testContact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("123", null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("123", "This address is way too long for the 30 character limit");
        });
    }

    @Test
    public void testGetContact() {
        contactService.addContact(testContact);
        Contact retrievedContact = contactService.getContact("123");
        
        assertEquals(testContact, retrievedContact);
        assertEquals("John", retrievedContact.getFirstName());
        assertEquals("Doe", retrievedContact.getLastName());
    }

    @Test
    public void testGetNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("nonexistent");
        });
    }

    @Test
    public void testGetNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact(null);
        });
    }

    @Test
    public void testContactExists() {
        assertFalse(contactService.contactExists("123"));
        
        contactService.addContact(testContact);
        assertTrue(contactService.contactExists("123"));
        
        contactService.deleteContact("123");
        assertFalse(contactService.contactExists("123"));
    }

    @Test
    public void testContactExistsNull() {
        assertFalse(contactService.contactExists(null));
    }

    @Test
    public void testGetContactCount() {
        assertEquals(0, contactService.getContactCount());
        
        contactService.addContact(testContact);
        assertEquals(1, contactService.getContactCount());
        
        Contact contact2 = new Contact("456", "Jane", "Smith", "0987654321", "456 Oak Ave");
        contactService.addContact(contact2);
        assertEquals(2, contactService.getContactCount());
        
        contactService.deleteContact("123");
        assertEquals(1, contactService.getContactCount());
    }

    @Test
    public void testMultipleUpdatesOnSameContact() {
        contactService.addContact(testContact);
        
        contactService.updateFirstName("123", "Jane");
        contactService.updateLastName("123", "Smith");
        contactService.updatePhone("123", "0987654321");
        contactService.updateAddress("123", "456 Oak Ave");
        
        Contact updatedContact = contactService.getContact("123");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Oak Ave", updatedContact.getAddress());
        assertEquals("123", updatedContact.getContactId()); // ID should remain unchanged
    }
}
