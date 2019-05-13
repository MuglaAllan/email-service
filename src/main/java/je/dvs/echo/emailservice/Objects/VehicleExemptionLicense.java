package je.dvs.echo.emailservice.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import je.dvs.echo.emailservice.Config.templateKeyNames;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleExemptionLicense extends DefaultTemplateData implements Serializable,TemplateData {

    Address address = new Address();

    List<Condition> conditions = new ArrayList<>();

    @SerializedName(templateKeyNames.VEHICLE_MAKE)
    @Expose
    String make;


    @SerializedName(templateKeyNames.VEHICLE_MODEL)
    @Expose
    String model;

    @SerializedName(templateKeyNames.REGISTRATION_NUMBER)
    @Expose
    String registration_number;

    @SerializedName(templateKeyNames.PERMIT_NUMBER)
    @Expose
    String permit_number;

    @SerializedName(templateKeyNames.VEHICLE_WIDTH)
    @Expose
    String vehicle_width;

    @SerializedName(templateKeyNames.VEHICLE_LENGTH)
    @Expose
    String vehicle_length;

    @Expose
    String end_date;

    @Expose
    String start_date;

    @Expose
    String law3;

    @Expose
    String permittedroutes;





    public VehicleExemptionLicense(){}

    public VehicleExemptionLicense(String link, String recipientName, String recipientEmail, String emailTemplate, Address address, List<Condition> conditions, String vehicle_make, String vehicle_model, String registration_number, String permit_number, String vehicle_width, String vehicle_length, String expiry_date, String start_date, String law3, String permittedroutes) {
        super(link, recipientName, recipientEmail, emailTemplate);
        this.address = address;
        this.conditions = conditions;
        this.make = vehicle_make;
        this.model = vehicle_model;
        this.registration_number = registration_number;
        this.permit_number = permit_number;
        this.vehicle_width = vehicle_width;
        this.vehicle_length = vehicle_length;
        this.end_date = expiry_date;
        this.start_date = start_date;
        this.law3 = law3;
        this.permittedroutes = permittedroutes;
    }

    public VehicleExemptionLicense(Address address, List<Condition> conditions, String vehicle_make, String vehicle_model, String registration_number, String permit_number, String vehicle_width, String vehicle_length, String expiry_date, String start_date, String law3, String permittedroutes) {
        this.address = address;
        this.conditions = conditions;
        this.make = vehicle_make;
        this.model = vehicle_model;
        this.registration_number = registration_number;
        this.permit_number = permit_number;
        this.vehicle_width = vehicle_width;
        this.vehicle_length = vehicle_length;
        this.end_date = expiry_date;
        this.start_date = start_date;
        this.law3 = law3;
        this.permittedroutes = permittedroutes;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getPermit_number() {
        return permit_number;
    }

    public void setPermit_number(String permit_number) {
        this.permit_number = permit_number;
    }

    public String getVehicle_width() {
        return vehicle_width;
    }

    public void setVehicle_width(String vehicle_width) {
        this.vehicle_width = vehicle_width;
    }

    public String getVehicle_length() {
        return vehicle_length;
    }

    public void setVehicle_length(String vehicle_length) {
        this.vehicle_length = vehicle_length;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String Expiry_date) {
        end_date = Expiry_date;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getLaw3() {
        return law3;
    }

    public void setLaw3(String law3) {
        this.law3 = law3;
    }

    public String getPermittedroutes() {
        return permittedroutes;
    }

    public void setPermittedroutes(String permittedroutes) {
        this.permittedroutes = permittedroutes;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
