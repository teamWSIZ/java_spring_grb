package wsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"wd"})
@SpringBootApplication
public class Boot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot2Application.class, args);
	}
}
