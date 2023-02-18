package lk.ijse.easycar.config;

import lk.ijse.easycar.advicor.AppWideExceptionHandler;
import lk.ijse.easycar.controller.CustomerController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {CustomerController.class, AppWideExceptionHandler.class})
public class WebAppConfig {
}
