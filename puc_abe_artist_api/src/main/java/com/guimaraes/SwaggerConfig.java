package com.guimaraes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.guimaraes.constant.AppConstants;
import com.guimaraes.constant.DocConstants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket detalheApi() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket.select().apis(RequestHandlerSelectors.basePackage(DocConstants.APP_BASE_PACKAGE))
				.paths(PathSelectors.any()).build().apiInfo(this.informacoesApi().build());

		return docket;
	}

	private ApiInfoBuilder informacoesApi() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title(DocConstants.APP_TITLE);
		apiInfoBuilder.description(DocConstants.APP_DESCRIPTION);
		apiInfoBuilder.version(AppConstants.VERSION_V1);
		apiInfoBuilder.contact(this.contato());

		return apiInfoBuilder;

	}

	private Contact contato() {

		return new Contact(DocConstants.APP_AUTHOR_NAME, null, DocConstants.APP_AUTHOR_EMAIL);
	}
}