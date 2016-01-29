package mandrillapi.api; 

public interface Mandrill {
    Email newEmail();
    Webhooks getWebhooksForMessage(String mandrillMsgId);
}
