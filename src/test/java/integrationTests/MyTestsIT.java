package integrationTests;

import com.github.wnameless.json.flattener.JsonFlattener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import testUtils.AutowireTestClass;
import tstConfig.AppConfig;
import io.restassured.response.Response;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.serenitybdd.rest.RestRequests;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import domainDtos.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import com.jayway.jsonpath.*;

@RunWith(SpringIntegrationSerenityRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class MyTestsIT {

    @Autowired
    //@Qualifier("bean1")
    private AutowireTestClass autowireTestClass;

    Map<String, String> rightHereMap = new HashMap<String, String>()
    {
        {
            put("query", "Churchgate");
            put("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg");
        }
    };

    @Test
    public void firstTest()
    {
        autowireTestClass.setMyText("** HELLO **");
        System.out.println("Setting AutowireTestClass to : " + autowireTestClass.getMyText());

        googleData googleData = RestRequests.given().queryParams(rightHereMap).
                get("/maps/api/place/textsearch/json").as(domainDtos.googleData.class);

        // checking the size
        assertThat(googleData.getResults(), is(IsCollectionWithSize.hasSize(1)));

        // checking a particular value for a node
        assertThat(googleData.getResults().get(0).getGeometry().getLocation().getLat(), is(18.9322453));


        // find if any of the node contains a particular value

        // find total number of occurance of a particular value eg all males

        // find out that a particular node only contains oce of the valid values eccepted (eg male = unknown and male)

    }


    @Test
    // this test demonstrated how we can extract the response fron the request and then use this to
    // populate the DTO's
    public void secondTest()
    {
        Response response = RestRequests.given().queryParams(rightHereMap).
                get("/maps/api/place/textsearch/json").then().extract().response();

        System.out.println("Response: " + response.getBody().asString());
        googleData googleData = response.getBody().as(domainDtos.googleData.class);
        assertThat(googleData.getResults(), is(IsCollectionWithSize.hasSize(1)));
    }


    @Test
    //  this test uses jayway to traverse through the json response
    public void thirdTest ()
    {
        com.jayway.jsonpath.Configuration conf = com.jayway.jsonpath.Configuration.defaultConfiguration();
        conf.addOptions(Option.ALWAYS_RETURN_LIST);

        Response response = RestRequests.given().queryParams(rightHereMap).
                get("/maps/api/place/textsearch/json").then().extract().response();

        List<String> nodeValues = com.jayway.jsonpath.JsonPath.parse(response.getBody().asString()).read("$.." + "lat");

        System.out.println("node values : " + Arrays.toString((nodeValues.toArray())));
        //output node values : [18.9322453, 18.9446469, 18.926386]
    }


    @Test
    public void JSonFlattnerTest() {
        // this is probably good when you want to test for freetext in any node
        // you can just flatten the JSON rather than traversing through it.
        String json = "{ \"a\" : { \"b\" : 1, \"c\": 2, \"d\": [false, true] }, \"e\": \"f\", \"g\":2.3 }";
        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(json);
        System.out.println(flattenJson);
        flattenJson.forEach((k, v) -> System.out.println(k + " : " + v));

        for (Map.Entry<String, Object> entry : flattenJson.entrySet()) {

            if (entry.getValue().equals("f")) {
                System.out.println(" free text found ");
            }

        }
    }



}
