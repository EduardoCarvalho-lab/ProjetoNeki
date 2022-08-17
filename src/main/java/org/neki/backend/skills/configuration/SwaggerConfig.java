package org.neki.backend.skills.configuration;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig{
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.neki.projeto"))
                //.paths(regex("/Pedido.*"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        @SuppressWarnings("rawtypes")
        ApiInfo apiInfo = new ApiInfo(
                "Skills API REST",
                "API REST para Neki",
                "1.0",
                "Terms of Service",
                new Contact("Eduardo","eduardocclaw@gmail.com", "https://github.com/EduardoCarvalho-lab"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
	  
    //http://localhost:8080/swagger-ui/index.html#/ - Swagger link

}
