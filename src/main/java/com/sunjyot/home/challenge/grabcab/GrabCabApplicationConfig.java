package com.sunjyot.home.challenge.grabcab;

import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
@Log4j
public class GrabCabApplicationConfig {

    @Bean
    public Docket api() {
        log.info("Swagger config loaded.");
        return new Docket(
                DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "grab-cab"
                , "A simple cab booking micro-service."
                , "1.0"
                , "https://github.com/ssunjyot/grab-cab"
                , new Contact("Sunjyot", "https://github.com/ssunjyot", "\"sunjyotsinghanand@gmail.com\"")
                , ""
                , ""
                , new ArrayList<VendorExtension>());

        return apiInfo;
    }

}
