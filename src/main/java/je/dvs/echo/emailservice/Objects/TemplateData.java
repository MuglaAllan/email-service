package je.dvs.echo.emailservice.Objects;

public interface TemplateData {

    String getLink();

    void setLink(final String link);

    String getRecipientName();

    void setRecipientName(final String recipientName);

    String getRecipientEmail();

    void setRecipientEmail(final String recipientEmail);

    String getEmailTemplate();

    void setEmailTemplate(final String emailTemplate);
}
