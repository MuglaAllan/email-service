package je.dvs.echo.emailservice.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import je.dvs.echo.emailservice.Objects.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;

@Component
public class ThymeleafEngine {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SpringTemplateEngine templateEngine;


    Gson gson = new Gson();


    public String process (String json, String templateName) throws Exception {

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);

        Context context =  new Context();

        HashMap<String,Object> contexth = objectMapper.readValue(json,HashMap.class);

        for(Map.Entry<String,Object> entry : contexth.entrySet()){
            context.setVariable(entry.getKey(),entry.getValue());
        }




        if(templateName.equals("P30Perm") || templateName.equals("P30Temp")) {
            context.setVariable("address", new Address());
            context.setVariable("ListOfBoxes", contexth.get("ListOfBoxes"));
        }
        System.out.println("Model:" + context.getVariables());

        templateEngine.initialize();

        String html = templateEngine.process(templateName, context);

        return html;
    }




}
