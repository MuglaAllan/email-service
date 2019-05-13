package je.dvs.echo.emailservice.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RabbitMQ extends Properties {

    public final String EMAIL_QUEUE = CreateRabbitMQQueue("Emailer", "Emailer");
    public final String PERMIT_QUEUE = CreateRabbitMQQueue("PrintPermit","camel");
    public final String AUDIT_QUEUE = CreateRabbitMQQueue("Audit","camel");
    public final String ERROR_QUEUE = CreateRabbitMQQueue("errorQueue", "camel");


    public static String CreateRabbitMQQueue(String QueueName, String RoutingKey)
    {
        String hostv;
        String portv;
        String username;
        String password;

        hostv = System.getenv("V_RABBIT_HOST");
        portv = System.getenv("V_RABBIT_PORT");
        username = System.getenv("V_RABBIT_USERNAME");
        password = System.getenv("V_RABBIT_PASSWORD");

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromPath("/" )
                .scheme("rabbitmq")
                .host(hostv)
                .port(portv)
                .path("/" + QueueName)
                .queryParam("username",username)
                .queryParam("password", password)
                .queryParam("routingKey",RoutingKey)
                .queryParam("queue","Q" + QueueName);


        System.out.println(uriBuilder.toUriString());
        return uriBuilder.toUriString();

    }
}

