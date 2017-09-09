package com.niit.Backend.Config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.niit.Backend.Model.Blog;

@Configuration
@ComponentScan(basePackages="com.niit")
@EnableTransactionManagement



public class DBConfig {
@Bean(name="dataSource")
	public DataSource getOracleDataSource()
	{
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
				driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.oracleDriver");
				driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
				driverManagerDataSource.setUsername("hr");
				driverManagerDataSource.setPassword("hr");
				return driverManagerDataSource;
	}
		public Properties getHibernateProperties()
		{
			Properties properties = new Properties();
			properties.setProperty("hibernate.hbml2ddl.auto","update");
			properties.put("hibernate.dialect", "org.hibernate.dialect.oracle 10g");
			return properties;
			
		}
@Bean
public SessionFactory getSessionFactory()
{
	LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(null);
	localSessionFactoryBuilder.addProperties(getHibernateProperties());
	return localSessionFactoryBuilder.buildSessionFactory();
}

@Bean
public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
{
	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	System.out.println("Data Source Created");
	return transactionManager;
}
}

		
		
