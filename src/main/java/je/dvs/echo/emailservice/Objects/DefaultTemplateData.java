package je.dvs.echo.emailservice.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import je.dvs.echo.emailservice.Config.templateKeyNames;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class DefaultTemplateData implements Serializable,TemplateData {

    @SerializedName(templateKeyNames.LINK)
    @Expose
    private String link;

    @SerializedName(templateKeyNames.RECIPIENT_NAME)
    @Expose
    private String recipientName;

    @SerializedName(templateKeyNames.RECIPIENT_EMAIL)
    @Expose
    private String recipientEmail;

    @SerializedName(templateKeyNames.EMAIL_TEMPLATE)
    @Expose
    private String emailTemplate;


     DefaultTemplateData(String link, String recipientName, String recipientEmail, String emailTemplate) {
        this.link = link;
        this.recipientName = recipientName;
        this.recipientEmail = recipientEmail;
        this.emailTemplate = emailTemplate;
    }

    public DefaultTemplateData() {
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getEmailTemplate() {
        return emailTemplate;
    }

    public void setEmailTemplate(String emailTemplate) {
        this.emailTemplate = emailTemplate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
