package buyerdemo.application.Buyerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication

public class BuyerAppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerAppDemoApplication.class, args);
	}

}
