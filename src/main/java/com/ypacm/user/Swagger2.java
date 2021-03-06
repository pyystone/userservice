package com.ypacm.user;


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
/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 *
 * http://localhost:8081/swagger-ui.html
 * */

@Configuration
@EnableSwagger2

public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ypacm.user"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger2构建的RESTful APIs")
                .description("ypacm 用户登录系统")
                .contact(new Contact("pyystone","http://blog.stonepyy.cn","pyystone@163.com"))
                .version("1.0")
                .build();
    }
}
