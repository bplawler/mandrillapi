package mandrillapi.api;

public interface Email {
    Email setTo(String email);
    Email setTo(mandrillapi.api.User user);
    Email setTemplate(String templateName);
    Email setSubject(String subject);
    Email setHtmlContent(String content);
    Email addMergeVariable(String key, String value);
    Email setGoogleAnalyticsCampaign(String campaign);
    Email setGoogleAnalyticsDomain(String domain);
    void send();
}
