package br.com.tqi.creditanalysis.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contact() {
        return new Contact("Rafael Fontes",
                "https://github.com/fontesrafa",
                "rafaelfontes777@hotmail.com");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Credit Analysis")
                .description("Credit Analysis API for loan applications.")
                .version("1.0")
                .termsOfServiceUrl("Terms of use: OpenSource")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(this.contact())
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.tqi.creditanalysis.resources"))
                .paths(PathSelectors.any())
                .build()
                .consumes(new HashSet<>(Arrays.asList("application/json")))
                .produces(new HashSet<>(Arrays.asList("application/json")))
                .pathMapping("/");
    }
}