package mandrillapi.api.mandrill;

public interface  SendResponse {
    String getEmail();
    String getStatus();
    String getRejectReason();
    String getId();
}
