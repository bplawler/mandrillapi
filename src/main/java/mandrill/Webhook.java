package mandrillapi.api.mandrill;

import java.util.List;

public interface Webhook {
    java.util.Date getTs();
    String getEvent();
    String getUrl();
    String getIp();
    String getUserAgent();
    Location getLocation();

    public static interface Location {
        String getCountryShort();
        String getCountryLong();
        String getRegion();
        String getCity();
        String getPostalCode();
        String getTimezone();
        Float getLatitude();
        Float getLongitude();
    }

    UserAgent getUserAgent();

    public static interface UserAgent {
        Boolean isMobile();
        String getOsCompany();
        String getOsCompanyUrl();
        String getOsFamily();
        String getOsIcon();
        String getOsName();
        String getType();
        String getUaCompany();
        String getUaCompanyUrl();
        String getUaFamily();
        String getUaIcon();
        String getUaName();
        String getUaUrl();
        String getUaVersion();
    }

    String getId();

    Message getMessage(); 
     
    public static interface Message {
        String getId();
        java.util.Date getTs();
        String getEmail();
        String getSender();
        String getSubject();
        List<SmtpEvent> getSmtpEvents();
        
        public static interface SmtpEvent {
            java.util.Date getTs();
            String getType();
            String getDiag();
            String getSourceIp();
            String getDestinationIp();
            String getSize();
        }

        List<Open> getOpens();

        public static interface Open {
            java.util.Date getTs();
            String getIp();
            String getLocation();
            String getUa();
        }

        List<Click> getClicks();

        public static interface Click {
            java.util.Date getTs();
            String getUrl();
        }

        List<String> getTags();
        String getMetadata();
        String getState();
        String getSubaccount();
        String getDiag();
        String getBounceDescription();
        String getTemplate();
    }
}
