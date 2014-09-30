package mandrillapi.api;

public interface Email {
    Email setTo(String email);
    Email setTo(mandrillapi.api.User user);
    Email setTemplate(String templateName);
    Email setHtmlContent(String content);
    Email addMergeVariable(String key, String value);
    void send();
}
