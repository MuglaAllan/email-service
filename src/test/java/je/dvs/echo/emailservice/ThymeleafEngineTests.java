//package je.dvs.echo.emailservice;
//
//import com.google.gson.Gson;
//import je.dvs.echo.emailservice.Config.PdfGeneratorUtil;
//import je.dvs.echo.emailservice.Objects.Condition;
//import je.dvs.echo.emailservice.Objects.DefaultTemplateData;
//import je.dvs.echo.emailservice.Objects.InformationBoxes;
//import je.dvs.echo.emailservice.Objects.VehicleExemptionLicense;
//import je.dvs.echo.emailservice.Service.ThymeleafEngine;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Ignore
//public class ThymeleafEngineTests {
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
//    Gson gson = new Gson();
//
//    @Test
//    public void TestThymeleafEngineDocumentTemplate_VariablesSwapName() throws Exception {
//        //Setup object
//        DefaultTemplateData defaultTemplateData = new DefaultTemplateData();
//
//        //Add data
//        defaultTemplateData.setRecipientName("user_123");
//        defaultTemplateData.setLink("linktoappear");
//        defaultTemplateData.setRecipientEmail("salkeld5@msn.com");
//        defaultTemplateData.setEmailTemplate("permit_submission");
//
//        //Create json
//        String json = gson.toJson(defaultTemplateData);
//
//        //Function call
//        String out = thymeleafEngine.process(json,"permit_submission");
//
//        System.out.println(out);
//
//    }
//
//    @Test
//    public void TestPdfGenerator() throws Exception {
//        VehicleExemptionLicense vehicleExemptionLicense = new VehicleExemptionLicense();
//
//        List<Condition> conditions = new ArrayList<>();
//        conditions.add(new Condition("P3","A copy of the permit to be carried by the driver"));
//        conditions.add(new Condition("Q2","This Permit is Not Transferable"));
//
//        List<InformationBoxes> ListInformationBoxes = new ArrayList<>();
//        ListInformationBoxes.add(new InformationBoxes("law",String.format("laws")));
//
//        //Add data
//        vehicleExemptionLicense.setRecipientName("user_123");
//        vehicleExemptionLicense.setEmailTemplate("P30Perm");
//        vehicleExemptionLicense.setRecipientEmail("salkeld5@msn.com");
//        vehicleExemptionLicense.setVehicle_length("10");
//        vehicleExemptionLicense.setVehicle_width("5");
//        vehicleExemptionLicense.setMake("Nissan");
//        vehicleExemptionLicense.setModel("Micra");
//        vehicleExemptionLicense.setRegistration_number("J12344");
//        vehicleExemptionLicense.setPermit_number("12344455P");
//        vehicleExemptionLicense.setConditions(conditions);
//        vehicleExemptionLicense.setEnd_date("24/12/2019");
//        vehicleExemptionLicense.setStart_date("12/12/2018");
//
//
//
//        //Create json
//        String json = gson.toJson(vehicleExemptionLicense);
//
//        System.out.println(json);
//
//
////
////        pdfGeneratorUtil.createPdf(json,"P30Perm");
//        pdfGeneratorUtil.createPdf(json,"P30Temp");
//    }
//
//    @Test
//    public void VehicleExemption()
//    {
//        System.out.println();
//    }
//}
