package com.spring.transaction.test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.transaction.model.Wallet;
import com.spring.transaction.test.controller.TestWalletController;
import com.spring.transaction.test.service.WalletService;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTestApplication {
	
	private MockMvc mockMvc;

	@Mock
	private WalletService walletServiceMock;
	
	//https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/
	//https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-configuration/
	@Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new TestWalletController(messageSource(), walletServiceMock))
                .setHandlerExceptionResolvers(exceptionResolver())
                .setValidator(validator())
                .setViewResolvers(viewResolver())
                .build();
    }
	
	private HandlerExceptionResolver exceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
 
        Properties exceptionMappings = new Properties();
 
        exceptionMappings.put("com.spring.transaction.exception.NotFoundException", "error/404");
        exceptionMappings.put("java.lang.Exception", "error/error");
        exceptionMappings.put("java.lang.RuntimeException", "error/error");
 
        exceptionResolver.setExceptionMappings(exceptionMappings);
 
        Properties statusCodes = new Properties();
 
        statusCodes.put("error/404", "404");
        statusCodes.put("error/error", "500");
 
        exceptionResolver.setStatusCodes(statusCodes);
 
        return exceptionResolver;
    }
 
    private MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
 
        messageSource.setBasename("i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
 
        return messageSource;
    }
 
    private LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
 
    private ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
 
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/jsp/");
//        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }
	
//	@Before
//    public void setUp() {
//        //We have to reset our mock between tests because the mock objects
//        //are managed by the Spring container. If we would not reset them,
//        //stubbing and verified behavior would "leak" from one test to another.
//        Mockito.reset(walletServiceMock);
// 
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
	
	@Test
	public void insertWalletDocumentsFromJSON() {
		try {
			List<Wallet> content = new ObjectMapper().readValue(ResourceUtils.getFile("classpath:json/put-wallet_code.json"), new TypeReference<List<Wallet>>() {});
			mockMvc.perform(MockMvcRequestBuilders.post("/wallet/test/saveAll")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(content)))
			.andExpect(MockMvcResultMatchers.status().isCreated());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
