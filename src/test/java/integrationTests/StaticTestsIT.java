package integrationTests;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import testUtils.AutowireTestClass;
import tstComUtils.CommonUtils;
import tstConfig.AppConfig;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import sampleDTO.SampleDTO;

import java.io.IOException;

@RunWith(SpringIntegrationSerenityRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class StaticTestsIT {

    CommonUtils cu = new CommonUtils();
    SampleDTO sd = new SampleDTO();

    @Autowired
    private AutowireTestClass autowireTestClass;

    @Before
    public void initialseTest() throws IOException {

        cu.getStaticJSON("src/test/resources/SampleJSONResponse/sample.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

    }


    @Test
    public void ATest()
    {
        System.out.println("from staticTestsIT : " + autowireTestClass.getMyText());
        assert(true);
    }

}
