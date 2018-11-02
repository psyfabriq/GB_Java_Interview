package ru.psyfabriq.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "ru.psyfabriq.controller"})
public class WebMvcConfig implements WebMvcConfigurer {

   @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }

   @Bean
   public MessageSource messageSource() {
      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
      source.setBasename("messages");
      return source;
   }

   @Override
   public void addFormatters(FormatterRegistry formatterRegistry) {

   }

   @Override
   public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

   }

   @Override
   public Validator getValidator() {
      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
      validator.setValidationMessageSource(messageSource());
      return validator;
   }

   @Override
   public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

   }

   @Override
   public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

   }

   @Override
   public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

   }

   @Override
   public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

   }

   @Override
   public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

   }

   @Override
   public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

   }

   @Override
   public void addInterceptors(InterceptorRegistry interceptorRegistry) {

   }

   @Override
   public MessageCodesResolver getMessageCodesResolver() {
      return null;
   }

   @Override
   public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

   }

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

   }

   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

   }
}
