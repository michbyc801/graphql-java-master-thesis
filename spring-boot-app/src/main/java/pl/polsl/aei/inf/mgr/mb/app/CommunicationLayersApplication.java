package pl.polsl.aei.inf.mgr.mb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "pl.polsl.aei.inf.mgr.mb.*")
public class CommunicationLayersApplication
{

    public static void main(String[] args) {
        SpringApplication.run(CommunicationLayersApplication.class, args);
    }
}
