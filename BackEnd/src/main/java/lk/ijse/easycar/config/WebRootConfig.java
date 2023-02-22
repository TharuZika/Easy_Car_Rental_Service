package lk.ijse.easycar.config;

import lk.ijse.easycar.repo.CustomerRepo;
import lk.ijse.easycar.repo.DriverRepo;
import lk.ijse.easycar.service.impl.CustomerServiceImpl;
import lk.ijse.easycar.service.impl.DriverServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackageClasses = {CustomerRepo.class, CustomerServiceImpl.class, DriverRepo.class, DriverServiceImpl.class})
public class WebRootConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
