package spring_hibernate.test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.hibernate.boot.model.relational.Database;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_hibernate.dao.Bookshop;
import spring_hibernate.dao.BookshopImpl;
import spring_hibernate.service.BookShopService;


class SpringHibernateTest {
	
	private ApplicationContext ctx = null;
	private BookShopService bookShopService=null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopService=ctx.getBean(BookShopService.class);
	}
	@Test
	public void testPurchase() {
//		bookShopService.purchase("Alan", 1001);
		bookShopService.multipleBuy("Alan", Arrays.asList(1001,1002));
	}

	
	@Test
	public void test() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
		
	}

}
