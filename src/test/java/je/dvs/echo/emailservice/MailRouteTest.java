//package je.dvs.echo.emailservice;
//
//import com.google.gson.Gson;
//import je.dvs.echo.emailservice.Config.PdfGeneratorUtil;
//import je.dvs.echo.emailservice.Objects.VehicleExemptionLicense;
//import je.dvs.echo.emailservice.Service.ThymeleafEngine;
//import org.apache.camel.*;
//import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.component.mock.MockEndpoint;
//import org.apache.camel.impl.DefaultAttachment;
//import org.apache.camel.test.junit4.CamelTestSupport;
//import org.junit.After;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.jvnet.mock_javamail.Mailbox;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
//import java.util.Map;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Ignore
//public class MailRouteTest extends CamelTestSupport {
//
//    String EMAIL_QUEUE = "direct:email";
//    String LOGGER_QUEUE = "log";
//    Gson gson = new Gson();
//
//    @Autowired
//    ThymeleafEngine thymeleafEngine;
//
//    @Autowired
//    PdfGeneratorUtil pdfGeneratorUtil;
//
//    @Autowired
//    VehicleExemptionLicense vehicleExemptionLicense;
//
//
//    @Test
//    public void testSendAndReceiveMails() throws Exception
//    {
//        Endpoint endpoint = context.getEndpoint(EMAIL_QUEUE);
//
//        // create the exchange with the mail message that is multipart with a file and a Hello World text/plain message.
//        Exchange exchange = endpoint.createExchange();
//        Message in = exchange.getIn();
//        in.setBody("{\"address\":{\"departmentName\":\"Transport and Technical Services Department\",\"subDepartmentName\":\"Transport-Driver and Vehicle Standards\",\"street\":\"La Route De Veulle, La Collette\",\"parish\":\"St.Helier\",\"island\":\"Jersey\",\"postcode\":\"JE1 3UE\",\"telephone\":\"+44 (0) 1534 448600\",\"fax\":\"+44 (0) 1534 448641\"},\"ListOfBoxes\":[{\"ID\":\"law\",\"Text\":\"The Inspector of Motor Traffic in pursuance of Article 78 of the Road Traffic(Jersey) Law 1956 hereby exempts the undermentioned vehicle from the provisions of Article(s) 6 of the Motor Vehicles (Construction and Use)(Jersey)Order 1998.\"},{\"ID\":\"permitted_routes\",\"Text\":\"Main roads only to and from home to the harbour also garages for repair and fuelling\"},{\"ID\":\"permit_valid_dates\",\"Text\":\"This permit is valid from 13/04/2015 and expires on 29/05/2015 but will cease to e valid on change of ownership or at any time the Inspector of Motor Traffic may determine\"}],\"Conditions\":[{\"condition_code\":\"P3\",\"condition_name\":\"A copy of the permit to be carried by the driver\"},{\"condition_code\":\"Q2\",\"condition_name\":\"This Permit is Not Transferable\"}],\"vehicle_make\":\"Nissan\",\"vehicle_model\":\"Micra\",\"registration_number\":\"J12344\",\"permit_number\":\"12344455P\",\"vehicle_width\":\"5\",\"vehicle_length\":\"10\",\"end_date\":\"24/12/2019\",\"recipient_name\":\"user_123\",\"recipient_email\":\"salkeld5@msn.com\",\"email_template\":\"P30Perm\"}");
//        in.addAttachmentObject("FileName", new DefaultAttachment(new FileDataSource("Test.pdf")));
//
//        // create a producer that can produce the exchange (= send the mail)
//        Producer producer = endpoint.createProducer();
//        // start the producer
//        producer.start();
//        // and let it go (processes the exchange by sending the email)
//        producer.process(exchange);
//
//        // END SNIPPET: e1
//
//        // need some time for the mail to arrive on the inbox (consumed and sent to the mock)
//        Thread.sleep(500);
//
//        MockEndpoint mock = getMockEndpoint("mock:result");
//        mock.expectedMessageCount(1);
//        Exchange out = mock.assertExchangeReceived(0);
//        mock.assertIsSatisfied();
//
//
//        // attachment
//        Map<String, DataHandler> attachments = out.getIn().getAttachments();
//        assertNotNull("Should have attachments", attachments);
//        assertEquals(1, attachments.size());
//
//        Attachment handler = out.getIn().getAttachmentObject("FileName");
//        assertNotNull("The logo should be there", handler);
//
//        byte[] result = context.getTypeConverter().convertTo(byte[].class,handler.getDataHandler().getInputStream());
////
////        // content type should match
////        boolean match1 = "image/jpeg; name=logo.jpeg".equals(handler.getContentType());
////        boolean match2 = "application/octet-stream; name=logo.jpeg".equals(handler.getContentType());
////        assertTrue("Should match 1 or 2", match1 || match2);
//
//        // save logo for visual inspection
//        template.sendBodyAndHeader("file://target", result, Exchange.FILE_NAME, "maillogo.jpg");
//
//        producer.stop();
//
//    }
//
//    @After
//    public void TearDown()
//    {
//        Mailbox.clearAll();
//    }
//
//
//
//
//
//    @Override
//    protected RouteBuilder createRouteBuilder()
//    {
//        return new RouteBuilder() {
//            @Override
//            public void configure() throws Exception {
//                from(EMAIL_QUEUE).routeId("emailer")
//                        .log("BODY : ${body}")
////                        .choice()
////                        .when(header("REQUEST").isEqualTo(constant("printPermit")))
////                        .log("BODY : ${body}")
////                        .process(exchange -> new CamelProcessor().processEmail(exchange))
////                        .to("bean:pdfGeneratorUtil?method=createPdf(${body}, ${header.email_template})")
////                        .process(exchange -> new AttachmentProcessor().process(exchange))
////                        .end()
////                        .process(exchange -> new CamelProcessor().processEmail(exchange))
////                        .to("bean:thymeleafEngine?method=process(${body}, ${header.email_template})")
////                        .setHeader("to",simple("${header.recipient_email}")) //camel mail needs recipient in header
////                        .setHeader("subject", simple("Drive Jersey Documents"))
//                        .to("mock:result");
//            }
//        };
//    }
//}
