package je.dvs.echo.emailservice.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Address {


    public String departmentName;
    public String subDepartmentName;
    public String street;
    public String parish;
    public String island;
    public String postcode;

    public Address() {
        this.departmentName = "Growth, Housing and Environment";
        this.subDepartmentName = "Driver and Vehicle Standards";
        this.street="La Collette";
        this.parish="St.Helier";
        this.island="Jersey";
        this.postcode="JE1 3UE";
    }

}
