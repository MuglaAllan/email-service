package je.dvs.echo.emailservice.Objects;

import java.io.Serializable;

public class Condition {

    String condition_code;
    String condition_name;

    public Condition(String codition_code, String condition_name) {
        this.condition_code = codition_code;
        this.condition_name = condition_name;
    }

    public Condition(){}

    public String getCodition_code() {
        return condition_code;
    }

    public void setCodition_code(String codition_code) {
        this.condition_code = codition_code;
    }

    public String getCondition_name() {
        return condition_name;
    }

    public void setCondition_name(String condition_name) {
        this.condition_name = condition_name;
    }
}
