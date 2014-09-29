package mandrillapi.api;

public interface Email {
    Email setTo(mandrillapi.api.User user);
    Email setTemplate(String templateName);
    Email addMergeVariable(String key, String value);
    void send();
}
