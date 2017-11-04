package com.niit.Backend.Config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.niit.Backend.Model.Blog;
import com.niit.Backend.Model.BlogComment;
import com.niit.Backend.Model.Forum;
import com.niit.Backend.Model.ForumComment;
import com.niit.Backend.Model.Friend;
import com.niit.Backend.Model.Job;
import com.niit.Backend.Model.UploadFile;
import com.niit.Backend.Model.User;

@Configuration
@ComponentScan(basePackages="com.niit.Backend")
@EnableTransactionManagement



public class DBConfig {
@Bean
	public DataSource getOracleDataSource()
	{
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
				driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
				driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
				driverManagerDataSource.setUsername("social");
				driverManagerDataSource.setPassword("social");
				return driverManagerDataSource;
	}
		public Properties getHibernateProperties()
		{
			Properties properties = new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto","update");
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			//properties.setProperty("","");
			
			return properties;
			
		}
		
@Autowired
@Bean
public SessionFactory getSessionFactory()
{
	LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getOracleDataSource());
	localSessionFactoryBuilder.addProperties(getHibernateProperties());
	localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
	localSessionFactoryBuilder.addAnnotatedClass(User.class);
	localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
	localSessionFactoryBuilder.addAnnotatedClass(Job.class);
	localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
	localSessionFactoryBuilder.addAnnotatedClass(UploadFile.class);
	localSessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
	
	return localSessionFactoryBuilder.buildSessionFactory();
}
		
@Autowired
@Bean
public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
{
	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	transactionManager.setSessionFactory(sessionFactory);
	System.out.println("Data Source Created");
	return transactionManager;
}
}

		
		
