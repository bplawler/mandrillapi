package mandrillapi.api;

public interface Email {
    Email setTo(String email);
    Email setTo(mandrillapi.api.User user);
    Email setTemplate(String templateName);
    Email setSubject(String subject);
    Email addMergeVariable(String key, String value);
    Email addTemplateContent(String key, String value);
    Email setGoogleAnalyticsCampaign(String campaign);
    Email setGoogleAnalyticsDomain(String domain);
    void send();
}
