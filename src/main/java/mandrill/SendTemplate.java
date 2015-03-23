package mandrillapi.api.mandrill;

import java.util.List;
import java.util.Set;

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

        Set<To> getTo();
        public static interface To {
            String getEmail();
            String getName();
            String getType();
        }

        List<String> getGoogleAnalyticsDomains();
        String getGoogleAnalyticsCampaign();
    }
    Message getMessage();
}
