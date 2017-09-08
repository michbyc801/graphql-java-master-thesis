package pl.polsl.aei.inf.mgr.mb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "pl.polsl.aei.inf.mgr.mb.*")
@EnableJpaRepositories(basePackages = "pl.polsl.aei.inf.mgr.mb.repositories")
@EntityScan(basePackages = "pl.polsl.aei.inf.mgr.mb.model")
@PropertySource("classpath:datasource.properties")
public class CommunicationLayersApplication
{

    public static void main(String[] args) {
        SpringApplication.run(CommunicationLayersApplication.class, args);
    }
}
