package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Address;
import com.niit.model.Category;
import com.niit.model.Contact;
import com.niit.model.My_Cart;
import com.niit.model.OrderTable;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement

public class DBConfig
{	
	@Bean(name = "dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl("jdbc:h2:tcp://localhost/~/honey");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		return dataSource;
	}

	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect"); //declare which dialect we use
		properties.put("hibernate.show_sql", "true"); //used to show sql commands in console
		properties.put("hibernate.hbm2ddl.auto", "update"); //used to store table automatically
		
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Address.class);
		sessionBuilder.addAnnotatedClass(Contact.class);
		sessionBuilder.addAnnotatedClass(My_Cart.class);
		sessionBuilder.addAnnotatedClass(OrderTable.class);
		sessionBuilder.scanPackages("com.niit");

		return sessionBuilder.buildSessionFactory();
		
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
		
	}

}
