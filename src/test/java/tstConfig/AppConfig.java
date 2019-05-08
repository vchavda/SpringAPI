package tstConfig;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import testUtils.AutowireTestClass;

import javax.annotation.PostConstruct;

// need this bit to read property file value to propertySource
@Configuration
@ComponentScan({"testUtils.**"})
@PropertySource(value = "classpath:application.properties")
@PropertySource(value = "file:c:/test/${user}/common.properties", ignoreResourceNotFound = true)

public class AppConfig {

    // this bit will assign the property value to a variable which we can later use
    @Value("${baseURI}")
    private String baseURI;

    @Value("${user}")
    private String user;



    //The PostConstruct annotation is used on a method that needs to be executed after dependency injection is done
    // to perform any initialization. This method MUST be invoked before the class is put into service.
    @PostConstruct
    public void configureRestAssured() {
        System.out.println("vijay" + baseURI + user);
        RestAssured.baseURI = (baseURI);
        // this will log out to console the request and response
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

//    @Bean
//    public AutowireTestClass helloworld() {
//        return new AutowireTestClass();
//    }

}
