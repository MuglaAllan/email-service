package je.dvs.echo.emailservice.Camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultAttachment;
import org.json.JSONObject;

import javax.activation.FileDataSource;

public class AttachmentProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        try {
            JSONObject file = exchange.getIn().getBody(JSONObject.class);
            exchange.getOut().setHeaders(exchange.getIn().getHeaders());
            String receipient = exchange.getIn().getHeader("recipient_email").toString();
            String fileName =  file.getString("FileName");
            System.out.println("FileName:" + fileName);
            String path = file.getString("FilePath");
            System.out.println("FilePath:" + path);

            DefaultAttachment att = new DefaultAttachment(new FileDataSource(path));
            att.addHeader("Content-Type", "application/pdf");

            exchange.getOut().addAttachmentObject(fileName,att);

            exchange.getOut().setHeader("FileName", fileName);
            exchange.getOut().setHeader("email_template","permit_certificate");

            file.put("email_template","permit_certificate");
            file.put("recipient_email", receipient);

            exchange.getOut().setBody(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
