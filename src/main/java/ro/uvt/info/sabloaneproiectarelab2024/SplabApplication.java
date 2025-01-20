package ro.uvt.info.sabloaneproiectarelab2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ro.uvt.info.sabloaneproiectarelab2024.difexamples.ClientComponent;
import ro.uvt.info.sabloaneproiectarelab2024.difexamples.SingletonComponent;
import ro.uvt.info.sabloaneproiectarelab2024.difexamples.TransientComponent;

@SpringBootApplication
@EnableJpaRepositories("ro.uvt.info.sabloaneproiectarelab2024.persistence")
public class SplabApplication {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
	public static void main(String[] args) {
				ApplicationContext context =
						SpringApplication.run(SplabApplication.class, args);
				TransientComponent transientBean =
						context.getBean(TransientComponent.class);
				transientBean = context.getBean(TransientComponent.class);
				SingletonComponent singletonBean =
						context.getBean(SingletonComponent.class);
				singletonBean = context.getBean(SingletonComponent.class);
				ClientComponent c = context.getBean(ClientComponent.class);
				c = (ClientComponent)context.getBean("clientComponent");
	}
}
