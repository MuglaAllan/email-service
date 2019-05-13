package je.dvs.echo.emailservice.Camel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import je.dvs.echo.emailservice.Config.TemplateNames;
import je.dvs.echo.emailservice.Config.templateKeyNames;
import je.dvs.echo.emailservice.Objects.Address;
import je.dvs.echo.emailservice.Objects.InformationBoxes;
import org.apache.camel.Attachment;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CamelProcessor implements Processor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    String law1 = "The Inspector of Motor Traffic in pursance of Article 78 of the Road Traffic (Jersey) Law 1956 hereby exempts the undermentioned vehicle from the provisions of Article(s)";
    String law2 = " of the Motor Vehicles (Construction and Use)(Jersey)Order 1998";
    String law3 = null;
    String permittedroutes = null;
    String validFrom = null;
    String validTo = null;
    String permitValidDates1 = "This permit is valid from ";
    String permitValidDates2 = " and expires on ";
    String permitValidDates3 =" but will cease to valid on change of ownership or at any time the Inspector of Motor Traffic may determine.";

    @Override
    public void process(final Exchange exchange) {
    }

    public void processEmail(final Exchange exchange) throws JsonProcessingException {

        String body = exchange.getIn().getBody(String.class);

        exchange.getOut().setHeaders(exchange.getIn().getHeaders());
        JSONObject jsonObject = new JSONObject(body);

        String FileName = (String) exchange.getIn().getHeader("FileName");


        if(exchange.getIn().getHeaders().containsKey("DocUUID"))
        {
            String docUUID = exchange.getIn().getHeader("docUUID").toString();
            jsonObject.put("docUUID", docUUID);
        }

        //set attachment the message
        if(exchange.getIn().hasAttachments()) {
          Attachment Received = exchange.getIn().getAttachmentObject(FileName);
          exchange.getOut().addAttachmentObject("FileName", Received);
        }
        // Get the template name.
        String template = jsonObject.getString(templateKeyNames.EMAIL_TEMPLATE);
        exchange.getOut().setHeader(templateKeyNames.EMAIL_TEMPLATE, template);

        if(template.equals(TemplateNames.P30_PERM) || template.equals(TemplateNames.P30_TEMP))
        {

            law3 = jsonObject.getString("law3");
            permittedroutes = jsonObject.getString("permitted_route");


            if(jsonObject.get("start_date") instanceof Long && jsonObject.get("expired_date") instanceof Long) {
                validFrom = new Date(jsonObject.getLong("start_date")).toString();
                validTo = new Date(jsonObject.getLong("end_date")).toString();
            }
            else
            {
                validFrom = jsonObject.getString("start_date");
                validTo = jsonObject.getString("end_date");
            }

            List<InformationBoxes> ListInformationBoxes = new ArrayList<>();
            ListInformationBoxes.add(new InformationBoxes("law",String.format(law1 + law3 + law2)));
            ListInformationBoxes.add(new InformationBoxes("permitted_routes", permittedroutes));
            ListInformationBoxes.add(new InformationBoxes("permit_valid_dates",String.format(permitValidDates1 + validFrom + permitValidDates2 + validTo + permitValidDates3 ,validFrom, validTo)));

            Address address = new Address();

            //to do
            jsonObject.put("ListOfBoxes", ListInformationBoxes);

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(address);

            jsonObject.put("address",json);

        }

        // Ge the recipient.
        if (jsonObject.has(templateKeyNames.RECIPIENT_EMAIL)) {
            exchange.getOut().setHeader("recipient_email", jsonObject.getString(templateKeyNames.RECIPIENT_EMAIL));
        }

        // Set the body of the mesage
        exchange.getOut().setBody(jsonObject.toString());
    }
}
