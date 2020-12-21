package $package;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableFeignClients
public class $mainSpringClassName {

    public static void main( String[] args )
    {
        SpringApplication.run(${mainSpringClassName}.class, args);
    }
}
