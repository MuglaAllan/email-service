package je.dvs.echo.emailservice.Config;

public class RabbitMQHeaders {

    public enum Header {EMAIL}

    public enum Name {
        InspectionFail,
        InspectionPass,
        Documents,
        Payment,
        Invoice
    }
}