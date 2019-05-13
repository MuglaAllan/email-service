package je.dvs.echo.emailservice.Camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.json.simple.JsonObject;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.HashMap;
import java.util.Map;


public class AuditProcessor implements Processor {


    @Override
    public void process(final Exchange exchange) throws Exception {

        try
        {
            String id = null;

            if(exchange.getIn().hasHeaders()) {
                System.out.println("MessageID:" + exchange.getIn().getMessageId());
                id = exchange.getIn().getHeader("DocUUID").toString().isEmpty() ? exchange.getIn().getMessageId() : exchange.getIn().getHeader("DocUUID").toString();

            }
            String groupName = "email";

            //Updated when security service implemented
            String user = "1";


            Map<String,Object> headers = new HashMap<String,Object>();
            headers.put("auditId", id);
            headers.put("user", user);
            headers.put("groupName", groupName);

            exchange.getOut().setBody(exchange.getIn().getBody());
            exchange.getOut().setHeaders(headers);

        }
        catch (Exception e)
        {
            throw  new Exception( "Failed to send message");
        }




    }
}
