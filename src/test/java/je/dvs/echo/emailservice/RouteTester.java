package je.dvs.echo.emailservice;

import je.dvs.echo.emailservice.Camel.Routes;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.apache.camel.test.spring.MockEndpoints;
import org.apache.camel.test.spring.UseAdviceWith;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

//@RunWith(CamelSpringRunner.class)
//@ContextConfiguration(classes ={RouteTester.TestConfig.class}, loader = CamelSpringDelegatingTestContextLoader.class)
//@MockEndpoints
public class RouteTester  {
//
//    @Configuration
//    public static class TestConfig extends SingleRouteCamelConfiguration {
//        @Bean
//        @Override
//        public RouteBuilder route() {
//            return new Routes();
//        }
//    }
//
//    String START_ENDPOINT = "direct:start";
//    String RESULT_ENDPOINT = "mock:result";
//
//
//
//
//
//    @Before
//    public void testThymeleafEngineRoute_ReturnRecipientSetUp() throws Exception {
//        context.getRouteDefinition("emailer").adviceWith(context, new AdviceWithRouteBuilder() {
//            @Override
//            public void configure() {
//                replaceFromWith(START_ENDPOINT);
//                interceptSendToEndpoint("bean:thymeleafEngine?method=process(${body})")
//                        .skipSendToOriginalEndpoint()
//                        .to(RESULT_ENDPOINT);
//            }
//        });
//        context.start();
//    }
//
//     //todo currently only works with variables set which the build process won't have
//    @Test
//    public void testThymeleafEngineRoute_ReturnRecipient() throws Exception {
//        String recipientEmail = "{\"recipient_email\":\"testuser@dvs.je\",\"recipient_name\":\"test\",\"email_template\":\"permit_approved\"}";
//
//        MockEndpoint resultEndpoint = context.getEndpoint(RESULT_ENDPOINT, MockEndpoint.class);
//
//        resultEndpoint.expectedMessageCount(1);
//        resultEndpoint.expectedBodiesReceived(recipientEmail);
//
//        template.sendBodyAndHeader(START_ENDPOINT, recipientEmail, "EMAIL", "Payment");
//
//        resultEndpoint.assertIsSatisfied();
//    }
//
//    @After
//    public void testThymeleafEngineRoute_ReturnRecipientTearDown() throws Exception {
//        context.stop();
//    }
}
