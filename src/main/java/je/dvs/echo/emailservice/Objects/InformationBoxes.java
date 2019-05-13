package je.dvs.echo.emailservice.Objects;

import org.springframework.stereotype.Component;


public class InformationBoxes {

    String ID;
    String Text;

    public InformationBoxes(String ID, String text) {
        this.ID = ID;
        this.Text = text;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public InformationBoxes(String ID)
    {
        this.ID = ID;
        this.Text = Text;
    }



}
