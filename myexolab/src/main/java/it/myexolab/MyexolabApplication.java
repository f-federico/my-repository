package it.myexolab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Version;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@OpenAPIDefinition(info = @Info(title = "Exolab", version="2.0") )

public class MyexolabApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyexolabApplication.class, args);
	}

}
