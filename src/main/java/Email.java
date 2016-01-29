package mandrillapi.api;

import java.util.Map;

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
    * @return A Map keyed by email address, with a value describing
    *  what the status is for the individual message.
    *
    * @throws SendException with the code, name, and explanatory
    *  message returned by the error.
    */
    Map<String, mandrillapi.api.mandrill.SendResponse> send() 
      throws mandrillapi.api.ex.SendException;
}
