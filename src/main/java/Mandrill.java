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

   /**
    * Given an inbound JSON object, create a typed wrapper around it for getting
    * access to the information contained within.
    */
    Webhook wrapWebhook(JsonNode o);

   /**
    * Applicaiton specific processing for an inbound webhook.
    */
    void processWebhook(Webhook w);
}
