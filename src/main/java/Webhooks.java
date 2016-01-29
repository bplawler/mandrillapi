package mandrillapi.api;

/**
 * This interface is here to provide the interface contract for receiving 
 * webhook calls from Mandrill.  Mandrill will return a unique id from the
 * Email.send() method, which is the same id that will later be sent to the
 * webhook endpoint to match up the message with the event.
 */
public interface Webhooks {
   /**
    * The Webhooks interface is intended to be implemented by a class whose 
    * instances correspond to a single Mandrill message.
    *
    * @return String id of the message this instance corresponds to.
    */
    String getId();

   /**
    * Triggered when the Pircular is sent.  This will give us a confirmation that
    * the Pircular actually made it out of Mandrill.  This is good to know because
    * there are many situations where a message is sent to Mandrill but doesn't 
    * then get sent out (due to blacklisting, for example).
    */
    void sent();

   /**
    * Triggered when the end user opens the email.
    */
    void opened();

   /**
    * Triggered when a link in the email is clicked.
    *
    * @param url String containing the URL that the user clicked.
    */
    void clicked(String url);

    void hardBounce();
    void spam();
    void reject();
}
