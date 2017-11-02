package pl.polsl.aei.inf.mgr.mb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;

@SpringBootApplication
@ComponentScan(basePackages = "pl.polsl.aei.inf.mgr.mb.*")
@EnableJpaRepositories(basePackages = "pl.polsl.aei.inf.mgr.mb.repositories", repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class)
@EntityScan(basePackages = "pl.polsl.aei.inf.mgr.mb.model")
//@PropertySource({"classpath:datasource.properties","classpath:datasource-${spring.profiles.active}.properties"})
@PropertySource({"classpath:datasource.properties"})
@EnableAutoConfiguration
public class CommunicationLayersApplication
{
	public static void main(final String[] args)
	{
		SpringApplication.run(CommunicationLayersApplication.class, args);
	}
}
