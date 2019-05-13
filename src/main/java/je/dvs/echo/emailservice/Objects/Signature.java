package je.dvs.echo.emailservice.Objects;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Signature {

    UUID userID;
    String Signature;

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }
}
