package je.dvs.echo.emailservice.Camel;

import je.dvs.echo.emailservice.Config.RabbitMQ;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

@Component
@Import(RabbitMQ.class)
public class Routes extends RouteBuilder {

    @Autowired
    CamelContext context;

    @Value("#{rabbitMQ.EMAIL_QUEUE}")
    private String EMAIL_QUEUE;

    @Value("#{rabbitMQ.PERMIT_QUEUE}")
    private String PERMIT_QUEUE;

    @Value("#{rabbitMQ.AUDIT_QUEUE}")
    private String AUDIT_QUEUE;

    @Value("#{rabbitMQ.ERROR_QUEUE}")
    public String ERROR_QUEUE;


    public String LOGGER_QUEUE = "log:?level=INFO&showBody=true&showHeaders=true&showExchangeId=true&multiline=true";



    public String recipient;

    String username = System.getenv("AZURE_EMAILUSERNAME");
    String password = System.getenv("AZURE_EMAILPASSWORD");
    String fromAddress = username;
    String options = "debugMode=true&mail.smtp.auth=true&mail.smtp.starttls.enable=true&contentType=text/html";



    @Override
    public void configure() {



        from(EMAIL_QUEUE).routeId("emailer")
             .to(LOGGER_QUEUE)
            .choice()
              .when(header("REQUEST").isEqualTo(constant("printPermitPDF")))
                .to(LOGGER_QUEUE)
                .process(exchange -> new CamelProcessor().processEmail(exchange))
                .to("bean:pdfGeneratorUtil?method=createPdf(${body}, ${header.email_template})")
                .to(LOGGER_QUEUE)
                .process(exchange -> new AttachmentProcessor().process(exchange))
                .to(LOGGER_QUEUE)
              .when(header("REQUEST").isEqualTo(constant("permit_declined")))
               .end()
            .process(exchange -> new CamelProcessor().processEmail(exchange))
                .to(LOGGER_QUEUE)
            .to("bean:thymeleafEngine?method=process(${body}, ${header.email_template})")
                .setHeader("to",simple("${header.recipient_email}")) //camel mail needs recipient in header
                .setHeader("subject", simple("Drive Jersey Documents"))
            .to("smtps://smtp.sendgrid.net?password="+password+"&username="+username+"&From="+fromAddress+"&"+options) //here uses camel mail
            .process(exchange -> new AuditProcessor().process(exchange))
            .to(AUDIT_QUEUE)
            .log("EMAIL SENT")
        .end();

    }

}
