package mandrillapi.api.ex;

public class SendException extends RuntimeException {
    public SendException(Integer code, String name, String message) {
        super("code: " + code.toString() + 
              " name: " + name +
              " message: " + message);
    }
}
