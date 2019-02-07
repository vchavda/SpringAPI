package integrationTests;

import config.AppConfig;
import io.restassured.RestAssured;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.serenitybdd.rest.RestRequests;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import domainDtos.googleData;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringIntegrationSerenityRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class MyTestsIT {

    @Test
    public void firstTest()
    {

        Map<String, String> rightHereMap = new HashMap<String, String>()
        {
            {
                put("query", "Churchgate");
                put("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg");
            }
        };

        googleData googleData = RestRequests.given().queryParams(rightHereMap).
                get("/maps/api/place/textsearch/json").as(domainDtos.googleData.class);
        assertThat(googleData.getResults(), is(IsCollectionWithSize.hasSize(1)));
    }

}
