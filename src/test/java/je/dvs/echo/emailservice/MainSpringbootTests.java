package je.dvs.echo.emailservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import je.dvs.echo.emailservice.Camel.AuditProcessor;
import org.apache.camel.Body;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.json.simple.JsonObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.UUID;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Import(AuditProcessor.class)
//@Ignore
//public class MainSpringbootTests {
//
//	@Autowired
//	AuditProcessor auditProcessor;
//
//	String docUUID;
//	Exchange exchange;
//
//	@Autowired
//	ObjectMapper objectMapper;
//
//
//	@Autowired
//	CamelContext context;
//
//	@Before
//	public void SetUp()
//	{
//		JsonObject Body = new JsonObject();
//		Body.put("exchange", "exchange");
//
//		exchange = new DefaultExchange(context);
//		docUUID = UUID.randomUUID().toString();
//		exchange.getIn().setHeader("docUUID", docUUID);
//		exchange.getIn().setBody(Body);
//
//	}
//
//	@Test
//	public void contextLoads() {
//	}
//
//	@Test
//	public void Test_AuditProcessor() throws Exception {
//
//		auditProcessor.process(exchange);
//
//	}
//
//
//}
