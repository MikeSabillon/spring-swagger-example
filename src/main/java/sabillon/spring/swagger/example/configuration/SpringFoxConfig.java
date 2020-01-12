package sabillon.spring.swagger.example.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SpringFoxConfig {

    private static final String PACKAGE = "sabillon.spring.swagger.example.controller.impl";

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Swagger example project",
                "A small project showing how to document spring apis with swagger tool/plugin",
                "1.0.0",
                "None",
                new Contact("Miguel Sabillon",
                        "https://github.com/MikeSabillon",
                        "mikesabillon2014@gmail.com"),
                "Free of use",
                "Free of use",
                Collections.emptyList()
        );
    }

}
