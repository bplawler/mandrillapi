package mandrillapi.api.mandrill;

import java.util.List;

/**
 * Immutable interface for sending on to Mandrill.
 */
public interface SendTemplate {
    String getKey();
    String getTemplateName();


    public static interface ContentVar {
        String getName();
        String getContent();
    }
    List<ContentVar> getTemplateContent(); 
    
    public static interface Message {
        String getSubject();
        String getFromEmail();
        String getFromName();

        List<ContentVar> getGlobalMergeVars();

        List<To> getTo();
        public static interface To {
            String getEmail();
            String getName();
            String getType();
        }
    }
    Message getMessage();
}
