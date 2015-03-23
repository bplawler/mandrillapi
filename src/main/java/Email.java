package mandrillapi.api;

public interface Email {
    Email addTo(String email);
    Email addTo(mandrillapi.api.User user);
    Email setTemplate(String templateName);
    Email setSubject(String subject);
    Email addMergeVariable(String key, String value);
    Email addTemplateContent(String key, String value);
    Email setGoogleAnalyticsCampaign(String campaign);
    Email setGoogleAnalyticsDomain(String domain);
   /**
    * @return Mandrill's unique id generated for the message (which 
    *  may later be used to map this message back to a web hook
    *  received from Mandrill.
    *
    * @throws SendException with the code, name, and explanatory
    *  message returned by the error.
    */
    String send() throws mandrillapi.api.ex.SendException;
}
