package mandrillapi.api; 

import com.fasterxml.jackson.databind.JsonNode;

/**
 * This interface provides the top-level entry points for interacting with the
 * Mandrill API using this module.
 */
public interface Mandrill {
   /**
    * Factory for creating new instances of Email.  The Email object may then 
    * be populated with information about who to send the email to, and what it
    * should contain.
    */
    Email newEmail();
}
