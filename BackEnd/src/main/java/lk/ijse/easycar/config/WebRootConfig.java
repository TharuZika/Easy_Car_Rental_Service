package lk.ijse.easycar.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackages = "lk.ijse.easycar")
public class WebRootConfig {

    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
